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
    final /* synthetic */ bx cYr;
    private final /* synthetic */ List cYs;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a cYt;
    private final /* synthetic */ MemoryClearStrangerItemsMessage cYu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.cYr = bxVar;
        this.cYs = list;
        this.cYt = aVar;
        this.cYu = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.ans().ant();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.cYs) {
                        com.baidu.tieba.im.db.j.anx().c(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.cYt.datas) {
                        com.baidu.tieba.im.db.m.anD().kp(aVar.id);
                    }
                    if (this.cYu.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.j.anx().c(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.ans().endTransaction();
            }
        }
        return null;
    }
}
