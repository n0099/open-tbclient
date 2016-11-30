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
    final /* synthetic */ b dnO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.dnO = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> auM = com.baidu.tieba.im.db.i.auK().auM();
        long lv = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.asY().lv(11);
        long lv2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.asY().lv(12);
        if (auM == null) {
            auM = new LinkedList<>();
        }
        if (lv != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            auM.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.cc(lv));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (lv2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            auM.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.cc(lv2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(auM, data);
    }
}
