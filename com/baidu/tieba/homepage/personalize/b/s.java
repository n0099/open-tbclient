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
    private TbPageContext<?> ajF;
    private o.a ajO;
    public BdUniqueId baP;
    private com.baidu.tieba.card.x czD;
    private cf czp;
    private com.baidu.tieba.homepage.personalize.model.f czy;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajO = null;
        this.czp = new t(this);
        this.ajF = tbPageContext;
        ajG();
    }

    private void ajG() {
        com.baidu.tieba.card.data.p.bvw = "c10708";
        com.baidu.tieba.card.data.p.bvx = "c10735";
        com.baidu.tieba.card.data.p.bvy = "c10756";
        com.baidu.tieba.card.data.p.bvz = "c10709";
        com.baidu.tieba.card.data.p.bvA = "c10734";
        com.baidu.tieba.card.data.p.bvB = "c11929";
        com.baidu.tieba.card.data.p.bvC = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.czD = new com.baidu.tieba.card.x(this.ajF);
        if (this.czD.bbj != null) {
            this.czD.bbj.setReplyTimeVisible(false);
            this.czD.bbj.setViewNumEnabled(true);
        }
        this.czD.Sm();
        this.czD.Sk();
        this.czD.j(this.baP);
        this.czD.setOnSubCardOnClickListenner(this.czp);
        return new f(this.czD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.p pVar, f fVar) {
        if (pVar != null) {
            pVar.gI(i + 1);
            pVar.sourceType = 0;
        }
        fVar.Tb().a(b(pVar));
        fVar.Tb().onBindDataToView(pVar);
        fVar.Tb().a(this.ajO);
        if (pVar != null) {
            cc.Sv().a(pVar.SN());
        }
        return fVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004b: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bq : 0x0047: INVOKE  (r2v1 com.baidu.tbadk.core.data.bq A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bj : 0x0043: INVOKE  (r2v0 com.baidu.tbadk.core.data.bj A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.p) type: VIRTUAL call: com.baidu.tieba.card.data.p.JN():com.baidu.tbadk.core.data.bj)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bj.sU():com.baidu.tbadk.core.data.bq)
     com.baidu.tbadk.core.data.bq.channelId long)] */
    private bb b(com.baidu.tieba.card.data.p pVar) {
        bb bbVar = null;
        if (pVar != null) {
            bbVar = new bb();
            bbVar.mLocate = "1";
            bbVar.bqB = pVar.WD;
            if (pVar.JN() != null) {
                bbVar.bqC = String.valueOf(pVar.JN().getFid());
                if (pVar.JN().sU() != null && pVar.JN().sU().channelId > 0) {
                    bbVar.Vy = new StringBuilder().append(pVar.JN().sU().channelId).toString();
                } else {
                    bbVar.Vy = "0";
                }
            }
            bbVar.mSource = pVar.getSource();
            bbVar.eXe = pVar.Sz();
            bbVar.eXf = pVar.getWeight();
        }
        return bbVar;
    }

    public void setEventCallback(o.a aVar) {
        this.ajO = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.czy = fVar;
    }
}
