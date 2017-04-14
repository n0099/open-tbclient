package com.baidu.tieba.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ a ffB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(a aVar, int i) {
        super(i);
        this.ffB = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            this.ffB.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
            a aVar = this.ffB;
            z = this.ffB.mHasNewVersion;
            aVar.ffe = z ? true : this.ffB.ffe;
            this.ffB.baN();
        }
    }
}
