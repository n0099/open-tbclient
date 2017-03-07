package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.p, f<al>> {
    private TbPageContext<?> ajF;
    private cf baM;
    public BdUniqueId baP;
    private com.baidu.tieba.homepage.personalize.model.f czt;
    private al czv;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.baM = new l(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.czv = new al(this.ajF);
        if (this.czv.bbj != null) {
            this.czv.bbj.setReplyTimeVisible(false);
            this.czv.bbj.setViewNumEnabled(true);
        }
        this.czv.Sm();
        this.czv.j(this.baP);
        return new f(this.czv);
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
                }
            }
        }
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.p pVar, f fVar) {
        if (pVar != null) {
            pVar.gI(i + 1);
            fVar.Tb().a(b(pVar));
            fVar.Tb().onBindDataToView(pVar);
            fVar.Tb().setOnSubCardOnClickListenner(this.baM);
            if (pVar.bbv != null && pVar.bbv.getTid() != null) {
                cc.Sv().a(new as("c11003").Z("tid", pVar.bbv.getTid()));
            }
        }
        return fVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.czt = fVar;
    }
}
