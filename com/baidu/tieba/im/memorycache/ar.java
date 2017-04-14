package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao dbL;
    private final /* synthetic */ ImMessageCenterPojo dbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dbL = aoVar;
        this.dbN = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.apy().apz();
            com.baidu.tieba.im.db.c.apu().km(this.dbN.getGid());
            com.baidu.tieba.im.db.j.apD().c(this.dbN);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.apy().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    }
}
