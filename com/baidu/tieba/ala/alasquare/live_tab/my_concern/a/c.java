package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, LiveTabConcernItemViewLineHolder> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.d gCi;
    private i gCj;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.gAX);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public LiveTabConcernItemViewLineHolder e(ViewGroup viewGroup) {
        this.gCi = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.d(this.mPageContext, viewGroup);
        if (this.gCj != null) {
            this.gCi.a(this.gCj);
        }
        return new LiveTabConcernItemViewLineHolder(this.gCi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        if (liveTabConcernItemViewLineHolder == null || liveTabConcernItemViewLineHolder.gCi == null) {
            return null;
        }
        liveTabConcernItemViewLineHolder.gCi.a(kVar);
        return liveTabConcernItemViewLineHolder.getView();
    }

    public void a(i iVar) {
        this.gCj = iVar;
        if (this.gCi != null) {
            this.gCi.a(this.gCj);
        }
    }
}
