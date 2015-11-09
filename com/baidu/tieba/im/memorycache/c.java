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
public class c extends CustomMessageListener {
    final /* synthetic */ b bEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bEd = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean l;
        if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
            MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
            String uid = memoryGetFromDBMessage.getUid();
            if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                if (data != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo : data) {
                        if (imMessageCenterPojo != null && bw.hz(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                            this.bEd.e(imMessageCenterPojo);
                        }
                    }
                }
                this.bEd.bDX.set(true);
                this.bEd.Wr();
                return;
            }
            try {
                for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                    l = this.bEd.l(imMessageCenterPojo2);
                    if (!l || imMessageCenterPojo2.getPulled_msgId() > 0) {
                        this.bEd.e(imMessageCenterPojo2);
                    }
                }
                this.bEd.di(false);
                this.bEd.dj(false);
                this.bEd.Wo();
                this.bEd.Wp();
                this.bEd.Wq();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            this.bEd.bDX.set(true);
            this.bEd.Wr();
        }
    }
}
