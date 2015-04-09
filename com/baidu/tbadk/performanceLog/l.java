package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ h aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(h hVar, int i) {
        super(i);
        this.aoT = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        m mVar;
        int i;
        if (customResponsedMessage != null && (mVar = (m) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.aoT.mId) {
            h hVar = this.aoT;
            i = hVar.aoN;
            hVar.aoN = i + 1;
            this.aoT.eF(mVar.aoU);
            this.aoT.ea(mVar.aoV);
            this.aoT.Cz();
        }
    }
}
