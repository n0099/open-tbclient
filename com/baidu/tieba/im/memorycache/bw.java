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
    final /* synthetic */ bv bnk;
    private final /* synthetic */ List bnl;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar, List list, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bnk = bvVar;
        this.bnl = list;
        this.bnm = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.Rq().Rr();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bnl) {
                        com.baidu.tieba.im.db.k.Rv().a(imMessageCenterPojo);
                    }
                    if (this.bnm.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.k.Rv().a(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Rq().endTransaction();
            }
        }
        return null;
    }
}
