package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, com.baidu.tieba.ala.alasquare.live_tab.view.f> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.e fHI;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.fHR);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: J */
    public com.baidu.tieba.ala.alasquare.live_tab.view.f c(ViewGroup viewGroup) {
        this.fHI = new com.baidu.tieba.ala.alasquare.live_tab.view.e(this.mPageContext, viewGroup);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.f(this.fHI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, com.baidu.tieba.ala.alasquare.live_tab.view.f fVar2) {
        if (fVar2 == null || fVar2.fHI == null) {
            return null;
        }
        fVar2.fHI.a(fVar);
        fVar2.fHI.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return fVar2.getView();
    }
}
