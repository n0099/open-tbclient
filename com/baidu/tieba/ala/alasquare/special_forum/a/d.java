package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.GameLiveDoubleViewHolder;
/* loaded from: classes10.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, GameLiveDoubleViewHolder> {
    private String gCX;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c gGy;
    private com.baidu.tieba.ala.alasquare.subtablist.view.f gGz;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gAL);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public GameLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gGy = new com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c(this.mPageContext, viewGroup);
        if (this.gGz != null) {
            this.gGy.c(this.gGz);
        }
        return new GameLiveDoubleViewHolder(this.gGy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, GameLiveDoubleViewHolder gameLiveDoubleViewHolder) {
        gameLiveDoubleViewHolder.gGy.a(eVar, this.gCX);
        return gameLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.alasquare.subtablist.view.f fVar) {
        this.gGz = fVar;
        if (this.gGy != null) {
            this.gGy.c(this.gGz);
        }
    }

    public void setEntryName(String str) {
        this.gCX = str;
    }
}
