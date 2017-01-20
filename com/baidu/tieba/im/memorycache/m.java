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
    final /* synthetic */ b cZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cZS = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> aqs = com.baidu.tieba.im.db.i.aqq().aqs();
        long ls = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.aoF().ls(11);
        long ls2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.aoF().ls(12);
        if (aqs == null) {
            aqs = new LinkedList<>();
        }
        if (ls != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            aqs.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bL(ls));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (ls2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            aqs.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bL(ls2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(aqs, data);
    }
}
