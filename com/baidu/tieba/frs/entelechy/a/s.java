package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<bi, a<com.baidu.tieba.frs.entelechy.view.q>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajU;
    private cf<bi> bUw;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUw = new t(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.q qVar = new com.baidu.tieba.frs.entelechy.view.q(this.ajU);
        qVar.j(this.ajU.getUniqueId());
        qVar.setForumName(this.forumName);
        return new a(qVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003d: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bp : 0x0039: INVOKE  (r2v1 com.baidu.tbadk.core.data.bp A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bi) type: VIRTUAL call: com.baidu.tbadk.core.data.bi.ts():com.baidu.tbadk.core.data.bp)
     com.baidu.tbadk.core.data.bp.channelId long)] */
    private bb j(bi biVar) {
        if (biVar == null) {
            return null;
        }
        bb bbVar = new bb();
        bbVar.mLocate = biVar.ti() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bbVar.bsM = cbn.cbf;
        bbVar.bsL = biVar.getTid();
        bbVar.eXw = biVar.ZA;
        if (biVar.ts() != null && biVar.ts().channelId > 0) {
            bbVar.VR = new StringBuilder().append(biVar.ts().channelId).toString();
        }
        biVar.tm();
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        if (aVar == null || aVar.UB() == null) {
            return null;
        }
        aVar.UB().a(j(biVar));
        aVar.UB().onBindDataToView(biVar);
        aVar.UB().setOnSubCardOnClickListenner(this.bUw);
        com.baidu.tieba.frs.e.b.aeq().a(cbn, biVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.forumName = str;
    }
}
