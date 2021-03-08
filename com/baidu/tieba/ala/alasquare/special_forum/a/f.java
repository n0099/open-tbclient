package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.SpecialLiveDoubleViewHolder;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes9.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, SpecialLiveDoubleViewHolder> {
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.view.d gIx;
    private g gIy;
    private int mFrom;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gKC);
        this.mPageContext = tbPageContext;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public SpecialLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gIx = new com.baidu.tieba.ala.alasquare.special_forum.subtab.view.d(this.mPageContext, viewGroup);
        if (this.gIy != null) {
            this.gIx.d(this.gIy);
        }
        return new SpecialLiveDoubleViewHolder(this.gIx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, SpecialLiveDoubleViewHolder specialLiveDoubleViewHolder) {
        specialLiveDoubleViewHolder.gIx.a(bVar, this.mFrom);
        return specialLiveDoubleViewHolder.getView();
    }

    public void b(g gVar) {
        this.gIy = gVar;
        if (this.gIx != null) {
            this.gIx.d(this.gIy);
        }
    }
}
