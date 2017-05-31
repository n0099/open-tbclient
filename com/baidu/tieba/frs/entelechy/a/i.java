package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.ai;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<ax, com.baidu.tieba.card.b.a<ai>> implements com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajh;
    private ai bYh;
    private ci bdp;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bdp = new j(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bYh = new ai(this.ajh, this.mPageId);
        this.bYh.i(this.mPageId);
        return new com.baidu.tieba.card.b.a(this.bYh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ax axVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.UY() == null) {
            return null;
        }
        aVar.UY().a((com.baidu.tieba.card.a) axVar);
        aVar.UY().a(this.bdp);
        com.baidu.tieba.frs.d.b.adw().a(cfm, axVar);
        return aVar.getView();
    }
}
