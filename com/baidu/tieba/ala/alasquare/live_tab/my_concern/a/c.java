package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e eiP;
    private o eiQ;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.ehO);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f b(ViewGroup viewGroup) {
        this.eiP = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e(this.mPageContext, viewGroup);
        if (this.eiQ != null) {
            this.eiP.a(this.eiQ);
        }
        return new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f(this.eiP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f fVar) {
        if (fVar == null || fVar.eiP == null) {
            return null;
        }
        fVar.eiP.a(kVar);
        return fVar.getView();
    }

    public void a(o oVar) {
        this.eiQ = oVar;
        if (this.eiP != null) {
            this.eiP.a(this.eiQ);
        }
    }
}
