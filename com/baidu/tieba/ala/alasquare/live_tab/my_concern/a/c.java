package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e fFO;
    private o fFP;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.fEK);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: M */
    public com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f b(ViewGroup viewGroup) {
        this.fFO = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e(this.mPageContext, viewGroup);
        if (this.fFP != null) {
            this.fFO.a(this.fFP);
        }
        return new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f(this.fFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f fVar) {
        if (fVar == null || fVar.fFO == null) {
            return null;
        }
        fVar.fFO.a(kVar);
        return fVar.getView();
    }

    public void a(o oVar) {
        this.fFP = oVar;
        if (this.fFO != null) {
            this.fFO.a(this.fFP);
        }
    }
}
