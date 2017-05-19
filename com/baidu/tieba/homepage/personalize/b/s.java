package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, f<com.baidu.tieba.card.u>> {
    public BdUniqueId aLk;
    private o.a ajA;
    private TbPageContext<?> ajr;
    private com.baidu.tieba.card.u cvE;
    private cd cvq;
    private com.baidu.tieba.homepage.personalize.model.f cvz;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajA = null;
        this.cvq = new t(this);
        this.ajr = tbPageContext;
        ahN();
    }

    private void ahN() {
        com.baidu.tieba.card.data.n.bxE = "c10708";
        com.baidu.tieba.card.data.n.bxF = "c10735";
        com.baidu.tieba.card.data.n.bxG = "c10756";
        com.baidu.tieba.card.data.n.bxH = "c10709";
        com.baidu.tieba.card.data.n.bxI = "c10734";
        com.baidu.tieba.card.data.n.bxJ = "c11929";
        com.baidu.tieba.card.data.n.bxK = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cvE = new com.baidu.tieba.card.u(this.ajr);
        this.cvE.j(this.aLk);
        this.cvE.setOnSubCardOnClickListenner(this.cvq);
        return new f(this.cvE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, f fVar) {
        if (nVar != null) {
            nVar.gN(i + 1);
            nVar.sourceType = 0;
        }
        fVar.TU().a(b(nVar));
        fVar.TU().onBindDataToView(nVar);
        fVar.TU().a(this.ajA);
        if (nVar != null) {
            ca.To().a(nVar.TG());
        }
        return fVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004b: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.br : 0x0047: INVOKE  (r2v1 com.baidu.tbadk.core.data.br A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bk : 0x0043: INVOKE  (r2v0 com.baidu.tbadk.core.data.bk A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.n) type: VIRTUAL call: com.baidu.tieba.card.data.n.JB():com.baidu.tbadk.core.data.bk)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bk.sC():com.baidu.tbadk.core.data.br)
     com.baidu.tbadk.core.data.br.channelId long)] */
    private bb b(com.baidu.tieba.card.data.n nVar) {
        bb bbVar = null;
        if (nVar != null) {
            bbVar = new bb();
            bbVar.mLocate = "1";
            bbVar.bti = nVar.Wl;
            if (nVar.JB() != null) {
                bbVar.btj = String.valueOf(nVar.JB().getFid());
                if (nVar.JB().sC() != null && nVar.JB().sC().channelId > 0) {
                    bbVar.Vk = new StringBuilder().append(nVar.JB().sC().channelId).toString();
                } else {
                    bbVar.Vk = "0";
                }
            }
            bbVar.mSource = nVar.getSource();
            bbVar.eTw = nVar.Ts();
            bbVar.eTu = nVar.getWeight();
        }
        return bbVar;
    }

    public void setEventCallback(o.a aVar) {
        this.ajA = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cvz = fVar;
    }
}
