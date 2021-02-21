package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.h;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, LiveTabConcernRecommendLineHolder> {
    private h gCC;
    private i gCx;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.gCG);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public LiveTabConcernRecommendLineHolder e(ViewGroup viewGroup) {
        this.gCC = new h(this.mPageContext, viewGroup);
        if (this.gCx != null) {
            this.gCC.a(this.gCx);
        }
        return new LiveTabConcernRecommendLineHolder(this.gCC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        if (liveTabConcernRecommendLineHolder == null || liveTabConcernRecommendLineHolder.gCC == null) {
            return null;
        }
        liveTabConcernRecommendLineHolder.gCC.a(cVar);
        return liveTabConcernRecommendLineHolder.getView();
    }

    public void a(i iVar) {
        this.gCx = iVar;
        if (this.gCC != null) {
            this.gCC.a(this.gCx);
        }
    }
}
