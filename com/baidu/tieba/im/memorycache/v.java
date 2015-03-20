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
    final /* synthetic */ u bjV;
    private final /* synthetic */ ImMessageCenterPojo bjW;
    private final /* synthetic */ ChatMessage bjX;
    private final /* synthetic */ SocketResponsedMessage bjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.bjV = uVar;
        this.bjW = imMessageCenterPojo;
        this.bjX = chatMessage;
        this.bjY = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.PO().PP();
            com.baidu.tieba.im.db.k.PT().a(this.bjW, 3);
            com.baidu.tieba.im.db.c.PK().b(this.bjX.getGroupId(), String.valueOf(this.bjX.getRecordId()), String.valueOf(this.bjX.getMsgId()), this.bjX.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.PO().endTransaction();
        }
        return new CustomResponsedMessage<>(2016012, this.bjY);
    }
}
