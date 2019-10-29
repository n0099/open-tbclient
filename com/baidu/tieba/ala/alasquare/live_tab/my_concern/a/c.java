package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.i;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<i, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e dxQ;
    private o dxR;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), i.dxq);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f b(ViewGroup viewGroup) {
        this.dxQ = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.e(this.mPageContext, viewGroup);
        if (this.dxR != null) {
            this.dxQ.a(this.dxR);
        }
        return new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f(this.dxQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.f fVar) {
        if (fVar == null || fVar.dxQ == null) {
            return null;
        }
        fVar.dxQ.a(iVar);
        return fVar.getView();
    }

    public void a(o oVar) {
        this.dxR = oVar;
        if (this.dxQ != null) {
            this.dxQ.a(this.dxR);
        }
    }
}
