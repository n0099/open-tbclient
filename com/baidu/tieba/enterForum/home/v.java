package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ d aLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(d dVar, int i) {
        super(i);
        this.aLW = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Ik;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aLW.aLF.IT();
        Ik = this.aLW.Ik();
        if (Ik) {
            this.aLW.aLF.IS();
            cVar = this.aLW.aLG;
            cVar.L(this.aLW.aLF.IV());
            cVar2 = this.aLW.aLG;
            cVar2.eY(this.aLW.aLF.IJ());
        }
        z = this.aLW.aLK;
        if (z) {
            this.aLW.aLF.nw();
        }
    }
}
