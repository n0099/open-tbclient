package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(b bVar, int i) {
        super(i);
        this.ctz = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdTypeListView bdTypeListView;
        com.baidu.tieba.play.f fVar;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        bdTypeListView = this.ctz.bqG;
        if (bdTypeListView != null) {
            fVar = this.ctz.aJx;
            fVar.aWB();
            this.ctz.cth = false;
            bdTypeListView2 = this.ctz.bqG;
            bdTypeListView2.l(2000L);
            bdTypeListView3 = this.ctz.bqG;
            bdTypeListView3.jA();
        }
    }
}
