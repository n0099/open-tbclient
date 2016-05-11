package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ k aXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(k kVar, int i) {
        super(i);
        this.aXF = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Mw;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aXF.aXk.MD();
        Mw = this.aXF.Mw();
        if (Mw) {
            this.aXF.aXk.Nk();
            cVar = this.aXF.aXl;
            cVar.Q(this.aXF.aXk.Np());
            cVar2 = this.aXF.aXl;
            cVar2.fQ(this.aXF.aXk.MY());
        }
        z = this.aXF.aXq;
        if (z) {
            this.aXF.aXk.jy();
        }
    }
}
