package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class am implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bjW;
    private final /* synthetic */ SocketResponsedMessage bjY;
    final /* synthetic */ al bke;
    private final /* synthetic */ ChatMessage val$chatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bke = alVar;
        this.bjW = imMessageCenterPojo;
        this.val$chatMessage = chatMessage;
        this.bjY = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.PO().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.PO().PP();
                com.baidu.tieba.im.db.k.PT().a(this.bjW, 3);
                if (this.bjW.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.n.PZ().a(this.val$chatMessage.getUserId(), this.val$chatMessage.getToUserId(), String.valueOf(this.val$chatMessage.getRecordId()), String.valueOf(this.val$chatMessage.getMsgId()), this.val$chatMessage.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.m.PY().a(this.val$chatMessage.getUserId(), this.val$chatMessage.getToUserId(), String.valueOf(this.val$chatMessage.getRecordId()), String.valueOf(this.val$chatMessage.getMsgId()), this.val$chatMessage.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(2016012, this.bjY);
            }
        }
        return null;
    }
}
