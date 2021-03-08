package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabLiveItemView;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.special_forum.data.f, ConcernTabLiveItemView.ViewHolder> {
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.special_forum.data.f.gEm);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public ConcernTabLiveItemView.ViewHolder e(ViewGroup viewGroup) {
        ConcernTabLiveItemView concernTabLiveItemView = new ConcernTabLiveItemView(this.mPageContext, viewGroup);
        concernTabLiveItemView.getClass();
        return new ConcernTabLiveItemView.ViewHolder(concernTabLiveItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.special_forum.data.f fVar, ConcernTabLiveItemView.ViewHolder viewHolder) {
        if (viewHolder == null || fVar == null) {
            return null;
        }
        viewHolder.gJX.a(fVar);
        return viewHolder.getView();
    }
}
