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
    final /* synthetic */ b cmP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.cmP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean l;
        if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
            com.baidu.tieba.im.push.f.ahX().clear();
            MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
            String uid = memoryGetFromDBMessage.getUid();
            if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                if (data != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo : data) {
                        if (imMessageCenterPojo != null && bz.jt(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                            this.cmP.e(imMessageCenterPojo);
                        }
                    }
                }
                this.cmP.cmI.set(true);
                this.cmP.ahe();
                return;
            }
            try {
                for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                    l = this.cmP.l(imMessageCenterPojo2);
                    if (!l || imMessageCenterPojo2.getPulled_msgId() > 0) {
                        if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                            com.baidu.tieba.im.push.f.ahX().init(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                        }
                        this.cmP.e(imMessageCenterPojo2);
                    }
                }
                this.cmP.eJ(false);
                this.cmP.eK(false);
                this.cmP.ahb();
                this.cmP.ahc();
                this.cmP.ahd();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            this.cmP.cmI.set(true);
            this.cmP.ahe();
        }
    }
}
