package com.baidu.tieba.homepage.framework.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ e cxB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.cxB = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            this.cxB.eR(((Boolean) customResponsedMessage.getData()).booleanValue() && this.cxB.aje());
        }
    }
}
