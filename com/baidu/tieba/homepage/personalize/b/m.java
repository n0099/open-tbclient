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
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private o.a akb;
    private ci cJF;
    private bt cJN;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akb = null;
        this.cJF = new n(this);
        this.ajP = tbPageContext;
        amO();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a<bt> onCreateViewHolder(ViewGroup viewGroup) {
        this.cJN = new bt(this.ajP);
        this.cJN.j(this.aMp);
        return new com.baidu.tieba.card.b.a<>(this.cJN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.b.a<bt> aVar) {
        if (lVar == null || aVar == null || aVar.Wp() == null) {
            return null;
        }
        lVar.ho(i + 1);
        cf.VN().a(lVar.iQ("c12190"));
        aVar.Wp().a(lVar);
        aVar.Wp().a(this.cJF);
        aVar.Wp().a(this.akb);
        return aVar.getView();
    }

    private void amO() {
        com.baidu.tieba.card.data.l.bDZ = "c10705";
        com.baidu.tieba.card.data.l.bEa = "c10730";
        com.baidu.tieba.card.data.l.bEb = "c10731";
        com.baidu.tieba.card.data.l.bEc = "c10704";
        com.baidu.tieba.card.data.l.bEd = "c10755";
        com.baidu.tieba.card.data.l.bEe = "c10710";
        com.baidu.tieba.card.data.l.bEf = "c10736";
        com.baidu.tieba.card.data.l.bEg = "c10737";
        com.baidu.tieba.card.data.l.bEh = "c10711";
        com.baidu.tieba.card.data.l.bEi = "c10758";
        com.baidu.tieba.card.data.l.bEj = "c10757";
    }

    public void setEventCallback(o.a aVar) {
        this.akb = aVar;
    }
}
