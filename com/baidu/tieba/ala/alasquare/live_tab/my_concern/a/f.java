package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.h;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, LiveTabConcernRecommendLineHolder> {
    private i gCj;
    private h gCo;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.gCs);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public LiveTabConcernRecommendLineHolder e(ViewGroup viewGroup) {
        this.gCo = new h(this.mPageContext, viewGroup);
        if (this.gCj != null) {
            this.gCo.a(this.gCj);
        }
        return new LiveTabConcernRecommendLineHolder(this.gCo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        if (liveTabConcernRecommendLineHolder == null || liveTabConcernRecommendLineHolder.gCo == null) {
            return null;
        }
        liveTabConcernRecommendLineHolder.gCo.a(cVar);
        return liveTabConcernRecommendLineHolder.getView();
    }

    public void a(i iVar) {
        this.gCj = iVar;
        if (this.gCo != null) {
            this.gCo.a(this.gCj);
        }
    }
}
