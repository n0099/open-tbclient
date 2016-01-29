package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ i aWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(i iVar, int i) {
        super(i);
        this.aWN = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean LY;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aWN.aWs.ML();
        LY = this.aWN.LY();
        if (LY) {
            this.aWN.aWs.MK();
            cVar = this.aWN.aWt;
            cVar.L(this.aWN.aWs.MM());
            cVar2 = this.aWN.aWt;
            cVar2.fS(this.aWN.aWs.Mx());
        }
        z = this.aWN.aWy;
        if (z) {
            this.aWN.aWs.ns();
        }
    }
}
