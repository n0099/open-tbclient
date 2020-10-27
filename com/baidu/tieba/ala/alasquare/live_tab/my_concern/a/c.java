package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f> {
    private o gfA;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e gfz;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.gen);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f c(ViewGroup viewGroup) {
        this.gfz = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e(this.mPageContext, viewGroup);
        if (this.gfA != null) {
            this.gfz.a(this.gfA);
        }
        return new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f(this.gfz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f fVar) {
        if (fVar == null || fVar.gfz == null) {
            return null;
        }
        fVar.gfz.a(kVar);
        return fVar.getView();
    }

    public void a(o oVar) {
        this.gfA = oVar;
        if (this.gfz != null) {
            this.gfz.a(this.gfA);
        }
    }
}
