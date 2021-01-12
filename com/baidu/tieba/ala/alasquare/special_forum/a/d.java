package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.GameLiveDoubleViewHolder;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, GameLiveDoubleViewHolder> {
    private String gAn;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c gDO;
    private com.baidu.tieba.ala.alasquare.subtablist.view.f gDP;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gyb);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public GameLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gDO = new com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c(this.mPageContext, viewGroup);
        if (this.gDP != null) {
            this.gDO.c(this.gDP);
        }
        return new GameLiveDoubleViewHolder(this.gDO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, GameLiveDoubleViewHolder gameLiveDoubleViewHolder) {
        gameLiveDoubleViewHolder.gDO.a(eVar, this.gAn);
        return gameLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.alasquare.subtablist.view.f fVar) {
        this.gDP = fVar;
        if (this.gDO != null) {
            this.gDO.c(this.gDP);
        }
    }

    public void setEntryName(String str) {
        this.gAn = str;
    }
}
