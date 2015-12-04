package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ an bUk;
    private final /* synthetic */ ImMessageCenterPojo bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(an anVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bUk = anVar;
        this.bUm = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.Xg().Xh();
            com.baidu.tieba.im.db.c.Xc().ig(this.bUm.getGid());
            com.baidu.tieba.im.db.i.Xl().c(this.bUm);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.Xg().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    }
}
