package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.view.h;
import com.baidu.tieba.ala.alasquare.live_tab.view.i;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<e, i> {
    private h ePH;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), e.ePM);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public i b(ViewGroup viewGroup) {
        this.ePH = new h(this.mPageContext, viewGroup);
        return new i(this.ePH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, i iVar) {
        if (iVar == null || iVar.ePH == null) {
            return null;
        }
        iVar.ePH.a(eVar);
        iVar.ePH.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return iVar.getView();
    }
}
