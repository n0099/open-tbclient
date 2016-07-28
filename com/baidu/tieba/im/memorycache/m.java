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
    final /* synthetic */ b cUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cUZ = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> anB = com.baidu.tieba.im.db.i.anz().anB();
        long kC = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.alN().kC(11);
        long kC2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.alN().kC(12);
        if (anB == null) {
            anB = new LinkedList<>();
        }
        if (kC != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            anB.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bH(kC));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (kC2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            anB.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bH(kC2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(anB, data);
    }
}
