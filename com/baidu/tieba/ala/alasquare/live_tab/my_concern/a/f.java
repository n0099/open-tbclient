package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.l;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.m;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, l> {
    private o fdQ;
    private m fdV;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.fdZ);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public l b(ViewGroup viewGroup) {
        this.fdV = new m(this.mPageContext, viewGroup);
        if (this.fdQ != null) {
            this.fdV.a(this.fdQ);
        }
        return new l(this.fdV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, l lVar) {
        if (lVar == null || lVar.fdV == null) {
            return null;
        }
        lVar.fdV.a(cVar);
        return lVar.getView();
    }

    public void a(o oVar) {
        this.fdQ = oVar;
        if (this.fdV != null) {
            this.fdV.a(this.fdQ);
        }
    }
}
