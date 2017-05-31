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
    final /* synthetic */ b dcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.dcA = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> aoz = com.baidu.tieba.im.db.j.aox().aoz();
        long lw = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.amN().lw(11);
        long lw2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.amN().lw(12);
        if (aoz == null) {
            aoz = new LinkedList<>();
        }
        if (lw != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            aoz.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bA(lw));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (lw2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            aoz.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bA(lw2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(aoz, data);
    }
}
