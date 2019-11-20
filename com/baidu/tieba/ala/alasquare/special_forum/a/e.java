package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.f;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.g;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, g> {
    private f dAZ;
    private h dBa;
    private int mFrom;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.dCR);
        this.mPageContext = tbPageContext;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public g b(ViewGroup viewGroup) {
        this.dAZ = new f(this.mPageContext, viewGroup);
        if (this.dBa != null) {
            this.dAZ.d(this.dBa);
        }
        return new g(this.dAZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, g gVar) {
        gVar.dAZ.a(bVar, this.mFrom);
        return gVar.getView();
    }

    public void b(h hVar) {
        this.dBa = hVar;
        if (this.dAZ != null) {
            this.dAZ.d(this.dBa);
        }
    }
}
