package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c bma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.bma = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean j;
        if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
            MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
            String uid = memoryGetFromDBMessage.getUid();
            if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                if (data != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo : data) {
                        if (imMessageCenterPojo != null && bz.gs(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                            this.bma.c(imMessageCenterPojo);
                        }
                    }
                }
                this.bma.blU.set(true);
                this.bma.TH();
                return;
            }
            try {
                for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                    j = this.bma.j(imMessageCenterPojo2);
                    if (!j || imMessageCenterPojo2.getPulled_msgId() > 0) {
                        this.bma.c(imMessageCenterPojo2);
                    }
                }
                this.bma.cY(false);
                this.bma.cZ(false);
                this.bma.TE();
                this.bma.TF();
                this.bma.TG();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            this.bma.blU.set(true);
            this.bma.TH();
        }
    }
}
