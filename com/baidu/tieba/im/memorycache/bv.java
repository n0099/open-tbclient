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
    final /* synthetic */ bu bBE;
    private final /* synthetic */ List bBF;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a bBG;
    private final /* synthetic */ MemoryClearStrangerItemsMessage bBH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.bBE = buVar;
        this.bBF = list;
        this.bBG = aVar;
        this.bBH = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.Tb().Tc();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.bBF) {
                        com.baidu.tieba.im.db.i.Tg().a(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.bBG.datas) {
                        com.baidu.tieba.im.db.l.Tm().hD(aVar.id);
                    }
                    if (this.bBH.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.i.Tg().a(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.Tb().endTransaction();
            }
        }
        return null;
    }
}
