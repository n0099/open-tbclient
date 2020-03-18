package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.l;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.m;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, l> {
    private o enF;
    private m enK;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.enO);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public l b(ViewGroup viewGroup) {
        this.enK = new m(this.mPageContext, viewGroup);
        if (this.enF != null) {
            this.enK.a(this.enF);
        }
        return new l(this.enK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, l lVar) {
        if (lVar == null || lVar.enK == null) {
            return null;
        }
        lVar.enK.a(cVar);
        return lVar.getView();
    }

    public void a(o oVar) {
        this.enF = oVar;
        if (this.enK != null) {
            this.enK.a(this.enF);
        }
    }
}
