package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.i;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.j;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, j> {
    private i fin;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i fio;
    private int mFrom;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.fkt);
        this.mPageContext = tbPageContext;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public j b(ViewGroup viewGroup) {
        this.fin = new i(this.mPageContext, viewGroup);
        if (this.fio != null) {
            this.fin.d(this.fio);
        }
        return new j(this.fin);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, j jVar) {
        jVar.fin.a(bVar, this.mFrom);
        return jVar.getView();
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.i iVar) {
        this.fio = iVar;
        if (this.fin != null) {
            this.fin.d(this.fio);
        }
    }
}
