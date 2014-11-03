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
    private final /* synthetic */ ChatMessage aOg;
    private final /* synthetic */ ImMessageCenterPojo bdY;
    private final /* synthetic */ SocketResponsedMessage bea;
    final /* synthetic */ ak beh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.beh = akVar;
        this.bdY = imMessageCenterPojo;
        this.aOg = chatMessage;
        this.bea = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.ME().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.ME().MF();
                com.baidu.tieba.im.db.k.MJ().a(this.bdY, 3);
                if (this.bdY.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.o.MU().a(this.aOg.getUserId(), this.aOg.getToUserId(), String.valueOf(this.aOg.getRecordId()), String.valueOf(this.aOg.getMsgId()), this.aOg.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.n.MT().a(this.aOg.getUserId(), this.aOg.getToUserId(), String.valueOf(this.aOg.getRecordId()), String.valueOf(this.aOg.getMsgId()), this.aOg.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(2016012, this.bea);
            }
        }
        return null;
    }
}
