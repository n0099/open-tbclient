package com.baidu.tieba.ala.personcenter.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.personcenter.c.m;
/* loaded from: classes4.dex */
public class j extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), m.gXv);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.c(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c> aVar) {
        if (aVar.cfU() == null) {
            return null;
        }
        a(mVar, aVar.cfU());
        return aVar.cfU().getView();
    }

    private void a(m mVar, com.baidu.tieba.ala.personcenter.e.c cVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = mVar.getPersonCenterData();
        if (personCenterData == null || personCenterData.caz() == null || TextUtils.isEmpty(personCenterData.caz().cay())) {
            cVar.setVisibility(8);
            notifyDataSetChanged();
            return;
        }
        cVar.Hi(personCenterData.caz().cay());
        cVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        notifyDataSetChanged();
    }
}
