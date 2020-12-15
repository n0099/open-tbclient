package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.g;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, g> {
    private String gtV;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f gxr;
    private h gxs;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.grJ);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public g c(ViewGroup viewGroup) {
        this.gxr = new com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f(this.mPageContext, viewGroup);
        if (this.gxs != null) {
            this.gxr.c(this.gxs);
        }
        return new g(this.gxr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, g gVar) {
        gVar.gxr.a(eVar, this.gtV);
        return gVar.getView();
    }

    public void a(h hVar) {
        this.gxs = hVar;
        if (this.gxr != null) {
            this.gxr.c(this.gxs);
        }
    }

    public void setEntryName(String str) {
        this.gtV = str;
    }
}
