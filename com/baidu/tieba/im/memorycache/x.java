package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import java.util.List;
/* loaded from: classes.dex */
class x implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ w beb;
    private final /* synthetic */ List bec;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, List list, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.beb = wVar;
        this.bec = list;
        this.bed = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.ME().MF();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bec) {
                        com.baidu.tieba.im.db.k.MJ().a(imMessageCenterPojo);
                    }
                    if (this.bed.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.k.MJ().a(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.ME().endTransaction();
            }
        }
        return null;
    }
}
