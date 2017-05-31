package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.am;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.play.bc;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, f<am>> {
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private ci bdm;
    private com.baidu.tieba.homepage.personalize.model.f cBM;
    private am cBO;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bdm = new l(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cBO = new am(this.ajh);
        this.cBO.j(this.aKZ);
        return new f(this.cBO);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0051: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bs : 0x004d: INVOKE  (r2v1 com.baidu.tbadk.core.data.bs A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bl : 0x0049: INVOKE  (r2v0 com.baidu.tbadk.core.data.bl A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.n) type: VIRTUAL call: com.baidu.tieba.card.data.n.LH():com.baidu.tbadk.core.data.bl)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bl.sx():com.baidu.tbadk.core.data.bs)
     com.baidu.tbadk.core.data.bs.channelId long)] */
    private bc b(com.baidu.tieba.card.data.n nVar) {
        bc bcVar = null;
        if (nVar != null) {
            bcVar = new bc();
            bcVar.mLocate = "1";
            bcVar.buq = nVar.Wg;
            bcVar.fcj = nVar.UD();
            if (nVar.LH() != null) {
                bcVar.bur = String.valueOf(nVar.LH().getFid());
                if (nVar.LH().sx() != null && nVar.LH().sx().channelId > 0) {
                    bcVar.UX = new StringBuilder().append(nVar.LH().sx().channelId).toString();
                }
            }
        }
        return bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, f fVar) {
        if (nVar != null) {
            nVar.hl(i + 1);
            fVar.UY().a(b(nVar));
            fVar.UY().a(nVar);
            fVar.UY().a(this.bdm);
            if (nVar.aYA != null && nVar.aYA.getTid() != null) {
                cf.Uw().a(new as("c11003").Z("tid", nVar.aYA.getTid()));
            }
        }
        return fVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cBM = fVar;
    }
}
