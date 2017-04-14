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
    private TbPageContext<?> ajT;
    private cf<bi> bSf;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSf = new al(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.ajT);
        aVar.j(this.ajT.getUniqueId());
        aVar.setForumName(this.mForumName);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        if (aVar == null || aVar.Tz() == null) {
            return null;
        }
        aVar.Tz().a(j(biVar));
        aVar.Tz().onBindDataToView(biVar);
        aVar.Tz().setForumName(this.mForumName);
        aVar.Tz().setOnSubCardOnClickListenner(this.bSf);
        com.baidu.tieba.frs.e.b.adp().a(bYW, biVar);
        com.baidu.tieba.frs.e.b.adp().x(biVar);
        if (biVar != null) {
            biVar.tm();
        }
        return aVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0046: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bp : 0x0042: INVOKE  (r2v1 com.baidu.tbadk.core.data.bp A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bi) type: VIRTUAL call: com.baidu.tbadk.core.data.bi.ts():com.baidu.tbadk.core.data.bp)
     com.baidu.tbadk.core.data.bp.channelId long)] */
    private bb j(bi biVar) {
        if (biVar == null) {
            return null;
        }
        bb bbVar = new bb();
        bbVar.mLocate = biVar.ti() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bbVar.bqv = bYW.bYO;
        bbVar.bqu = biVar.getTid();
        bbVar.mSource = biVar.Zx;
        bbVar.eVd = biVar.ZC;
        bbVar.eVe = biVar.Zy;
        if (biVar.ts() != null && biVar.ts().channelId > 0) {
            bbVar.VP = new StringBuilder().append(biVar.ts().channelId).toString();
        } else {
            bbVar.VP = "0";
        }
        return bbVar;
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
