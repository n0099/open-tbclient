package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ i bGZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(i iVar, int i) {
        super(i);
        this.bGZ = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Wl;
        boolean z;
        Wl = this.bGZ.Wl();
        if (!Wl) {
            this.bGZ.Wm();
        } else {
            this.bGZ.Wo();
        }
        z = this.bGZ.bGS;
        if (z) {
            this.bGZ.bGN.startPullRefresh();
        }
    }
}
