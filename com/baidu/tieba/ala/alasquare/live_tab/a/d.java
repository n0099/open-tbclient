package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.view.i;
import com.baidu.tieba.ala.alasquare.live_tab.view.j;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<k, j> {
    private i ehx;
    private TbPageContext mPageContext;
    private int tabType;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getPageActivity(), k.ehO);
        this.mPageContext = tbPageContext;
        this.tabType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public j b(ViewGroup viewGroup) {
        this.ehx = new i(this.mPageContext, viewGroup, this.tabType);
        return new j(this.ehx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, j jVar) {
        if (jVar == null || jVar.ehx == null) {
            return null;
        }
        jVar.ehx.a(kVar);
        jVar.ehx.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return jVar.getView();
    }
}
