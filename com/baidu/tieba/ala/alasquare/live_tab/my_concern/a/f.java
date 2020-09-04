package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.l;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.m;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, l> {
    private o fFT;
    private m fFY;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.fGc);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public l b(ViewGroup viewGroup) {
        this.fFY = new m(this.mPageContext, viewGroup);
        if (this.fFT != null) {
            this.fFY.a(this.fFT);
        }
        return new l(this.fFY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, l lVar) {
        if (lVar == null || lVar.fFY == null) {
            return null;
        }
        lVar.fFY.a(cVar);
        return lVar.getView();
    }

    public void a(o oVar) {
        this.fFT = oVar;
        if (this.fFY != null) {
            this.fFY.a(this.fFT);
        }
    }
}
