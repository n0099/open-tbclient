package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ i bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(i iVar, int i) {
        super(i);
        this.bMN = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Xo;
        boolean z;
        EnterForumModel enterForumModel;
        View view;
        this.bMN.bMB.XO();
        Xo = this.bMN.Xo();
        if (Xo) {
            if (this.bMN.bMB.isEmpty()) {
                com.baidu.tieba.enterForum.c.c cVar = this.bMN.bMB;
                view = this.bMN.mRootView;
                cVar.ac(view);
                return;
            }
            this.bMN.bMB.XN();
            enterForumModel = this.bMN.bMC;
            enterForumModel.af(this.bMN.bMB.XR());
        }
        z = this.bMN.bMG;
        if (z) {
            this.bMN.bMB.startPullRefresh();
        }
    }
}
