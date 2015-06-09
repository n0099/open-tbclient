package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import java.util.List;
/* loaded from: classes.dex */
class bw implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bv bnl;
    private final /* synthetic */ List bnm;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bnn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar, List list, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bnl = bvVar;
        this.bnm = list;
        this.bnn = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.Rr().Rs();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bnm) {
                        com.baidu.tieba.im.db.k.Rw().a(imMessageCenterPojo);
                    }
                    if (this.bnn.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.k.Rw().a(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Rr().endTransaction();
            }
        }
        return null;
    }
}
