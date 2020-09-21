package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.g;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, g> {
    private String fJU;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f fNq;
    private h fNr;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.fHO);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public g c(ViewGroup viewGroup) {
        this.fNq = new com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f(this.mPageContext, viewGroup);
        if (this.fNr != null) {
            this.fNq.c(this.fNr);
        }
        return new g(this.fNq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, g gVar) {
        gVar.fNq.a(eVar, this.fJU);
        return gVar.getView();
    }

    public void a(h hVar) {
        this.fNr = hVar;
        if (this.fNq != null) {
            this.fNq.c(this.fNr);
        }
    }

    public void setEntryName(String str) {
        this.fJU = str;
    }
}
