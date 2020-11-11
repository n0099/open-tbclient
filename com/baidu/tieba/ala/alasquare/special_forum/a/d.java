package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.g;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, g> {
    private String gmd;
    private h gpA;
    private com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f gpz;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.gjR);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public g c(ViewGroup viewGroup) {
        this.gpz = new com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f(this.mPageContext, viewGroup);
        if (this.gpA != null) {
            this.gpz.c(this.gpA);
        }
        return new g(this.gpz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, g gVar) {
        gVar.gpz.a(eVar, this.gmd);
        return gVar.getView();
    }

    public void a(h hVar) {
        this.gpA = hVar;
        if (this.gpz != null) {
            this.gpz.c(this.gpA);
        }
    }

    public void setEntryName(String str) {
        this.gmd = str;
    }
}
