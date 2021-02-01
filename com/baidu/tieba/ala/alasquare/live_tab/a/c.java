package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.view.StageLiveViewHolder;
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, StageLiveViewHolder> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.c gAF;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.gAO);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public StageLiveViewHolder e(ViewGroup viewGroup) {
        this.gAF = new com.baidu.tieba.ala.alasquare.live_tab.view.c(this.mPageContext, viewGroup);
        return new StageLiveViewHolder(this.gAF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, StageLiveViewHolder stageLiveViewHolder) {
        if (stageLiveViewHolder == null || stageLiveViewHolder.gAF == null) {
            return null;
        }
        stageLiveViewHolder.gAF.a(fVar);
        stageLiveViewHolder.gAF.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return stageLiveViewHolder.getView();
    }
}
