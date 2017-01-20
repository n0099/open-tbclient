package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.p, f<al>> {
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private cf aUz;
    private com.baidu.tieba.homepage.personalize.model.f cxX;
    private al cxZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aUz = new l(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cxZ = new al(this.FY);
        this.cxZ.j(this.aUC);
        return new f(this.cxZ);
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
            fVar.Sd().a(b(pVar));
            fVar.Sd().onBindDataToView(pVar);
            fVar.Sd().setOnSubCardOnClickListenner(this.aUz);
            if (pVar.aVi != null && pVar.aVi.getTid() != null) {
                cc.Rx().a(new ar("c11003").ab("tid", pVar.aVi.getTid()));
            }
        }
        return fVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cxX = fVar;
    }
}
