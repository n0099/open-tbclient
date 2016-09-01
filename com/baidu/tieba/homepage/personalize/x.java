package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(b bVar, int i) {
        super(i);
        this.this$0 = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdTypeListView bdTypeListView;
        com.baidu.tieba.play.i iVar;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        bdTypeListView = this.this$0.bBT;
        if (bdTypeListView != null) {
            iVar = this.this$0.aNV;
            iVar.aZR();
            this.this$0.cEN = false;
            bdTypeListView2 = this.this$0.bBT;
            bdTypeListView2.l(2000L);
            bdTypeListView3 = this.this$0.bBT;
            bdTypeListView3.kv();
        }
    }
}
