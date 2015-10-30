package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.performanceLog.o;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ o axp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i) {
        super(i);
        this.axp = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        o.a aVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (customResponsedMessage != null && (aVar = (o.a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.axp.mId) {
            this.axp.fB(aVar.awU);
            this.axp.ey(aVar.awV);
            this.axp.fC(aVar.axq);
            arrayList = this.axp.awK;
            if (arrayList != null) {
                arrayList2 = this.axp.awK;
                if (arrayList2.size() >= 20) {
                    this.axp.DN();
                }
            }
        }
    }
}
