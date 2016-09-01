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
    final /* synthetic */ b dgJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.dgJ = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        LinkedList<ImMessageCenterPojo> asq = com.baidu.tieba.im.db.i.aso().asq();
        long lf = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.aqC().lf(11);
        long lf2 = com.baidu.tieba.im.chat.receiveChatMsgHandler.p.aqC().lf(12);
        if (asq == null) {
            asq = new LinkedList<>();
        }
        if (lf != -1) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            asq.add(imMessageCenterPojo);
            imMessageCenterPojo.setCustomGroupType(7);
            imMessageCenterPojo.setGid(String.valueOf(11));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.cd(lf));
            imMessageCenterPojo.setIs_hidden(1);
        }
        if (lf2 != -1) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            asq.add(imMessageCenterPojo2);
            imMessageCenterPojo2.setCustomGroupType(8);
            imMessageCenterPojo2.setGid(String.valueOf(12));
            imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.g.cd(lf2));
            imMessageCenterPojo2.setIs_hidden(1);
        }
        return new MemoryGetFromDBMessage(asq, data);
    }
}
