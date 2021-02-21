package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.GameLiveDoubleViewHolder;
/* loaded from: classes10.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, GameLiveDoubleViewHolder> {
    private String gDl;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c gGM;
    private com.baidu.tieba.ala.alasquare.subtablist.view.f gGN;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gAZ);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public GameLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gGM = new com.baidu.tieba.ala.alasquare.special_forum.subtab.view.c(this.mPageContext, viewGroup);
        if (this.gGN != null) {
            this.gGM.c(this.gGN);
        }
        return new GameLiveDoubleViewHolder(this.gGM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, GameLiveDoubleViewHolder gameLiveDoubleViewHolder) {
        gameLiveDoubleViewHolder.gGM.a(eVar, this.gDl);
        return gameLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.alasquare.subtablist.view.f fVar) {
        this.gGN = fVar;
        if (this.gGM != null) {
            this.gGM.c(this.gGN);
        }
    }

    public void setEntryName(String str) {
        this.gDl = str;
    }
}
