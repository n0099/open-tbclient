package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ b bDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.bDI = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> TQ = com.baidu.tieba.im.db.i.TO().TQ();
        long gN = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.Sb().gN(11);
        long gN2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.Sb().gN(12);
        if (TQ == null) {
            TQ = new LinkedList<>();
        }
        if (gN != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            TQ.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.aL(gN));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (gN2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            TQ.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.aL(gN2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(TQ, data);
    }
}
