package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ i bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(i iVar, int i) {
        super(i);
        this.bMN = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Xo;
        boolean z;
        Xo = this.bMN.Xo();
        if (!Xo) {
            this.bMN.Xp();
        } else {
            this.bMN.Xr();
        }
        z = this.bMN.bMG;
        if (z) {
            this.bMN.bMB.startPullRefresh();
        }
    }
}
