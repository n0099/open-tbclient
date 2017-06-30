package com.baidu.tbadk.j;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.j.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e aHi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.aHi = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        e.a aVar;
        int i;
        if (customResponsedMessage != null && (aVar = (e.a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.aHi.mId) {
            e eVar = this.aHi;
            i = eVar.aHb;
            eVar.aHb = i + 1;
            this.aHi.gr(aVar.aHj);
            this.aHi.fc(aVar.aHk);
            this.aHi.FP();
        }
    }
}
