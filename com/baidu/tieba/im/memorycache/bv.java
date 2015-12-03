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
    final /* synthetic */ bu bUv;
    private final /* synthetic */ List bUw;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a bUx;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bUv = buVar;
        this.bUw = list;
        this.bUx = aVar;
        this.bUy = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.Xg().Xh();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bUw) {
                        com.baidu.tieba.im.db.i.Xl().c(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.bUx.datas) {
                        com.baidu.tieba.im.db.l.Xr().id(aVar.id);
                    }
                    if (this.bUy.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.i.Xl().c(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Xg().endTransaction();
            }
        }
        return null;
    }
}
