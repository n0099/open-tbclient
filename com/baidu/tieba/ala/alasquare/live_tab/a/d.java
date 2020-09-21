package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.h;
import com.baidu.tieba.ala.alasquare.live_tab.view.i;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, i> {
    private boolean fHG;
    private h fHJ;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.fHO);
        this.fHG = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public i c(ViewGroup viewGroup) {
        this.fHJ = new h(this.mPageContext, viewGroup);
        this.fHJ.kE(this.fHG);
        return new i(this.fHJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, i iVar) {
        if (iVar == null || iVar.fHJ == null) {
            return null;
        }
        iVar.fHJ.a(eVar);
        iVar.fHJ.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return iVar.getView();
    }

    public void kE(boolean z) {
        this.fHG = z;
    }
}
