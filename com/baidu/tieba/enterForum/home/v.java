package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ d aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(d dVar, int i) {
        super(i);
        this.aMe = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Iw;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aMe.aLN.Jf();
        Iw = this.aMe.Iw();
        if (Iw) {
            this.aMe.aLN.Je();
            cVar = this.aMe.aLO;
            cVar.N(this.aMe.aLN.Jh());
            cVar2 = this.aMe.aLO;
            cVar2.fg(this.aMe.aLN.IV());
        }
        z = this.aMe.aLS;
        if (z) {
            this.aMe.aLN.nx();
        }
    }
}
