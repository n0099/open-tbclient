package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aq implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ an bFd;
    private final /* synthetic */ ImMessageCenterPojo bFf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(an anVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bFd = anVar;
        this.bFf = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Ua().Ub();
            com.baidu.tieba.im.db.c.TW().hL(this.bFf.getGid());
            com.baidu.tieba.im.db.i.Uf().c(this.bFf);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.Ua().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    }
}
