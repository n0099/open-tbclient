package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bu bFo;
    private final /* synthetic */ List bFp;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a bFq;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bFo = buVar;
        this.bFp = list;
        this.bFq = aVar;
        this.bFr = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.Ua().Ub();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bFp) {
                        com.baidu.tieba.im.db.i.Uf().c(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.bFq.datas) {
                        com.baidu.tieba.im.db.l.Ul().hJ(aVar.id);
                    }
                    if (this.bFr.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.i.Uf().c(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Ua().endTransaction();
            }
        }
        return null;
    }
}
