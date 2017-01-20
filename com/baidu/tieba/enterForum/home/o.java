package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ l bxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar, int i) {
        super(i);
        this.bxV = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Ux;
        boolean z;
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        this.bxV.bxC.Vi();
        Ux = this.bxV.Ux();
        if (Ux) {
            this.bxV.bxC.Vh();
            enterForumModel = this.bxV.bxD;
            enterForumModel.ag(this.bxV.bxC.Vm());
            enterForumModel2 = this.bxV.bxD;
            enterForumModel2.hs(this.bxV.bxC.UV());
        }
        z = this.bxV.bxI;
        if (z) {
            this.bxV.bxC.startPullRefresh();
        }
    }
}
