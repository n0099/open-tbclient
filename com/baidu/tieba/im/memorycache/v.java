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
    final /* synthetic */ u biJ;
    private final /* synthetic */ ImMessageCenterPojo biK;
    private final /* synthetic */ ChatMessage biL;
    private final /* synthetic */ SocketResponsedMessage biM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.biJ = uVar;
        this.biK = imMessageCenterPojo;
        this.biL = chatMessage;
        this.biM = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.MP().MQ();
            com.baidu.tieba.im.db.k.MU().a(this.biK, 3);
            com.baidu.tieba.im.db.c.ML().b(this.biL.getGroupId(), String.valueOf(this.biL.getRecordId()), String.valueOf(this.biL.getMsgId()), this.biL.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.MP().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.biM);
    }
}
