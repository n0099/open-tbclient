package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.am;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.play.bc;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, f<am>> {
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private ci bgf;
    private com.baidu.tieba.homepage.personalize.model.f cJJ;
    private am cJL;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgf = new l(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        this.cJL = new am(this.ajP);
        this.cJL.j(this.aMp);
        return new f(this.cJL);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0051: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bt : 0x004d: INVOKE  (r2v1 com.baidu.tbadk.core.data.bt A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bm : 0x0049: INVOKE  (r2v0 com.baidu.tbadk.core.data.bm A[REMOVE]) = (r6v0 com.baidu.tieba.card.data.n) type: VIRTUAL call: com.baidu.tieba.card.data.n.Mv():com.baidu.tbadk.core.data.bm)
     type: VIRTUAL call: com.baidu.tbadk.core.data.bm.sv():com.baidu.tbadk.core.data.bt)
     com.baidu.tbadk.core.data.bt.channelId long)] */
    private bc b(com.baidu.tieba.card.data.n nVar) {
        bc bcVar = null;
        if (nVar != null) {
            bcVar = new bc();
            bcVar.mLocate = "1";
            bcVar.bxL = nVar.Wg;
            bcVar.fmz = nVar.VU();
            if (nVar.Mv() != null) {
                bcVar.bxM = String.valueOf(nVar.Mv().getFid());
                if (nVar.Mv().sv() != null && nVar.Mv().sv().channelId > 0) {
                    bcVar.UW = new StringBuilder().append(nVar.Mv().sv().channelId).toString();
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
            nVar.ho(i + 1);
            fVar.Wp().a(b(nVar));
            fVar.Wp().a(nVar);
            fVar.Wp().a(this.bgf);
            if (nVar.bai != null && nVar.bai.getTid() != null) {
                cf.VN().a(new au("c11003").Z("tid", nVar.bai.getTid()));
            }
        }
        return fVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cJJ = fVar;
    }
}
