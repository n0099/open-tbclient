package com.baidu.tieba.ala.personcenter.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.personcenter.c.n;
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), n.hyr);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.c(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.c> aVar) {
        if (aVar.cmx() == null) {
            return null;
        }
        a(nVar, aVar.cmx());
        return aVar.cmx().getView();
    }

    private void a(n nVar, com.baidu.tieba.ala.personcenter.e.c cVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = nVar.getPersonCenterData();
        if (personCenterData == null || personCenterData.cgZ() == null || TextUtils.isEmpty(personCenterData.cgZ().cgY())) {
            cVar.setVisibility(8);
            notifyDataSetChanged();
            return;
        }
        cVar.Iv(personCenterData.cgZ().cgY());
        cVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        notifyDataSetChanged();
    }
}
