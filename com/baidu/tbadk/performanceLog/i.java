package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.performanceLog.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e awS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.awS = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        e.a aVar;
        int i;
        if (customResponsedMessage != null && (aVar = (e.a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.awS.mId) {
            e eVar = this.awS;
            i = eVar.awM;
            eVar.awM = i + 1;
            this.awS.fB(aVar.awT);
            this.awS.ey(aVar.awU);
            this.awS.DK();
        }
    }
}
