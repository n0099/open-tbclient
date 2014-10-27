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
    private final /* synthetic */ ChatMessage aNS;
    private final /* synthetic */ ImMessageCenterPojo bdK;
    private final /* synthetic */ SocketResponsedMessage bdM;
    final /* synthetic */ ak bdT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bdT = akVar;
        this.bdK = imMessageCenterPojo;
        this.aNS = chatMessage;
        this.bdM = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.MA().endTransaction();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.MA().MB();
                com.baidu.tieba.im.db.k.MF().a(this.bdK, 3);
                if (this.bdK.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.o.MQ().a(this.aNS.getUserId(), this.aNS.getToUserId(), String.valueOf(this.aNS.getRecordId()), String.valueOf(this.aNS.getMsgId()), this.aNS.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.n.MP().a(this.aNS.getUserId(), this.aNS.getToUserId(), String.valueOf(this.aNS.getRecordId()), String.valueOf(this.aNS.getMsgId()), this.aNS.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(2016012, this.bdM);
            }
        }
        return null;
    }
}
