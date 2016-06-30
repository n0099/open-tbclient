package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ a cqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(a aVar, int i) {
        super(i);
        this.cqR = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdTypeListView bdTypeListView;
        com.baidu.tieba.play.f fVar;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        bdTypeListView = this.cqR.bou;
        if (bdTypeListView != null) {
            fVar = this.cqR.aIG;
            fVar.aTy();
            this.cqR.cqC = false;
            bdTypeListView2 = this.cqR.bou;
            bdTypeListView2.k(2000L);
            bdTypeListView3 = this.cqR.bou;
            bdTypeListView3.jB();
        }
    }
}
