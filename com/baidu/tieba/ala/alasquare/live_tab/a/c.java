package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.view.f;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.ala.alasquare.live_tab.view.g> {
    private f dxb;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), g.dxo);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.ala.alasquare.live_tab.view.g b(ViewGroup viewGroup) {
        this.dxb = new f(this.mPageContext, viewGroup);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.g(this.dxb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.ala.alasquare.live_tab.view.g gVar2) {
        if (gVar2 == null || gVar2.dxb == null) {
            return null;
        }
        gVar2.dxb.a(gVar);
        gVar2.dxb.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return gVar2.getView();
    }
}
