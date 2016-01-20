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
    final /* synthetic */ bx bYj;
    private final /* synthetic */ List bYk;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a bYl;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bYm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bYj = bxVar;
        this.bYk = list;
        this.bYl = aVar;
        this.bYm = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.Ym().Yn();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bYk) {
                        com.baidu.tieba.im.db.i.Yr().c(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.bYl.datas) {
                        com.baidu.tieba.im.db.l.Yx().ir(aVar.id);
                    }
                    if (this.bYm.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.i.Yr().c(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Ym().endTransaction();
            }
        }
        return null;
    }
}
