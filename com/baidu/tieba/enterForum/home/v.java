package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ d aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(d dVar, int i) {
        super(i);
        this.aMD = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean IA;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aMD.aMm.Jk();
        IA = this.aMD.IA();
        if (IA) {
            this.aMD.aMm.Jj();
            cVar = this.aMD.aMn;
            cVar.J(this.aMD.aMm.Jm());
            cVar2 = this.aMD.aMn;
            cVar2.eM(this.aMD.aMm.IZ());
        }
        z = this.aMD.aMr;
        if (z) {
            this.aMD.aMm.ny();
        }
    }
}
