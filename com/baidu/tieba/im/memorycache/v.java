package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class v implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ u bdJ;
    private final /* synthetic */ ImMessageCenterPojo bdK;
    private final /* synthetic */ ChatMessage bdL;
    private final /* synthetic */ SocketResponsedMessage bdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bdJ = uVar;
        this.bdK = imMessageCenterPojo;
        this.bdL = chatMessage;
        this.bdM = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.MA().MB();
            com.baidu.tieba.im.db.k.MF().a(this.bdK, 3);
            com.baidu.tieba.im.db.c.Mw().c(this.bdL.getGroupId(), String.valueOf(this.bdL.getRecordId()), String.valueOf(this.bdL.getMsgId()), this.bdL.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.MA().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.bdM);
    }
}
