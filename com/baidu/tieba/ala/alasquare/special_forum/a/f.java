package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.i;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.j;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, j> {
    private i emU;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i emV;
    private int mFrom;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.epd);
        this.mPageContext = tbPageContext;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public j b(ViewGroup viewGroup) {
        this.emU = new i(this.mPageContext, viewGroup);
        if (this.emV != null) {
            this.emU.d(this.emV);
        }
        return new j(this.emU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, j jVar) {
        jVar.emU.a(bVar, this.mFrom);
        return jVar.getView();
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.i iVar) {
        this.emV = iVar;
        if (this.emU != null) {
            this.emU.d(this.emV);
        }
    }
}
