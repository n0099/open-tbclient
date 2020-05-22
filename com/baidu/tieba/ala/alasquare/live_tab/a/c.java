package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, com.baidu.tieba.ala.alasquare.live_tab.view.f> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.e fcu;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.fcD);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: E */
    public com.baidu.tieba.ala.alasquare.live_tab.view.f b(ViewGroup viewGroup) {
        this.fcu = new com.baidu.tieba.ala.alasquare.live_tab.view.e(this.mPageContext, viewGroup);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.f(this.fcu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, com.baidu.tieba.ala.alasquare.live_tab.view.f fVar2) {
        if (fVar2 == null || fVar2.fcu == null) {
            return null;
        }
        fVar2.fcu.a(fVar);
        fVar2.fcu.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return fVar2.getView();
    }
}
