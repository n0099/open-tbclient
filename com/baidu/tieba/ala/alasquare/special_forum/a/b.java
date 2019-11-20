package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.data.f;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.c;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, c.a> {
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.dxg);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public c.a b(ViewGroup viewGroup) {
        com.baidu.tieba.ala.alasquare.special_forum.subtab.a.c cVar = new com.baidu.tieba.ala.alasquare.special_forum.subtab.a.c(this.mPageContext, viewGroup);
        cVar.getClass();
        return new c.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, c.a aVar) {
        if (aVar == null || fVar == null) {
            return null;
        }
        aVar.dCm.a(fVar);
        return aVar.getView();
    }
}
