package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.g;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, g> {
    private String fGE;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f fJY;
    private h fJZ;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.fEy);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public g b(ViewGroup viewGroup) {
        this.fJY = new com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f(this.mPageContext, viewGroup);
        if (this.fJZ != null) {
            this.fJY.c(this.fJZ);
        }
        return new g(this.fJY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, g gVar) {
        gVar.fJY.a(eVar, this.fGE);
        return gVar.getView();
    }

    public void a(h hVar) {
        this.fJZ = hVar;
        if (this.fJY != null) {
            this.fJY.c(this.fJZ);
        }
    }

    public void setEntryName(String str) {
        this.fGE = str;
    }
}
