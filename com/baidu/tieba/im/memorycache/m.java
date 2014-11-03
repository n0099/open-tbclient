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
    final /* synthetic */ c bdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.bdi = cVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> ML = com.baidu.tieba.im.db.k.MJ().ML();
        long fs = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.KQ().fs(11);
        long fs2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.KQ().fs(12);
        if (ML == null) {
            ML = new LinkedList<>();
        }
        if (fs != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            ML.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.chat.bu.F(fs));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (fs2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            ML.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.chat.bu.F(fs2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(ML, data);
    }
}
