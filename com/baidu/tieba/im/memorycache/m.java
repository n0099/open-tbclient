package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> b = com.baidu.tieba.im.db.k.a().b();
        long a = com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a().a(11);
        long a2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.q.a().a(12);
        if (b == null) {
            b = new LinkedList<>();
        }
        if (a != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            b.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.chat.bu.b(a));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (a2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            b.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.chat.bu.b(a2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(b, data);
    }
}
