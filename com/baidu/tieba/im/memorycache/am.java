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
public class am implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bmQ;
    private final /* synthetic */ SocketResponsedMessage bmS;
    final /* synthetic */ al bmY;
    private final /* synthetic */ ChatMessage val$chatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bmY = alVar;
        this.bmQ = imMessageCenterPojo;
        this.val$chatMessage = chatMessage;
        this.bmS = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Rq().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.Rq().Rr();
                com.baidu.tieba.im.db.k.Rv().a(this.bmQ, 3);
                if (this.bmQ.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.n.RB().a(this.val$chatMessage.getUserId(), this.val$chatMessage.getToUserId(), String.valueOf(this.val$chatMessage.getRecordId()), String.valueOf(this.val$chatMessage.getMsgId()), this.val$chatMessage.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.m.RA().a(this.val$chatMessage.getUserId(), this.val$chatMessage.getToUserId(), String.valueOf(this.val$chatMessage.getRecordId()), String.valueOf(this.val$chatMessage.getMsgId()), this.val$chatMessage.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(2016012, this.bmS);
            }
        }
        return null;
    }
}
