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
    final /* synthetic */ b daI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.daI = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> apF = com.baidu.tieba.im.db.j.apD().apF();
        long lj = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.anT().lj(11);
        long lj2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.anT().lj(12);
        if (apF == null) {
            apF = new LinkedList<>();
        }
        if (lj != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            apF.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bM(lj));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (lj2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            apF.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bM(lj2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(apF, data);
    }
}
