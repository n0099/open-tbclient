package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabDoubleGameLiveViewHolder;
/* loaded from: classes10.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, TabDoubleGameLiveViewHolder> {
    private boolean gAR;
    private com.baidu.tieba.ala.alasquare.live_tab.view.e gAU;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gAZ);
        this.gAR = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public TabDoubleGameLiveViewHolder e(ViewGroup viewGroup) {
        this.gAU = new com.baidu.tieba.ala.alasquare.live_tab.view.e(this.mPageContext, viewGroup);
        this.gAU.mw(this.gAR);
        return new TabDoubleGameLiveViewHolder(this.gAU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, TabDoubleGameLiveViewHolder tabDoubleGameLiveViewHolder) {
        if (tabDoubleGameLiveViewHolder == null || tabDoubleGameLiveViewHolder.gAU == null) {
            return null;
        }
        tabDoubleGameLiveViewHolder.gAU.a(eVar);
        tabDoubleGameLiveViewHolder.gAU.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return tabDoubleGameLiveViewHolder.getView();
    }

    public void mw(boolean z) {
        this.gAR = z;
    }
}
