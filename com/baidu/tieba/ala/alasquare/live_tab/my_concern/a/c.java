package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e gte;
    private o gtf;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.grT);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f c(ViewGroup viewGroup) {
        this.gte = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e(this.mPageContext, viewGroup);
        if (this.gtf != null) {
            this.gte.a(this.gtf);
        }
        return new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f(this.gte);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f fVar) {
        if (fVar == null || fVar.gte == null) {
            return null;
        }
        fVar.gte.a(kVar);
        return fVar.getView();
    }

    public void a(o oVar) {
        this.gtf = oVar;
        if (this.gte != null) {
            this.gte.a(this.gtf);
        }
    }
}
