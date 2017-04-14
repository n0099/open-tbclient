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
    private TbPageContext<?> ajT;
    private o.a akc;
    public BdUniqueId baI;
    private cf cxP;
    private com.baidu.tieba.homepage.personalize.model.f cxY;
    private com.baidu.tieba.card.x cyd;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akc = null;
        this.cxP = new t(this);
        this.ajT = tbPageContext;
        ajA();
    }

    private void ajA() {
        com.baidu.tieba.card.data.p.bvp = "c10708";
        com.baidu.tieba.card.data.p.bvq = "c10735";
        com.baidu.tieba.card.data.p.bvr = "c10756";
        com.baidu.tieba.card.data.p.bvs = "c10709";
        com.baidu.tieba.card.data.p.bvt = "c10734";
        com.baidu.tieba.card.data.p.bvu = "c11929";
        com.baidu.tieba.card.data.p.bvv = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cyd = new com.baidu.tieba.card.x(this.ajT);
        if (this.cyd.bbc != null) {
            this.cyd.bbc.setReplyTimeVisible(false);
            this.cyd.bbc.setViewNumEnabled(true);
        }
        this.cyd.SK();
        this.cyd.SI();
        this.cyd.j(this.baI);
        this.cyd.setOnSubCardOnClickListenner(this.cxP);
        return new f(this.cyd);
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
        fVar.Tz().a(b(pVar));
        fVar.Tz().onBindDataToView(pVar);
        fVar.Tz().a(this.akc);
        if (pVar != null) {
            cc.ST().a(pVar.Tl());
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
            bbVar.bqu = pVar.WS;
            if (pVar.Kn() != null) {
                bbVar.bqv = String.valueOf(pVar.Kn().getFid());
                if (pVar.Kn().ts() != null && pVar.Kn().ts().channelId > 0) {
                    bbVar.VP = new StringBuilder().append(pVar.Kn().ts().channelId).toString();
                } else {
                    bbVar.VP = "0";
                }
            }
            bbVar.mSource = pVar.getSource();
            bbVar.eVd = pVar.SX();
            bbVar.eVe = pVar.getWeight();
        }
        return bbVar;
    }

    public void setEventCallback(o.a aVar) {
        this.akc = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cxY = fVar;
    }
}
