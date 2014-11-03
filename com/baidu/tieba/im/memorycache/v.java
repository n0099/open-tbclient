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
    final /* synthetic */ u bdX;
    private final /* synthetic */ ImMessageCenterPojo bdY;
    private final /* synthetic */ ChatMessage bdZ;
    private final /* synthetic */ SocketResponsedMessage bea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bdX = uVar;
        this.bdY = imMessageCenterPojo;
        this.bdZ = chatMessage;
        this.bea = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.ME().MF();
            com.baidu.tieba.im.db.k.MJ().a(this.bdY, 3);
            com.baidu.tieba.im.db.c.MA().c(this.bdZ.getGroupId(), String.valueOf(this.bdZ.getRecordId()), String.valueOf(this.bdZ.getMsgId()), this.bdZ.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.ME().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.bea);
    }
}
