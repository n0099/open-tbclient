package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(l lVar, int i) {
        super(i);
        this.bHc = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Xv;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.bHc.bGJ.Yg();
        Xv = this.bHc.Xv();
        if (Xv) {
            this.bHc.bGJ.Yf();
            cVar = this.bHc.bGK;
            cVar.aj(this.bHc.bGJ.Yk());
            cVar2 = this.bHc.bGK;
            cVar2.hr(this.bHc.bGJ.XU());
        }
        z = this.bHc.bGP;
        if (z) {
            this.bHc.bGJ.kv();
        }
    }
}
