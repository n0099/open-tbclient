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
public class by implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ bx dbY;
    private final /* synthetic */ List dbZ;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a dca;
    private final /* synthetic */ MemoryClearStrangerItemsMessage dcb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.dbY = bxVar;
        this.dbZ = list;
        this.dca = aVar;
        this.dcb = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.apy().apz();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.dbZ) {
                        com.baidu.tieba.im.db.j.apD().c(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.dca.datas) {
                        com.baidu.tieba.im.db.m.apJ().kk(aVar.id);
                    }
                    if (this.dcb.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.j.apD().c(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.apy().endTransaction();
            }
        }
        return null;
    }
}
