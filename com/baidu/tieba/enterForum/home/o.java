package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ l bFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar, int i) {
        super(i);
        this.bFb = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Vv;
        boolean z;
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        this.bFb.bEI.Wg();
        Vv = this.bFb.Vv();
        if (Vv) {
            this.bFb.bEI.Wf();
            enterForumModel = this.bFb.bEJ;
            enterForumModel.ad(this.bFb.bEI.Wk());
            enterForumModel2 = this.bFb.bEJ;
            enterForumModel2.ho(this.bFb.bEI.VT());
        }
        z = this.bFb.bEO;
        if (z) {
            this.bFb.bEI.startPullRefresh();
        }
    }
}
