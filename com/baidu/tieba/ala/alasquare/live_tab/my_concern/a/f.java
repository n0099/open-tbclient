package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.l;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.m;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c, l> {
    private o feb;
    private m feg;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c.fek);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public l b(ViewGroup viewGroup) {
        this.feg = new m(this.mPageContext, viewGroup);
        if (this.feb != null) {
            this.feg.a(this.feb);
        }
        return new l(this.feg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar, l lVar) {
        if (lVar == null || lVar.feg == null) {
            return null;
        }
        lVar.feg.a(cVar);
        return lVar.getView();
    }

    public void a(o oVar) {
        this.feb = oVar;
        if (this.feg != null) {
            this.feg.a(this.feb);
        }
    }
}
