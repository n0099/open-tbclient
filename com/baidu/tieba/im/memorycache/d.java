package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c bgA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.bgA = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean q;
        if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
            MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
            String uid = memoryGetFromDBMessage.getUid();
            if (!TextUtils.isEmpty(uid) && uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo : memoryGetFromDBMessage.getData()) {
                        q = this.bgA.q(imMessageCenterPojo);
                        if (!q || imMessageCenterPojo.getPulled_msgId() > 0) {
                            this.bgA.j(imMessageCenterPojo);
                        }
                    }
                    this.bgA.cW(false);
                    this.bgA.cX(false);
                    this.bgA.Qt();
                    this.bgA.Qu();
                    this.bgA.Qv();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.bgA.bgu.set(true);
                this.bgA.Qw();
            }
        }
    }
}
