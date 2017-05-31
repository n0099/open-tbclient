package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.play.bc;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, f<com.baidu.tieba.card.y>> {
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private o.a ajq;
    private ci cBI;
    private com.baidu.tieba.homepage.personalize.model.f cBT;
    private com.baidu.tieba.card.y cBY;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajq = null;
        this.cBI = new v(this);
        this.ajh = tbPageContext;
        ajc();
    }

    private void ajc() {
        com.baidu.tieba.card.data.n.bDA = "c10708";
        com.baidu.tieba.card.data.n.bDB = "c10735";
        com.baidu.tieba.card.data.n.bDC = "c10756";
        com.baidu.tieba.card.data.n.bDD = "c10709";
        com.baidu.tieba.card.data.n.bDE = "c10734";
        com.baidu.tieba.card.data.n.bDF = "c11929";
        com.baidu.tieba.card.data.n.bDG = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cBY = new com.baidu.tieba.card.y(this.ajh);
        this.cBY.j(this.aKZ);
        this.cBY.a(this.cBI);
        return new f(this.cBY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, f fVar) {
        if (nVar != null) {
            nVar.hl(i + 1);
            nVar.sourceType = 0;
        }
        fVar.UY().a(b(nVar));
        fVar.UY().a(nVar);
        fVar.UY().a(this.ajq);
        if (nVar != null) {
            cf.Uw().a(nVar.UK());
        }
        return fVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004b: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bs : 0x0047: INVOKE  (r2v1 com.baidu.tbadk.core.data.bs A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bl : 0x0043: INVOKE  (r2v0 com.baidu.tbadk.core.data.bl A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.n) type: VIRTUAL call: com.baidu.tieba.card.data.n.LH():com.baidu.tbadk.core.data.bl)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bl.sx():com.baidu.tbadk.core.data.bs)
     com.baidu.tbadk.core.data.bs.channelId long)] */
    private bc b(com.baidu.tieba.card.data.n nVar) {
        bc bcVar = null;
        if (nVar != null) {
            bcVar = new bc();
            bcVar.mLocate = "1";
            bcVar.buq = nVar.Wg;
            if (nVar.LH() != null) {
                bcVar.bur = String.valueOf(nVar.LH().getFid());
                if (nVar.LH().sx() != null && nVar.LH().sx().channelId > 0) {
                    bcVar.UX = new StringBuilder().append(nVar.LH().sx().channelId).toString();
                } else {
                    bcVar.UX = "0";
                }
            }
            bcVar.mSource = nVar.getSource();
            bcVar.fcj = nVar.UD();
            bcVar.fch = nVar.getWeight();
        }
        return bcVar;
    }

    public void setEventCallback(o.a aVar) {
        this.ajq = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cBT = fVar;
    }
}
