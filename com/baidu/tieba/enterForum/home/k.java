package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ i bTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, int i) {
        super(i);
        this.bTq = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean aaL;
        boolean z;
        EnterForumModel enterForumModel;
        View view;
        this.bTq.bTc.abo();
        aaL = this.bTq.aaL();
        if (aaL) {
            if (this.bTq.bTc.isEmpty()) {
                com.baidu.tieba.enterForum.c.c cVar = this.bTq.bTc;
                view = this.bTq.mRootView;
                cVar.ad(view);
                return;
            }
            this.bTq.bTc.abn();
            enterForumModel = this.bTq.bTd;
            enterForumModel.al(this.bTq.bTc.abr());
        }
        z = this.bTq.bTi;
        if (z) {
            this.bTq.bTc.startPullRefresh();
        }
    }
}
