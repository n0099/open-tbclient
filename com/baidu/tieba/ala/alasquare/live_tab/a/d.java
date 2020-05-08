package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.view.j;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, com.baidu.tieba.ala.alasquare.live_tab.view.d> {
    private j ePN;
    private TbPageContext mPageContext;
    private int tabType;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getPageActivity(), e.ePR);
        this.mPageContext = tbPageContext;
        this.tabType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.ala.alasquare.live_tab.view.d b(ViewGroup viewGroup) {
        this.ePN = new j(this.mPageContext, viewGroup, this.tabType);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.d(this.ePN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, com.baidu.tieba.ala.alasquare.live_tab.view.d dVar) {
        if (dVar == null || dVar.ePN == null) {
            return null;
        }
        dVar.ePN.a(eVar);
        dVar.ePN.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return dVar.getView();
    }
}
