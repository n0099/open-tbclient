package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.h;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
/* loaded from: classes9.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, LiveTabConcernRecommendLineHolder> {
    private h gzE;
    private i gzz;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.gzI);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public LiveTabConcernRecommendLineHolder e(ViewGroup viewGroup) {
        this.gzE = new h(this.mPageContext, viewGroup);
        if (this.gzz != null) {
            this.gzE.a(this.gzz);
        }
        return new LiveTabConcernRecommendLineHolder(this.gzE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        if (liveTabConcernRecommendLineHolder == null || liveTabConcernRecommendLineHolder.gzE == null) {
            return null;
        }
        liveTabConcernRecommendLineHolder.gzE.a(cVar);
        return liveTabConcernRecommendLineHolder.getView();
    }

    public void a(i iVar) {
        this.gzz = iVar;
        if (this.gzE != null) {
            this.gzE.a(this.gzz);
        }
    }
}
