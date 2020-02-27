package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.view.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, com.baidu.tieba.ala.alasquare.live_tab.view.f> {
    private e elB;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.elK);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public com.baidu.tieba.ala.alasquare.live_tab.view.f b(ViewGroup viewGroup) {
        this.elB = new e(this.mPageContext, viewGroup);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.f(this.elB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, com.baidu.tieba.ala.alasquare.live_tab.view.f fVar2) {
        if (fVar2 == null || fVar2.elB == null) {
            return null;
        }
        fVar2.elB.a(fVar);
        fVar2.elB.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return fVar2.getView();
    }
}
