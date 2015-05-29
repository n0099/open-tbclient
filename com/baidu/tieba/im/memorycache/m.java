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
    final /* synthetic */ c bma;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.bma = cVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> Rx = com.baidu.tieba.im.db.k.Rv().Rx();
        long fV = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.PH().fV(11);
        long fV2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.PH().fV(12);
        if (Rx == null) {
            Rx = new LinkedList<>();
        }
        if (fV != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            Rx.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.ag(fV));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (fV2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            Rx.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.h.ag(fV2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(Rx, data);
    }
}
