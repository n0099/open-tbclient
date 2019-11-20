package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.e;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.d, e> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.d dwj;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.d.dwq);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public e b(ViewGroup viewGroup) {
        this.dwj = new com.baidu.tieba.ala.alasquare.live_tab.view.d(this.mPageContext, viewGroup);
        return new e(this.dwj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.d dVar, e eVar) {
        if (eVar == null || eVar.dwj == null) {
            return null;
        }
        eVar.dwj.a(dVar);
        eVar.dwj.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return eVar.getView();
    }
}
