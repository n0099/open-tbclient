package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.b, com.baidu.tieba.ala.alasquare.live_tab.view.c> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.b dwZ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.b.dxe);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public com.baidu.tieba.ala.alasquare.live_tab.view.c b(ViewGroup viewGroup) {
        this.dwZ = new com.baidu.tieba.ala.alasquare.live_tab.view.b(this.mPageContext, viewGroup);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.c(this.dwZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.b bVar, com.baidu.tieba.ala.alasquare.live_tab.view.c cVar) {
        if (cVar == null || cVar.dwZ == null) {
            return null;
        }
        cVar.dwZ.a(bVar);
        cVar.dwZ.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cVar.getView();
    }
}
