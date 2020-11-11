package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.d;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.special_forum.data.f, d.a> {
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.special_forum.data.f.glv);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public d.a c(ViewGroup viewGroup) {
        com.baidu.tieba.ala.alasquare.special_forum.subtab.a.d dVar = new com.baidu.tieba.ala.alasquare.special_forum.subtab.a.d(this.mPageContext, viewGroup);
        dVar.getClass();
        return new d.a(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.special_forum.data.f fVar, d.a aVar) {
        if (aVar == null || fVar == null) {
            return null;
        }
        aVar.grb.a(fVar);
        return aVar.getView();
    }
}
