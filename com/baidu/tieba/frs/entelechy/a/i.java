package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.av;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<av, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.am>> implements com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajT;
    private com.baidu.tieba.frs.entelechy.view.am bSe;
    private cf bSf;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSf = new j(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bSe = new com.baidu.tieba.frs.entelechy.view.am(this.ajT);
        this.bSe.i(this.ajT.getUniqueId());
        return new com.baidu.tieba.card.b.a(this.bSe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, av avVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Tz() == null) {
            return null;
        }
        aVar.Tz().onBindDataToView(avVar);
        aVar.Tz().setOnSubCardOnClickListenner(this.bSf);
        com.baidu.tieba.frs.e.b.adp().a(bYW, avVar);
        return aVar.getView();
    }
}
