package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ l bHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar, int i) {
        super(i);
        this.bHl = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean WU;
        boolean z;
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        this.bHl.bGS.XF();
        WU = this.bHl.WU();
        if (WU) {
            this.bHl.bGS.XE();
            enterForumModel = this.bHl.bGT;
            enterForumModel.ae(this.bHl.bGS.XJ());
            enterForumModel2 = this.bHl.bGT;
            enterForumModel2.hx(this.bHl.bGS.Xs());
        }
        z = this.bHl.bGY;
        if (z) {
            this.bHl.bGS.startPullRefresh();
        }
    }
}
