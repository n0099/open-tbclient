package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(n nVar, int i) {
        super(i);
        this.this$0 = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdTypeListView bdTypeListView;
        com.baidu.tieba.play.aa aaVar;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        bdTypeListView = this.this$0.aMc;
        if (bdTypeListView != null) {
            aaVar = this.this$0.aMd;
            aaVar.alQ();
            this.this$0.cqt = false;
            bdTypeListView2 = this.this$0.aMc;
            bdTypeListView2.l(2000L);
            bdTypeListView3 = this.this$0.aMc;
            bdTypeListView3.kv();
        }
    }
}
