package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.j;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, com.baidu.tieba.ala.alasquare.live_tab.view.d> {
    private j grF;
    private TbPageContext mPageContext;
    private int tabType;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.grJ);
        this.mPageContext = tbPageContext;
        this.tabType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: M */
    public com.baidu.tieba.ala.alasquare.live_tab.view.d c(ViewGroup viewGroup) {
        this.grF = new j(this.mPageContext, viewGroup, this.tabType);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.d(this.grF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, com.baidu.tieba.ala.alasquare.live_tab.view.d dVar) {
        if (dVar == null || dVar.grF == null) {
            return null;
        }
        dVar.grF.a(eVar);
        dVar.grF.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return dVar.getView();
    }
}
