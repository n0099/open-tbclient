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
    final /* synthetic */ b dcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.dcl = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> apM = com.baidu.tieba.im.db.i.apK().apM();
        long li = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.anZ().li(11);
        long li2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.anZ().li(12);
        if (apM == null) {
            apM = new LinkedList<>();
        }
        if (li != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            apM.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bM(li));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (li2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            apM.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bM(li2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(apM, data);
    }
}
