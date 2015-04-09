package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import java.util.List;
/* loaded from: classes.dex */
class bu implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bt bkF;
    private final /* synthetic */ List bkG;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bkH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar, List list, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bkF = btVar;
        this.bkG = list;
        this.bkH = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.Qb().Qc();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bkG) {
                        com.baidu.tieba.im.db.k.Qg().a(imMessageCenterPojo);
                    }
                    if (this.bkH.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.k.Qg().a(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Qb().endTransaction();
            }
        }
        return null;
    }
}
