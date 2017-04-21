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
    private TbPageContext<?> ajU;
    private cf bbB;
    public BdUniqueId bbE;
    private com.baidu.tieba.homepage.personalize.model.f cAk;
    private al cAm;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bbB = new l(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cAm = new al(this.ajU);
        if (this.cAm.bbY != null) {
            this.cAm.bbY.setReplyTimeVisible(false);
            this.cAm.bbY.setViewNumEnabled(true);
        }
        this.cAm.TM();
        this.cAm.j(this.bbE);
        return new f(this.cAm);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0051: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bp : 0x004d: INVOKE  (r2v1 com.baidu.tbadk.core.data.bp A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bi : 0x0049: INVOKE  (r2v0 com.baidu.tbadk.core.data.bi A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.p) type: VIRTUAL call: com.baidu.tieba.card.data.p.Kn():com.baidu.tbadk.core.data.bi)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bi.ts():com.baidu.tbadk.core.data.bp)
     com.baidu.tbadk.core.data.bp.channelId long)] */
    private bb b(com.baidu.tieba.card.data.p pVar) {
        bb bbVar = null;
        if (pVar != null) {
            bbVar = new bb();
            bbVar.mLocate = "1";
            bbVar.bsL = pVar.WT;
            bbVar.eXw = pVar.TZ();
            if (pVar.Kn() != null) {
                bbVar.bsM = String.valueOf(pVar.Kn().getFid());
                if (pVar.Kn().ts() != null && pVar.Kn().ts().channelId > 0) {
                    bbVar.VR = new StringBuilder().append(pVar.Kn().ts().channelId).toString();
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
            pVar.gR(i + 1);
            fVar.UB().a(b(pVar));
            fVar.UB().onBindDataToView(pVar);
            fVar.UB().setOnSubCardOnClickListenner(this.bbB);
            if (pVar.bck != null && pVar.bck.getTid() != null) {
                cc.TV().a(new as("c11003").aa("tid", pVar.bck.getTid()));
            }
        }
        return fVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cAk = fVar;
    }
}
