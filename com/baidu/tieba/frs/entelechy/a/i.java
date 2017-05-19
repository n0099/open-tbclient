package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.ai;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<aw, com.baidu.tieba.card.b.a<ai>> implements com.baidu.tieba.frs.c.e {
    private TbPageContext<?> ajr;
    private ai bSp;
    private cd bSq;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bSq = new j(this);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bSp = new ai(this.ajr, this.mPageId);
        this.bSp.i(this.mPageId);
        return new com.baidu.tieba.card.b.a(this.bSp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, aw awVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.TU() == null) {
            return null;
        }
        aVar.TU().onBindDataToView(awVar);
        aVar.TU().setOnSubCardOnClickListenner(this.bSq);
        com.baidu.tieba.frs.c.b.acs().a(bZb, awVar);
        return aVar.getView();
    }
}
