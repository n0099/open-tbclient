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
    final /* synthetic */ u biK;
    private final /* synthetic */ ImMessageCenterPojo biL;
    private final /* synthetic */ ChatMessage biM;
    private final /* synthetic */ SocketResponsedMessage biN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.biK = uVar;
        this.biL = imMessageCenterPojo;
        this.biM = chatMessage;
        this.biN = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.MU().MV();
            com.baidu.tieba.im.db.k.MZ().a(this.biL, 3);
            com.baidu.tieba.im.db.c.MQ().b(this.biM.getGroupId(), String.valueOf(this.biM.getRecordId()), String.valueOf(this.biM.getMsgId()), this.biM.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.MU().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.biN);
    }
}
