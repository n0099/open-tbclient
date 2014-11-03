package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c bdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.bdi = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean j;
        if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
            MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
            String uid = memoryGetFromDBMessage.getUid();
            if (!TextUtils.isEmpty(uid) && uid.equals(TbadkApplication.getCurrentAccount())) {
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo : memoryGetFromDBMessage.getData()) {
                        j = this.bdi.j(imMessageCenterPojo);
                        if (!j || imMessageCenterPojo.getPulled_msgId() > 0) {
                            this.bdi.c(imMessageCenterPojo);
                        }
                    }
                    this.bdi.dh(false);
                    this.bdi.di(false);
                    this.bdi.PO();
                    this.bdi.PP();
                    this.bdi.PQ();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.bdi.bdc.set(true);
                this.bdi.PR();
            }
        }
    }
}
