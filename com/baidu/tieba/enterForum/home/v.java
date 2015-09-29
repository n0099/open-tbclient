package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ d aLL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(d dVar, int i) {
        super(i);
        this.aLL = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Ik;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aLL.aLu.IT();
        Ik = this.aLL.Ik();
        if (Ik) {
            this.aLL.aLu.IS();
            cVar = this.aLL.aLv;
            cVar.L(this.aLL.aLu.IV());
            cVar2 = this.aLL.aLv;
            cVar2.eY(this.aLL.aLu.IJ());
        }
        z = this.aLL.aLz;
        if (z) {
            this.aLL.aLu.nw();
        }
    }
}
