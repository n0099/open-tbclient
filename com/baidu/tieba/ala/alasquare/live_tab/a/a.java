package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.c, com.baidu.tieba.ala.alasquare.live_tab.view.c> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.b elB;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.c.elG);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.ala.alasquare.live_tab.view.c b(ViewGroup viewGroup) {
        this.elB = new com.baidu.tieba.ala.alasquare.live_tab.view.b(this.mPageContext, viewGroup);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.c(this.elB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.c cVar, com.baidu.tieba.ala.alasquare.live_tab.view.c cVar2) {
        if (cVar2 == null || cVar2.elB == null) {
            return null;
        }
        cVar2.elB.a(cVar);
        cVar2.elB.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cVar2.getView();
    }
}
