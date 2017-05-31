package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bt;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.b.a<bt>> {
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private o.a ajq;
    private ci cBI;
    private bt cBQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajq = null;
        this.cBI = new n(this);
        this.ajh = tbPageContext;
        ajc();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a<bt> onCreateViewHolder(ViewGroup viewGroup) {
        this.cBQ = new bt(this.ajh);
        this.cBQ.j(this.aKZ);
        return new com.baidu.tieba.card.b.a<>(this.cBQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.b.a<bt> aVar) {
        if (lVar == null || aVar == null || aVar.UY() == null) {
            return null;
        }
        lVar.hl(i + 1);
        cf.Uw().a(lVar.ii("c12190"));
        aVar.UY().a(lVar);
        aVar.UY().a(this.cBI);
        aVar.UY().a(this.ajq);
        return aVar.getView();
    }

    private void ajc() {
        com.baidu.tieba.card.data.l.bDg = "c10705";
        com.baidu.tieba.card.data.l.bDh = "c10730";
        com.baidu.tieba.card.data.l.bDi = "c10731";
        com.baidu.tieba.card.data.l.bDj = "c10704";
        com.baidu.tieba.card.data.l.bDk = "c10755";
        com.baidu.tieba.card.data.l.bDl = "c10710";
        com.baidu.tieba.card.data.l.bDm = "c10736";
        com.baidu.tieba.card.data.l.bDn = "c10737";
        com.baidu.tieba.card.data.l.bDo = "c10711";
        com.baidu.tieba.card.data.l.bDp = "c10758";
        com.baidu.tieba.card.data.l.bDq = "c10757";
    }

    public void setEventCallback(o.a aVar) {
        this.ajq = aVar;
    }
}
