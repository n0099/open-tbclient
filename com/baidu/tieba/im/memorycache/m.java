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
    final /* synthetic */ c bcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.bcU = cVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> MH = com.baidu.tieba.im.db.k.MF().MH();
        long fs = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.KM().fs(11);
        long fs2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.s.KM().fs(12);
        if (MH == null) {
            MH = new LinkedList<>();
        }
        if (fs != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            MH.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.chat.bu.F(fs));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (fs2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            MH.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.chat.bu.F(fs2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(MH, data);
    }
}
