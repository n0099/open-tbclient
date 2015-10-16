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
    final /* synthetic */ bu bET;
    private final /* synthetic */ List bEU;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a bEV;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bEW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bET = buVar;
        this.bEU = list;
        this.bEV = aVar;
        this.bEW = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.TJ().TK();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bEU) {
                        com.baidu.tieba.im.db.i.TO().c(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.bEV.datas) {
                        com.baidu.tieba.im.db.l.TU().hH(aVar.id);
                    }
                    if (this.bEW.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.i.TO().c(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.TJ().endTransaction();
            }
        }
        return null;
    }
}
