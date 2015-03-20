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
    final /* synthetic */ c bjh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.bjh = cVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> PV = com.baidu.tieba.im.db.k.PT().PV();
        long fC = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.Og().fC(11);
        long fC2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.Og().fC(12);
        if (PV == null) {
            PV = new LinkedList<>();
        }
        if (fC != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            PV.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.af(fC));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (fC2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            PV.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.h.af(fC2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(PV, data);
    }
}
