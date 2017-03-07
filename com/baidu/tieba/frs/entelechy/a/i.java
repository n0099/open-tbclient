package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<aw, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.am>> implements com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajF;
    private com.baidu.tieba.frs.entelechy.view.am bSq;
    private cf bSr;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSr = new j(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bSq = new com.baidu.tieba.frs.entelechy.view.am(this.ajF);
        this.bSq.i(this.ajF.getUniqueId());
        return new com.baidu.tieba.card.b.a(this.bSq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, aw awVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Tb() == null) {
            return null;
        }
        aVar.Tb().onBindDataToView(awVar);
        aVar.Tb().setOnSubCardOnClickListenner(this.bSr);
        com.baidu.tieba.frs.e.b.adv().a(cav, awVar);
        return aVar.getView();
    }
}
