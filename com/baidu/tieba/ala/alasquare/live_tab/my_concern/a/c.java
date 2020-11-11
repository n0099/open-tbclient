package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e glo;
    private o glp;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.gkd);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f c(ViewGroup viewGroup) {
        this.glo = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e(this.mPageContext, viewGroup);
        if (this.glp != null) {
            this.glo.a(this.glp);
        }
        return new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f(this.glo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f fVar) {
        if (fVar == null || fVar.glo == null) {
            return null;
        }
        fVar.glo.a(kVar);
        return fVar.getView();
    }

    public void a(o oVar) {
        this.glp = oVar;
        if (this.glo != null) {
            this.glo.a(this.glp);
        }
    }
}
