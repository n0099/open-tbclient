package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ b aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(i);
        this.aPP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (((Boolean) data).booleanValue()) {
                    b bVar = this.aPP;
                    j = this.aPP.aPG;
                    bVar.aPH = currentTimeMillis - j <= 1;
                }
            }
        }
    }
}
