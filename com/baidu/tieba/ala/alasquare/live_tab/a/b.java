package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.view.e;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, e> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.d ehv;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.ehF);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public e b(ViewGroup viewGroup) {
        this.ehv = new com.baidu.tieba.ala.alasquare.live_tab.view.d(this.mPageContext, viewGroup);
        return new e(this.ehv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, e eVar) {
        if (eVar == null || eVar.ehv == null) {
            return null;
        }
        eVar.ehv.a(fVar);
        eVar.ehv.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return eVar.getView();
    }
}
