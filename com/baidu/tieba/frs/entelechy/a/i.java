package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.au;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<au, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.am>> implements com.baidu.tieba.frs.e.e {
    private TbPageContext<?> FY;
    private com.baidu.tieba.frs.entelechy.view.am bLk;
    private cf bLl;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLl = new j(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bLk = new com.baidu.tieba.frs.entelechy.view.am(this.FY);
        this.bLk.i(this.FY.getUniqueId());
        return new com.baidu.tieba.card.b.a(this.bLk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, au auVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Sd() == null) {
            return null;
        }
        aVar.Sd().onBindDataToView(auVar);
        aVar.Sd().setOnSubCardOnClickListenner(this.bLl);
        com.baidu.tieba.frs.e.b.acx().a(bTj, auVar);
        return aVar.getView();
    }
}
