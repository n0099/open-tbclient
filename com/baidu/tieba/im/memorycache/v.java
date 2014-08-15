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
    final /* synthetic */ u a;
    private final /* synthetic */ ImMessageCenterPojo b;
    private final /* synthetic */ ChatMessage c;
    private final /* synthetic */ SocketResponsedMessage d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.a = uVar;
        this.b = imMessageCenterPojo;
        this.c = chatMessage;
        this.d = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
            return null;
        }
        try {
            com.baidu.tieba.im.db.g.a().b();
            com.baidu.tieba.im.db.k.a().a(this.b, 3);
            com.baidu.tieba.im.db.c.a().b(this.c.getGroupId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), this.c.getLocalData().getStatus().shortValue());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            com.baidu.tieba.im.db.g.a().c();
        }
        return new CustomResponsedMessage<>(2016012, this.d);
    }
}
