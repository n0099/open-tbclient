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
    final /* synthetic */ b bEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.bEd = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> Uh = com.baidu.tieba.im.db.i.Uf().Uh();
        long ha = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.St().ha(11);
        long ha2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.St().ha(12);
        if (Uh == null) {
            Uh = new LinkedList<>();
        }
        if (ha != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            Uh.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.aJ(ha));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (ha2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            Uh.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.aJ(ha2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(Uh, data);
    }
}
