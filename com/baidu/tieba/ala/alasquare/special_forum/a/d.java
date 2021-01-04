package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.GameLiveDoubleViewHolder;
/* loaded from: classes10.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, GameLiveDoubleViewHolder> {
    private String gEU;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c gIu;
    private com.baidu.tieba.ala.alasquare.subtablist.view.f gIv;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gCI);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public GameLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gIu = new com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c(this.mPageContext, viewGroup);
        if (this.gIv != null) {
            this.gIu.c(this.gIv);
        }
        return new GameLiveDoubleViewHolder(this.gIu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, GameLiveDoubleViewHolder gameLiveDoubleViewHolder) {
        gameLiveDoubleViewHolder.gIu.a(eVar, this.gEU);
        return gameLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.alasquare.subtablist.view.f fVar) {
        this.gIv = fVar;
        if (this.gIu != null) {
            this.gIu.c(this.gIv);
        }
    }

    public void setEntryName(String str) {
        this.gEU = str;
    }
}
