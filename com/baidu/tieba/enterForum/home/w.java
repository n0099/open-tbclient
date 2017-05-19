package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ i bGZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(i iVar, int i) {
        super(i);
        this.bGZ = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Wl;
        boolean z;
        EnterForumModel enterForumModel;
        View view;
        this.bGZ.bGN.WL();
        Wl = this.bGZ.Wl();
        if (Wl) {
            if (this.bGZ.bGN.isEmpty()) {
                com.baidu.tieba.enterForum.c.c cVar = this.bGZ.bGN;
                view = this.bGZ.mRootView;
                cVar.ac(view);
                return;
            }
            this.bGZ.bGN.WK();
            enterForumModel = this.bGZ.bGO;
            enterForumModel.af(this.bGZ.bGN.WO());
        }
        z = this.bGZ.bGS;
        if (z) {
            this.bGZ.bGN.startPullRefresh();
        }
    }
}
