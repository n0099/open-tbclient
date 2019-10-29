package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.a.d;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, d.a> {
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), g.dxX);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public d.a b(ViewGroup viewGroup) {
        return new d.a(new com.baidu.tieba.ala.alasquare.special_forum.subtab.a.d(this.mPageContext, viewGroup).getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, d.a aVar) {
        if (aVar == null || gVar == null) {
            return null;
        }
        return aVar.getView();
    }
}
