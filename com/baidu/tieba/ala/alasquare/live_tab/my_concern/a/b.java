package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernEmptyViewHolder;
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.special_forum.data.e, LiveTabConcernEmptyViewHolder> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.special_forum.data.e.gCD);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public LiveTabConcernEmptyViewHolder e(ViewGroup viewGroup) {
        return new LiveTabConcernEmptyViewHolder(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.b(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.special_forum.data.e eVar, LiveTabConcernEmptyViewHolder liveTabConcernEmptyViewHolder) {
        if (liveTabConcernEmptyViewHolder == null || liveTabConcernEmptyViewHolder.gDa == null) {
            return null;
        }
        liveTabConcernEmptyViewHolder.gDa.a(eVar);
        return liveTabConcernEmptyViewHolder.getView();
    }
}
