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
    final /* synthetic */ b clR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.clR = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> aeA = com.baidu.tieba.im.db.i.aey().aeA();
        long jr = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.acK().jr(11);
        long jr2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.acK().jr(12);
        if (aeA == null) {
            aeA = new LinkedList<>();
        }
        if (jr != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            aeA.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bk(jr));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (jr2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            aeA.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bk(jr2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(aeA, data);
    }
}
