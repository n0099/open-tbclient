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
    final /* synthetic */ b cbn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cbn = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> abe = com.baidu.tieba.im.db.i.abc().abe();
        long iK = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.Zp().iK(11);
        long iK2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.Zp().iK(12);
        if (abe == null) {
            abe = new LinkedList<>();
        }
        if (iK != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            abe.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.be(iK));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (iK2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            abe.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.be(iK2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(abe, data);
    }
}
