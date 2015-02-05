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
    final /* synthetic */ c bhR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.bhR = cVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> MW = com.baidu.tieba.im.db.k.MU().MW();
        long fA = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.Li().fA(11);
        long fA2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.Li().fA(12);
        if (MW == null) {
            MW = new LinkedList<>();
        }
        if (fA != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            MW.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.af(fA));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (fA2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            MW.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.h.af(fA2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(MW, data);
    }
}
