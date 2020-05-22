package com.baidu.tieba.ala.personcenter.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.personcenter.c.m;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), m.goK);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.c(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c> aVar) {
        if (aVar.bLU() == null) {
            return null;
        }
        a(mVar, aVar.bLU());
        return aVar.bLU().getView();
    }

    private void a(m mVar, com.baidu.tieba.ala.personcenter.e.c cVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = mVar.getPersonCenterData();
        if (personCenterData == null || personCenterData.bIm() == null || TextUtils.isEmpty(personCenterData.bIm().bIl())) {
            cVar.setVisibility(8);
            notifyDataSetChanged();
            return;
        }
        cVar.Dd(personCenterData.bIm().bIl());
        cVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        notifyDataSetChanged();
    }
}
