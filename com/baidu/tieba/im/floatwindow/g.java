package com.baidu.tieba.im.floatwindow;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ b aXq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar) {
        super(2008015);
        this.aXq = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008015) {
            this.aXq.cF(true);
        }
    }
}
