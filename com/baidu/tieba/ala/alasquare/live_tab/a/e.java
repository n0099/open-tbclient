package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.SdkDoubleLiveViewHolder;
import com.baidu.tieba.ala.alasquare.live_tab.view.f;
/* loaded from: classes10.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, SdkDoubleLiveViewHolder> {
    private f gAH;
    private TbPageContext mPageContext;
    private int tabType;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gAL);
        this.mPageContext = tbPageContext;
        this.tabType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public SdkDoubleLiveViewHolder e(ViewGroup viewGroup) {
        this.gAH = new f(this.mPageContext, viewGroup, this.tabType);
        return new SdkDoubleLiveViewHolder(this.gAH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, SdkDoubleLiveViewHolder sdkDoubleLiveViewHolder) {
        if (sdkDoubleLiveViewHolder == null || sdkDoubleLiveViewHolder.gAH == null) {
            return null;
        }
        sdkDoubleLiveViewHolder.gAH.a(eVar);
        sdkDoubleLiveViewHolder.gAH.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return sdkDoubleLiveViewHolder.getView();
    }
}
