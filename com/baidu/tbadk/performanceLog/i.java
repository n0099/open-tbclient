package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.performanceLog.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e azr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.azr = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        e.a aVar;
        int i;
        if (customResponsedMessage != null && (aVar = (e.a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.azr.mId) {
            e eVar = this.azr;
            i = eVar.azk;
            eVar.azk = i + 1;
            this.azr.fV(aVar.azs);
            this.azr.eE(aVar.azt);
            this.azr.Eq();
        }
    }
}
