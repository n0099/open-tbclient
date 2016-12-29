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
    final /* synthetic */ b cSK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cSK = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> apl = com.baidu.tieba.im.db.i.apj().apl();
        long kF = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.anx().kF(11);
        long kF2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.anx().kF(12);
        if (apl == null) {
            apl = new LinkedList<>();
        }
        if (kF != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            apl.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bQ(kF));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (kF2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            apl.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bQ(kF2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(apl, data);
    }
}
