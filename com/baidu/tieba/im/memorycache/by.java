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
    final /* synthetic */ bx cni;
    private final /* synthetic */ List cnj;
    private final /* synthetic */ MemoryClearStrangerItemsMessage.a cnk;
    private final /* synthetic */ MemoryClearStrangerItemsMessage cnl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar, List list, MemoryClearStrangerItemsMessage.a aVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
        this.cni = bxVar;
        this.cnj = list;
        this.cnk = aVar;
        this.cnl = memoryClearStrangerItemsMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            try {
                if (customMessage instanceof CustomMessage) {
                    com.baidu.tieba.im.db.g.aet().aeu();
                    for (ImMessageCenterPojo imMessageCenterPojo : this.cnj) {
                        com.baidu.tieba.im.db.i.aey().c(imMessageCenterPojo);
                    }
                    for (MemoryModifyVisibilityMessage.a aVar : this.cnk.datas) {
                        com.baidu.tieba.im.db.l.aeE().jb(aVar.id);
                    }
                    if (this.cnl.isAllClear()) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1001");
                        imMessageCenterPojo2.setCustomGroupType(-7);
                        imMessageCenterPojo2.setIs_hidden(1);
                        com.baidu.tieba.im.db.i.aey().c(imMessageCenterPojo2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                com.baidu.tieba.im.db.g.aet().endTransaction();
            }
        }
        return null;
    }
}
