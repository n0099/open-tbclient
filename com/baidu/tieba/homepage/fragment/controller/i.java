package com.baidu.tieba.homepage.fragment.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ a bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(a aVar, int i) {
        super(i);
        this.bye = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.homepage.fragment.data.b bVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
            bVar = this.bye.bxX;
            bVar.e(((Long) customResponsedMessage.getData()).longValue(), true);
        }
    }
}
