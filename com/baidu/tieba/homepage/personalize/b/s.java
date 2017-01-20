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
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private o.a aez;
    private cf cxT;
    private com.baidu.tieba.homepage.personalize.model.f cyc;
    private com.baidu.tieba.card.x cyh;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aez = null;
        this.cxT = new t(this);
        this.FY = tbPageContext;
        aku();
    }

    private void aku() {
        com.baidu.tieba.card.data.p.boB = "c10708";
        com.baidu.tieba.card.data.p.boC = "c10735";
        com.baidu.tieba.card.data.p.boD = "c10756";
        com.baidu.tieba.card.data.p.boE = "c10709";
        com.baidu.tieba.card.data.p.boF = "c10734";
        com.baidu.tieba.card.data.p.boG = "c11929";
        com.baidu.tieba.card.data.p.boH = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cyh = new com.baidu.tieba.card.x(this.FY);
        this.cyh.Ro();
        this.cyh.j(this.aUC);
        this.cyh.setOnSubCardOnClickListenner(this.cxT);
        return new f(this.cyh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.p pVar, f fVar) {
        if (pVar != null) {
            pVar.gL(i + 1);
            pVar.sourceType = 0;
        }
        fVar.Sd().a(b(pVar));
        fVar.Sd().onBindDataToView(pVar);
        fVar.Sd().a(this.aez);
        if (pVar != null) {
            cc.Rx().a(pVar.RP());
        }
        return fVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004b: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bo : 0x0047: INVOKE  (r2v1 com.baidu.tbadk.core.data.bo A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bh : 0x0043: INVOKE  (r2v0 com.baidu.tbadk.core.data.bh A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.p) type: VIRTUAL call: com.baidu.tieba.card.data.p.Ji():com.baidu.tbadk.core.data.bh)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bh.sz():com.baidu.tbadk.core.data.bo)
     com.baidu.tbadk.core.data.bo.channelId long)] */
    private bb b(com.baidu.tieba.card.data.p pVar) {
        bb bbVar = null;
        if (pVar != null) {
            bbVar = new bb();
            bbVar.mLocate = "1";
            bbVar.bjS = pVar.SK;
            if (pVar.Ji() != null) {
                bbVar.bjT = String.valueOf(pVar.Ji().getFid());
                if (pVar.Ji().sz() != null && pVar.Ji().sz().channelId > 0) {
                    bbVar.Ql = new StringBuilder().append(pVar.Ji().sz().channelId).toString();
                } else {
                    bbVar.Ql = "0";
                }
            }
            bbVar.mSource = pVar.getSource();
            bbVar.eTy = pVar.RB();
            bbVar.eTz = pVar.getWeight();
        }
        return bbVar;
    }

    public void setEventCallback(o.a aVar) {
        this.aez = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cyc = fVar;
    }
}
