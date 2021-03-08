package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.h;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
/* loaded from: classes9.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, LiveTabConcernRecommendLineHolder> {
    private i gEg;
    private h gEl;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.gEp);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public LiveTabConcernRecommendLineHolder e(ViewGroup viewGroup) {
        this.gEl = new h(this.mPageContext, viewGroup);
        if (this.gEg != null) {
            this.gEl.a(this.gEg);
        }
        return new LiveTabConcernRecommendLineHolder(this.gEl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        if (liveTabConcernRecommendLineHolder == null || liveTabConcernRecommendLineHolder.gEl == null) {
            return null;
        }
        liveTabConcernRecommendLineHolder.gEl.a(cVar);
        return liveTabConcernRecommendLineHolder.getView();
    }

    public void a(i iVar) {
        this.gEg = iVar;
        if (this.gEl != null) {
            this.gEl.a(this.gEg);
        }
    }
}
