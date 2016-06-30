package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ k btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, int i) {
        super(i);
        this.btA = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Sb;
        boolean z;
        Sb = this.btA.Sb();
        if (!Sb) {
            this.btA.Sc();
        } else {
            this.btA.Se();
        }
        z = this.btA.btm;
        if (z) {
            this.btA.btg.jB();
        }
    }
}
