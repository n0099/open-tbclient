package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabDoubleGameLiveViewHolder;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, TabDoubleGameLiveViewHolder> {
    private boolean gxT;
    private com.baidu.tieba.ala.alasquare.live_tab.view.e gxW;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gyb);
        this.gxT = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public TabDoubleGameLiveViewHolder e(ViewGroup viewGroup) {
        this.gxW = new com.baidu.tieba.ala.alasquare.live_tab.view.e(this.mPageContext, viewGroup);
        this.gxW.ms(this.gxT);
        return new TabDoubleGameLiveViewHolder(this.gxW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, TabDoubleGameLiveViewHolder tabDoubleGameLiveViewHolder) {
        if (tabDoubleGameLiveViewHolder == null || tabDoubleGameLiveViewHolder.gxW == null) {
            return null;
        }
        tabDoubleGameLiveViewHolder.gxW.a(eVar);
        tabDoubleGameLiveViewHolder.gxW.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return tabDoubleGameLiveViewHolder.getView();
    }

    public void ms(boolean z) {
        this.gxT = z;
    }
}
