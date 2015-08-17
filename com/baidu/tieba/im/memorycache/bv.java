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
    final /* synthetic */ bu bAX;
    private final /* synthetic */ List bAY;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a bAZ;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bAX = buVar;
        this.bAY = list;
        this.bAZ = aVar;
        this.bBa = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.SZ().Ta();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bAY) {
                        com.baidu.tieba.im.db.i.Te().a(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.bAZ.datas) {
                        com.baidu.tieba.im.db.l.Tk().hu(aVar.id);
                    }
                    if (this.bBa.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.i.Te().a(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.SZ().endTransaction();
            }
        }
        return null;
    }
}
