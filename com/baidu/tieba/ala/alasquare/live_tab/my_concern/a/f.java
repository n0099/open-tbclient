package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.l;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.m;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, l> {
    private o fFP;
    private m fFU;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.fFY);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public l b(ViewGroup viewGroup) {
        this.fFU = new m(this.mPageContext, viewGroup);
        if (this.fFP != null) {
            this.fFU.a(this.fFP);
        }
        return new l(this.fFU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, l lVar) {
        if (lVar == null || lVar.fFU == null) {
            return null;
        }
        lVar.fFU.a(cVar);
        return lVar.getView();
    }

    public void a(o oVar) {
        this.fFP = oVar;
        if (this.fFU != null) {
            this.fFU.a(this.fFP);
        }
    }
}
