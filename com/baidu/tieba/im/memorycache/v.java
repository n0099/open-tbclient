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
    final /* synthetic */ u bmP;
    private final /* synthetic */ ImMessageCenterPojo bmQ;
    private final /* synthetic */ ChatMessage bmR;
    private final /* synthetic */ SocketResponsedMessage bmS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bmP = uVar;
        this.bmQ = imMessageCenterPojo;
        this.bmR = chatMessage;
        this.bmS = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.Rq().Rr();
            com.baidu.tieba.im.db.k.Rv().a(this.bmQ, 3);
            com.baidu.tieba.im.db.c.Rm().b(this.bmR.getGroupId(), String.valueOf(this.bmR.getRecordId()), String.valueOf(this.bmR.getMsgId()), this.bmR.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.Rq().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.bmS);
    }
}
