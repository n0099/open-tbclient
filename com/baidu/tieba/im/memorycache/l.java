package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ b bTj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.bTj = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> Xn = com.baidu.tieba.im.db.i.Xl().Xn();
        long hN = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.Vz().hN(11);
        long hN2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.Vz().hN(12);
        if (Xn == null) {
            Xn = new LinkedList<>();
        }
        if (hN != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            Xn.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.aX(hN));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (hN2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            Xn.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.aX(hN2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(Xn, data);
    }
}
