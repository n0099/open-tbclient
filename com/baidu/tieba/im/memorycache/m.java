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
    final /* synthetic */ c bhS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.bhS = cVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> Nb = com.baidu.tieba.im.db.k.MZ().Nb();
        long fA = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.Ln().fA(11);
        long fA2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.Ln().fA(12);
        if (Nb == null) {
            Nb = new LinkedList<>();
        }
        if (fA != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            Nb.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.af(fA));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (fA2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            Nb.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.h.af(fA2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(Nb, data);
    }
}
