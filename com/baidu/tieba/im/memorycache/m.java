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
    final /* synthetic */ b cSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cSe = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> amQ = com.baidu.tieba.im.db.i.amO().amQ();
        long kw = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.alc().kw(11);
        long kw2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.alc().kw(12);
        if (amQ == null) {
            amQ = new LinkedList<>();
        }
        if (kw != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            amQ.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bM(kw));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (kw2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            amQ.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bM(kw2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(amQ, data);
    }
}
