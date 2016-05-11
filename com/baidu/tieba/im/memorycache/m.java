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
    final /* synthetic */ b cmP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cmP = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> aez = com.baidu.tieba.im.db.i.aex().aez();
        long iV = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.acL().iV(11);
        long iV2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.acL().iV(12);
        if (aez == null) {
            aez = new LinkedList<>();
        }
        if (iV != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            aez.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bk(iV));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (iV2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            aez.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.bk(iV2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(aez, data);
    }
}
