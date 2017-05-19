package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ai;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, f<ai>> {
    public BdUniqueId aLk;
    private TbPageContext<?> ajr;
    private cd bbX;
    private com.baidu.tieba.homepage.personalize.model.f cvu;
    private ai cvw;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bbX = new l(this);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cvw = new ai(this.ajr);
        this.cvw.j(this.aLk);
        return new f(this.cvw);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0051: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.br : 0x004d: INVOKE  (r2v1 com.baidu.tbadk.core.data.br A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bk : 0x0049: INVOKE  (r2v0 com.baidu.tbadk.core.data.bk A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.n) type: VIRTUAL call: com.baidu.tieba.card.data.n.JB():com.baidu.tbadk.core.data.bk)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bk.sC():com.baidu.tbadk.core.data.br)
     com.baidu.tbadk.core.data.br.channelId long)] */
    private bb b(com.baidu.tieba.card.data.n nVar) {
        bb bbVar = null;
        if (nVar != null) {
            bbVar = new bb();
            bbVar.mLocate = "1";
            bbVar.bti = nVar.Wl;
            bbVar.eTw = nVar.Ts();
            if (nVar.JB() != null) {
                bbVar.btj = String.valueOf(nVar.JB().getFid());
                if (nVar.JB().sC() != null && nVar.JB().sC().channelId > 0) {
                    bbVar.Vk = new StringBuilder().append(nVar.JB().sC().channelId).toString();
                }
            }
        }
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, f fVar) {
        if (nVar != null) {
            nVar.gN(i + 1);
            fVar.TU().a(b(nVar));
            fVar.TU().onBindDataToView(nVar);
            fVar.TU().setOnSubCardOnClickListenner(this.bbX);
            if (nVar.bcB != null && nVar.bcB.getTid() != null) {
                ca.To().a(new as("c11003").aa("tid", nVar.bcB.getTid()));
            }
        }
        return fVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cvu = fVar;
    }
}
