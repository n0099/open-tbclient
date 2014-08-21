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
    final /* synthetic */ ak a;
    private final /* synthetic */ ImMessageCenterPojo b;
    private final /* synthetic */ ChatMessage c;
    private final /* synthetic */ SocketResponsedMessage d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
        this.a = akVar;
        this.b = imMessageCenterPojo;
        this.c = chatMessage;
        this.d = socketResponsedMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.a().c();
            }
            if (customMessage instanceof CustomMessage) {
                com.baidu.tieba.im.db.g.a().b();
                com.baidu.tieba.im.db.k.a().a(this.b, 3);
                if (this.b.getCustomGroupType() == 2) {
                    com.baidu.tieba.im.db.o.c().a(this.c.getUserId(), this.c.getToUserId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), this.c.getLocalData().getStatus().shortValue());
                } else {
                    com.baidu.tieba.im.db.n.c().a(this.c.getUserId(), this.c.getToUserId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), this.c.getLocalData().getStatus().shortValue());
                }
                return new CustomResponsedMessage<>(2016012, this.d);
            }
        }
        return null;
    }
}
