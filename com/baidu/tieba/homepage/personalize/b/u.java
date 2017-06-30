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
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private o.a akb;
    private ci cJF;
    private com.baidu.tieba.homepage.personalize.model.f cJQ;
    private com.baidu.tieba.card.y cJV;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akb = null;
        this.cJF = new v(this);
        this.ajP = tbPageContext;
        amO();
    }

    private void amO() {
        com.baidu.tieba.card.data.n.bEt = "c10708";
        com.baidu.tieba.card.data.n.bEu = "c10735";
        com.baidu.tieba.card.data.n.bEv = "c10756";
        com.baidu.tieba.card.data.n.bEw = "c10709";
        com.baidu.tieba.card.data.n.bEx = "c10734";
        com.baidu.tieba.card.data.n.bEy = "c11929";
        com.baidu.tieba.card.data.n.bEz = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cJV = new com.baidu.tieba.card.y(this.ajP);
        this.cJV.j(this.aMp);
        this.cJV.a(this.cJF);
        return new f(this.cJV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, f fVar) {
        if (nVar != null) {
            nVar.ho(i + 1);
            nVar.sourceType = 0;
        }
        fVar.Wp().a(b(nVar));
        fVar.Wp().a(nVar);
        fVar.Wp().a(this.akb);
        if (nVar != null) {
            cf.VN().a(nVar.Wb());
        }
        return fVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004b: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bt : 0x0047: INVOKE  (r2v1 com.baidu.tbadk.core.data.bt A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bm : 0x0043: INVOKE  (r2v0 com.baidu.tbadk.core.data.bm A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.n) type: VIRTUAL call: com.baidu.tieba.card.data.n.Mv():com.baidu.tbadk.core.data.bm)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bm.sv():com.baidu.tbadk.core.data.bt)
     com.baidu.tbadk.core.data.bt.channelId long)] */
    private bc b(com.baidu.tieba.card.data.n nVar) {
        bc bcVar = null;
        if (nVar != null) {
            bcVar = new bc();
            bcVar.mLocate = "1";
            bcVar.bxL = nVar.Wg;
            if (nVar.Mv() != null) {
                bcVar.bxM = String.valueOf(nVar.Mv().getFid());
                if (nVar.Mv().sv() != null && nVar.Mv().sv().channelId > 0) {
                    bcVar.UW = new StringBuilder().append(nVar.Mv().sv().channelId).toString();
                } else {
                    bcVar.UW = "0";
                }
            }
            bcVar.mSource = nVar.getSource();
            bcVar.fmz = nVar.VU();
            bcVar.fmx = nVar.getWeight();
        }
        return bcVar;
    }

    public void setEventCallback(o.a aVar) {
        this.akb = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cJQ = fVar;
    }
}
