package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.b.i;
import com.baidu.tieba.ala.alasquare.live_tab.view.h;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<i, com.baidu.tieba.ala.alasquare.live_tab.view.i> {
    private h ehn;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), i.ehB);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.ala.alasquare.live_tab.view.i b(ViewGroup viewGroup) {
        this.ehn = new h(this.mPageContext, viewGroup);
        return new com.baidu.tieba.ala.alasquare.live_tab.view.i(this.ehn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, com.baidu.tieba.ala.alasquare.live_tab.view.i iVar2) {
        if (iVar2 == null || iVar2.ehn == null) {
            return null;
        }
        iVar2.ehn.a(iVar);
        iVar2.ehn.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return iVar2.getView();
    }
}
