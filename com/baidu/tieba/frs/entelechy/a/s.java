package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<bj, a<com.baidu.tieba.frs.entelechy.view.q>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajF;
    private cf<bj> bSr;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSr = new t(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.q qVar = new com.baidu.tieba.frs.entelechy.view.q(this.ajF);
        qVar.j(this.ajF.getUniqueId());
        qVar.setForumName(this.forumName);
        return new a(qVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0039: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bq : 0x0035: INVOKE  (r2v1 com.baidu.tbadk.core.data.bq A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bj) type: VIRTUAL call: com.baidu.tbadk.core.data.bj.sU():com.baidu.tbadk.core.data.bq)
     com.baidu.tbadk.core.data.bq.channelId long)] */
    private bb j(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        bb bbVar = new bb();
        bbVar.mLocate = bjVar.sK() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bbVar.bqC = cav.can;
        bbVar.bqB = bjVar.getTid();
        if (bjVar.sU() != null && bjVar.sU().channelId > 0) {
            bbVar.Vy = new StringBuilder().append(bjVar.sU().channelId).toString();
        }
        bjVar.sO();
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, a aVar) {
        if (aVar == null || aVar.Tb() == null) {
            return null;
        }
        aVar.Tb().a(j(bjVar));
        aVar.Tb().onBindDataToView(bjVar);
        aVar.Tb().setOnSubCardOnClickListenner(this.bSr);
        com.baidu.tieba.frs.e.b.adv().a(cav, bjVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.forumName = str;
    }
}
