package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ h afV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(h hVar, int i) {
        super(i);
        this.afV = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        m mVar;
        int i;
        if (customResponsedMessage != null && (mVar = (m) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.afV.mId) {
            h hVar = this.afV;
            i = hVar.afP;
            hVar.afP = i + 1;
            this.afV.eB(mVar.afW);
            this.afV.dQ(mVar.afX);
            this.afV.yU();
        }
    }
}
