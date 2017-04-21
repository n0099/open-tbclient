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
    final /* synthetic */ b dda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.dda = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> aqG = com.baidu.tieba.im.db.j.aqE().aqG();
        long lp = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.aoU().lp(11);
        long lp2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.aoU().lp(12);
        if (aqG == null) {
            aqG = new LinkedList<>();
        }
        if (lp != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            aqG.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bM(lp));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (lp2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            aqG.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bM(lp2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(aqG, data);
    }
}
