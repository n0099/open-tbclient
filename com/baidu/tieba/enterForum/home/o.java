package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ l bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar, int i) {
        super(i);
        this.bEU = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean VT;
        boolean z;
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        this.bEU.bEB.WE();
        VT = this.bEU.VT();
        if (VT) {
            this.bEU.bEB.WD();
            enterForumModel = this.bEU.bEC;
            enterForumModel.ad(this.bEU.bEB.WI());
            enterForumModel2 = this.bEU.bEC;
            enterForumModel2.hr(this.bEU.bEB.Wr());
        }
        z = this.bEU.bEH;
        if (z) {
            this.bEU.bEB.startPullRefresh();
        }
    }
}
