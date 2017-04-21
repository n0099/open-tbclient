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
public class ak extends com.baidu.adp.widget.ListView.a<bi, a<com.baidu.tieba.frs.entelechy.view.a>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajU;
    private cf<bi> bUw;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUw = new al(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.ajU);
        aVar.j(this.ajU.getUniqueId());
        aVar.setForumName(this.mForumName);
        return new a(aVar);
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
        aVar.UB().setForumName(this.mForumName);
        aVar.UB().setOnSubCardOnClickListenner(this.bUw);
        com.baidu.tieba.frs.e.b.aeq().a(cbn, biVar);
        com.baidu.tieba.frs.e.b.aeq().x(biVar);
        if (biVar != null) {
            biVar.tm();
        }
        return aVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004a: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bp : 0x0046: INVOKE  (r2v1 com.baidu.tbadk.core.data.bp A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bi) type: VIRTUAL call: com.baidu.tbadk.core.data.bi.ts():com.baidu.tbadk.core.data.bp)
     com.baidu.tbadk.core.data.bp.channelId long)] */
    private bb j(bi biVar) {
        if (biVar == null) {
            return null;
        }
        bb bbVar = new bb();
        bbVar.mLocate = biVar.ti() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bbVar.bsM = cbn.cbf;
        bbVar.bsL = biVar.getTid();
        bbVar.mSource = biVar.Zy;
        bbVar.eXt = biVar.ZD;
        bbVar.eXu = biVar.Zz;
        bbVar.eXw = biVar.ZA;
        if (biVar.ts() != null && biVar.ts().channelId > 0) {
            bbVar.VR = new StringBuilder().append(biVar.ts().channelId).toString();
        } else {
            bbVar.VR = "0";
        }
        return bbVar;
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
