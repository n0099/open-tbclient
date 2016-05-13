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
    final /* synthetic */ ao cnS;
    private final /* synthetic */ ImMessageCenterPojo cnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cnS = aoVar;
        this.cnU = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.aev().aew();
            com.baidu.tieba.im.db.c.aer().jf(this.cnU.getGid());
            com.baidu.tieba.im.db.i.aez().c(this.cnU);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.aev().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    }
}
