package com.baidu.tieba.card;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends CustomMessageListener {
    final /* synthetic */ y aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(y yVar, int i) {
        super(i);
        this.aSZ = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
            return;
        }
        this.aSZ.a(((Long) customResponsedMessage.getData()).longValue(), true);
    }
}
