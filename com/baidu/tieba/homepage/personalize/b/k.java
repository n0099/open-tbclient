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
    private TbPageContext<?> ajT;
    private cf baF;
    public BdUniqueId baI;
    private com.baidu.tieba.homepage.personalize.model.f cxT;
    private al cxV;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.baF = new l(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cxV = new al(this.ajT);
        if (this.cxV.bbc != null) {
            this.cxV.bbc.setReplyTimeVisible(false);
            this.cxV.bbc.setViewNumEnabled(true);
        }
        this.cxV.SK();
        this.cxV.j(this.baI);
        return new f(this.cxV);
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
            pVar.gL(i + 1);
            fVar.Tz().a(b(pVar));
            fVar.Tz().onBindDataToView(pVar);
            fVar.Tz().setOnSubCardOnClickListenner(this.baF);
            if (pVar.bbo != null && pVar.bbo.getTid() != null) {
                cc.ST().a(new as("c11003").aa("tid", pVar.bbo.getTid()));
            }
        }
        return fVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cxT = fVar;
    }
}
