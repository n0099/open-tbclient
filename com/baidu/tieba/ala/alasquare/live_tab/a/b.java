package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.c, com.baidu.tieba.ala.alasquare.live_tab.view.c> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.b fHH;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.c.fHM);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public com.baidu.tieba.ala.alasquare.live_tab.view.c c(ViewGroup viewGroup) {
        this.fHH = new com.baidu.tieba.ala.alasquare.live_tab.view.b(this.mPageContext, viewGroup);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.c(this.fHH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.c cVar, com.baidu.tieba.ala.alasquare.live_tab.view.c cVar2) {
        if (cVar2 == null || cVar2.fHH == null) {
            return null;
        }
        cVar2.fHH.a(cVar);
        cVar2.fHH.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cVar2.getView();
    }
}
