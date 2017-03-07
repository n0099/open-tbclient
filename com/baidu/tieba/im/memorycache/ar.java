package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ar implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao ddp;
    private final /* synthetic */ ImMessageCenterPojo ddr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.ddp = aoVar;
        this.ddr = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        try {
            com.baidu.tieba.im.db.g.apF().apG();
            com.baidu.tieba.im.db.c.apB().kg(this.ddr.getGid());
            com.baidu.tieba.im.db.i.apK().c(this.ddr);
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.tieba.im.db.g.apF().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    }
}
