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
    final /* synthetic */ b dcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.dcl = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean l;
        if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
            com.baidu.tieba.im.push.f.ath().clear();
            MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
            String uid = memoryGetFromDBMessage.getUid();
            if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                if (data != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo : data) {
                        if (imMessageCenterPojo != null && bz.lH(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                            this.dcl.e(imMessageCenterPojo);
                        }
                    }
                }
                this.dcl.dce.set(true);
                this.dcl.asn();
                return;
            }
            try {
                for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                    l = this.dcl.l(imMessageCenterPojo2);
                    if (!l || imMessageCenterPojo2.getPulled_msgId() > 0) {
                        if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                            com.baidu.tieba.im.push.f.ath().init(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                        }
                        this.dcl.e(imMessageCenterPojo2);
                    }
                }
                this.dcl.fX(false);
                this.dcl.fY(false);
                this.dcl.ask();
                this.dcl.asl();
                this.dcl.asm();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            this.dcl.dce.set(true);
            this.dcl.asn();
        }
    }
}
