package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.g;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, g> {
    private String eov;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f erQ;
    private h erR;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.emm);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public g b(ViewGroup viewGroup) {
        this.erQ = new com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f(this.mPageContext, viewGroup);
        if (this.erR != null) {
            this.erQ.c(this.erR);
        }
        return new g(this.erQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, g gVar) {
        gVar.erQ.a(eVar, this.eov);
        return gVar.getView();
    }

    public void a(h hVar) {
        this.erR = hVar;
        if (this.erQ != null) {
            this.erQ.c(this.erR);
        }
    }

    public void setEntryName(String str) {
        this.eov = str;
    }
}
