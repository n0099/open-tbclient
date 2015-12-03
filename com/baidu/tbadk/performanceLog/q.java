package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.performanceLog.o;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ o ayj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i) {
        super(i);
        this.ayj = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        o.a aVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (customResponsedMessage != null && (aVar = (o.a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.ayj.mId) {
            this.ayj.fR(aVar.axO);
            this.ayj.eK(aVar.axP);
            this.ayj.fS(aVar.ayk);
            arrayList = this.ayj.axD;
            if (arrayList != null) {
                arrayList2 = this.ayj.axD;
                if (arrayList2.size() >= 20) {
                    this.ayj.EH();
                }
            }
        }
    }
}
