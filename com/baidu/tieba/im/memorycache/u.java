package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ t bER;
    private final /* synthetic */ ImMessageCenterPojo bES;
    private final /* synthetic */ ChatMessage bET;
    private final /* synthetic */ SocketResponsedMessage bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bER = tVar;
        this.bES = imMessageCenterPojo;
        this.bET = chatMessage;
        this.bEU = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.Ua().Ub();
            com.baidu.tieba.im.db.i.Uf().a(this.bES, 3);
            com.baidu.tieba.im.db.c.TW().c(this.bET.getGroupId(), String.valueOf(this.bET.getRecordId()), String.valueOf(this.bET.getMsgId()), this.bET.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.Ua().endTransaction();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.bEU);
    }
}
