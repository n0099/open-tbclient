package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aq implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ an bEI;
    private final /* synthetic */ ImMessageCenterPojo bEK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(an anVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEI = anVar;
        this.bEK = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.TF().TG();
            com.baidu.tieba.im.db.c.TB().hJ(this.bEK.getGid());
            com.baidu.tieba.im.db.i.TK().c(this.bEK);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.TF().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    }
}
