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
    final /* synthetic */ b bzO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.bzO = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> Tg = com.baidu.tieba.im.db.i.Te().Tg();
        long gw = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.Rs().gw(11);
        long gw2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.Rs().gw(12);
        if (Tg == null) {
            Tg = new LinkedList<>();
        }
        if (gw != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            Tg.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.ap(gw));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (gw2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            Tg.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.ap(gw2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(Tg, data);
    }
}
