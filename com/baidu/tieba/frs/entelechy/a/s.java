package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.CardFrsGodAutoVideoView;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<bk, a<CardFrsGodAutoVideoView>> implements cb, com.baidu.tieba.frs.c.e {
    private TbPageContext<?> ajr;
    private cd<bk> bSq;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bSq = new t(this);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.ajr, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003d: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.br : 0x0039: INVOKE  (r2v1 com.baidu.tbadk.core.data.br A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bk) type: VIRTUAL call: com.baidu.tbadk.core.data.bk.sC():com.baidu.tbadk.core.data.br)
     com.baidu.tbadk.core.data.br.channelId long)] */
    private bb o(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        bb bbVar = new bb();
        bbVar.mLocate = bkVar.ss() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bbVar.btj = bZb.bYT;
        bbVar.bti = bkVar.getTid();
        bbVar.eTw = bkVar.YS;
        if (bkVar.sC() != null && bkVar.sC().channelId > 0) {
            bbVar.Vk = new StringBuilder().append(bkVar.sC().channelId).toString();
        }
        bkVar.sw();
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        if (aVar == null || aVar.TU() == null) {
            return null;
        }
        aVar.TU().a(o(bkVar));
        aVar.TU().onBindDataToView(bkVar);
        aVar.TU().setOnSubCardOnClickListenner(this.bSq);
        com.baidu.tieba.frs.c.b.acs().a(bZb, bkVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.forumName = str;
    }
}
