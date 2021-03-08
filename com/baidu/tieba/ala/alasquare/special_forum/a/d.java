package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.GameLiveDoubleViewHolder;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, GameLiveDoubleViewHolder> {
    private String gEU;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c gIv;
    private com.baidu.tieba.ala.alasquare.subtablist.view.f gIw;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gCI);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public GameLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gIv = new com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c(this.mPageContext, viewGroup);
        if (this.gIw != null) {
            this.gIv.c(this.gIw);
        }
        return new GameLiveDoubleViewHolder(this.gIv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, GameLiveDoubleViewHolder gameLiveDoubleViewHolder) {
        gameLiveDoubleViewHolder.gIv.a(eVar, this.gEU);
        return gameLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.alasquare.subtablist.view.f fVar) {
        this.gIw = fVar;
        if (this.gIv != null) {
            this.gIv.c(this.gIw);
        }
    }

    public void setEntryName(String str) {
        this.gEU = str;
    }
}
