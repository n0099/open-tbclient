package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a YI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.YI = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        f fVar;
        int i;
        if (customResponsedMessage != null && (fVar = (f) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.YI.mId) {
            a aVar = this.YI;
            i = aVar.YC;
            aVar.YC = i + 1;
            this.YI.dM(fVar.YJ);
            this.YI.dl(fVar.YK);
            this.YI.uC();
        }
    }
}
