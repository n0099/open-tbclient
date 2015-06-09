package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ u bmQ;
    private final /* synthetic */ ImMessageCenterPojo bmR;
    private final /* synthetic */ ChatMessage bmS;
    private final /* synthetic */ SocketResponsedMessage bmT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bmQ = uVar;
        this.bmR = imMessageCenterPojo;
        this.bmS = chatMessage;
        this.bmT = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.Rr().Rs();
            com.baidu.tieba.im.db.k.Rw().a(this.bmR, 3);
            com.baidu.tieba.im.db.c.Rn().b(this.bmS.getGroupId(), String.valueOf(this.bmS.getRecordId()), String.valueOf(this.bmS.getMsgId()), this.bmS.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.Rr().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.bmT);
    }
}
