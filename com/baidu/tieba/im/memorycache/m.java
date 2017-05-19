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
    final /* synthetic */ b cXb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cXb = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> anz = com.baidu.tieba.im.db.j.anx().anz();
        long lc = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.alN().lc(11);
        long lc2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.alN().lc(12);
        if (anz == null) {
            anz = new LinkedList<>();
        }
        if (lc != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            anz.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bx(lc));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (lc2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            anz.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bx(lc2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(anz, data);
    }
}
