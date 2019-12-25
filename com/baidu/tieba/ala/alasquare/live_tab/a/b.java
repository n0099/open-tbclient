package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.e;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.d, e> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.d ehl;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.d.ehs);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public e b(ViewGroup viewGroup) {
        this.ehl = new com.baidu.tieba.ala.alasquare.live_tab.view.d(this.mPageContext, viewGroup);
        return new e(this.ehl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.d dVar, e eVar) {
        if (eVar == null || eVar.ehl == null) {
            return null;
        }
        eVar.ehl.a(dVar);
        eVar.ehl.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return eVar.getView();
    }
}
