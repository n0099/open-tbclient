package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.ai;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<ay, com.baidu.tieba.card.b.a<ai>> implements com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajP;
    private ci bgj;
    private ai cgq;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bgj = new j(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cgq = new ai(this.ajP, this.mPageId);
        this.cgq.i(this.mPageId);
        return new com.baidu.tieba.card.b.a(this.cgq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ay ayVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().a((com.baidu.tieba.card.a) ayVar);
        aVar.Wp().a(this.bgj);
        com.baidu.tieba.frs.d.b.aho().a(cnC, ayVar);
        return aVar.getView();
    }
}
