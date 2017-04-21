package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.p, f<com.baidu.tieba.card.x>> {
    private TbPageContext<?> ajU;
    private o.a akd;
    public BdUniqueId bbE;
    private cf cAg;
    private com.baidu.tieba.homepage.personalize.model.f cAp;
    private com.baidu.tieba.card.x cAu;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akd = null;
        this.cAg = new t(this);
        this.ajU = tbPageContext;
        akB();
    }

    private void akB() {
        com.baidu.tieba.card.data.p.bxG = "c10708";
        com.baidu.tieba.card.data.p.bxH = "c10735";
        com.baidu.tieba.card.data.p.bxI = "c10756";
        com.baidu.tieba.card.data.p.bxJ = "c10709";
        com.baidu.tieba.card.data.p.bxK = "c10734";
        com.baidu.tieba.card.data.p.bxL = "c11929";
        com.baidu.tieba.card.data.p.bxM = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cAu = new com.baidu.tieba.card.x(this.ajU);
        if (this.cAu.bbY != null) {
            this.cAu.bbY.setReplyTimeVisible(false);
            this.cAu.bbY.setViewNumEnabled(true);
        }
        this.cAu.TM();
        this.cAu.TK();
        this.cAu.j(this.bbE);
        this.cAu.setOnSubCardOnClickListenner(this.cAg);
        return new f(this.cAu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.p pVar, f fVar) {
        if (pVar != null) {
            pVar.gR(i + 1);
            pVar.sourceType = 0;
        }
        fVar.UB().a(b(pVar));
        fVar.UB().onBindDataToView(pVar);
        fVar.UB().a(this.akd);
        if (pVar != null) {
            cc.TV().a(pVar.Un());
        }
        return fVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004b: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bp : 0x0047: INVOKE  (r2v1 com.baidu.tbadk.core.data.bp A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bi : 0x0043: INVOKE  (r2v0 com.baidu.tbadk.core.data.bi A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.p) type: VIRTUAL call: com.baidu.tieba.card.data.p.Kn():com.baidu.tbadk.core.data.bi)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bi.ts():com.baidu.tbadk.core.data.bp)
     com.baidu.tbadk.core.data.bp.channelId long)] */
    private bb b(com.baidu.tieba.card.data.p pVar) {
        bb bbVar = null;
        if (pVar != null) {
            bbVar = new bb();
            bbVar.mLocate = "1";
            bbVar.bsL = pVar.WT;
            if (pVar.Kn() != null) {
                bbVar.bsM = String.valueOf(pVar.Kn().getFid());
                if (pVar.Kn().ts() != null && pVar.Kn().ts().channelId > 0) {
                    bbVar.VR = new StringBuilder().append(pVar.Kn().ts().channelId).toString();
                } else {
                    bbVar.VR = "0";
                }
            }
            bbVar.mSource = pVar.getSource();
            bbVar.eXw = pVar.TZ();
            bbVar.eXu = pVar.getWeight();
        }
        return bbVar;
    }

    public void setEventCallback(o.a aVar) {
        this.akd = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cAp = fVar;
    }
}
