package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.view.g;
import com.baidu.tieba.ala.alasquare.live_tab.view.h;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<e, h> {
    private g ehw;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), e.ehC);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public h b(ViewGroup viewGroup) {
        this.ehw = new g(this.mPageContext, viewGroup);
        return new h(this.ehw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, h hVar) {
        if (hVar == null || hVar.ehw == null) {
            return null;
        }
        hVar.ehw.a(eVar);
        hVar.ehw.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return hVar.getView();
    }
}
