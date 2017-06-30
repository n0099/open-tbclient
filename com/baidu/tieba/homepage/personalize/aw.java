package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends CustomMessageListener {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(x xVar, int i) {
        super(i);
        this.this$0 = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdTypeListView bdTypeListView;
        com.baidu.tieba.play.ac acVar;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        bdTypeListView = this.this$0.mListView;
        if (bdTypeListView != null) {
            acVar = this.this$0.cdS;
            acVar.aog();
            this.this$0.cJd = false;
            bdTypeListView2 = this.this$0.mListView;
            bdTypeListView2.completePullRefreshPostDelayed(2000L);
            bdTypeListView3 = this.this$0.mListView;
            bdTypeListView3.startPullRefresh();
        }
    }
}
