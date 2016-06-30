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
    final /* synthetic */ ao cTh;
    private final /* synthetic */ ImMessageCenterPojo cTj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cTh = aoVar;
        this.cTj = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.amK().amL();
            com.baidu.tieba.im.db.c.amG().ky(this.cTj.getGid());
            com.baidu.tieba.im.db.i.amO().c(this.cTj);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.amK().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    }
}
