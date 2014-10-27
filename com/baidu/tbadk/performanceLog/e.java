package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a YE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.YE = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        f fVar;
        int i;
        if (customResponsedMessage != null && (fVar = (f) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.YE.mId) {
            a aVar = this.YE;
            i = aVar.Yy;
            aVar.Yy = i + 1;
            this.YE.dM(fVar.YF);
            this.YE.dl(fVar.YG);
            this.YE.uA();
        }
    }
}
