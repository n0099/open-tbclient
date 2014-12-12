package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class al implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bhq;
    private final /* synthetic */ SocketResponsedMessage bhs;
    final /* synthetic */ ak bhz;
    private final /* synthetic */ ChatMessage val$chatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bhz = akVar;
        this.bhq = imMessageCenterPojo;
        this.val$chatMessage = chatMessage;
        this.bhs = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.My().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.My().Mz();
                com.baidu.tieba.im.db.k.MD().a(this.bhq, 3);
                if (this.bhq.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.o.MO().a(this.val$chatMessage.getUserId(), this.val$chatMessage.getToUserId(), String.valueOf(this.val$chatMessage.getRecordId()), String.valueOf(this.val$chatMessage.getMsgId()), this.val$chatMessage.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.n.MN().a(this.val$chatMessage.getUserId(), this.val$chatMessage.getToUserId(), String.valueOf(this.val$chatMessage.getRecordId()), String.valueOf(this.val$chatMessage.getMsgId()), this.val$chatMessage.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(2016012, this.bhs);
            }
        }
        return null;
    }
}
