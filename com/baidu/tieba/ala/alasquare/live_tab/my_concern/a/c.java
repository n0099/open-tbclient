package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e gtg;
    private o gth;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.grV);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f c(ViewGroup viewGroup) {
        this.gtg = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e(this.mPageContext, viewGroup);
        if (this.gth != null) {
            this.gtg.a(this.gth);
        }
        return new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f(this.gtg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f fVar) {
        if (fVar == null || fVar.gtg == null) {
            return null;
        }
        fVar.gtg.a(kVar);
        return fVar.getView();
    }

    public void a(o oVar) {
        this.gth = oVar;
        if (this.gtg != null) {
            this.gtg.a(this.gth);
        }
    }
}
