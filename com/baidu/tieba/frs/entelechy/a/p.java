package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.CardFrsGodAutoVideoView;
import com.baidu.tieba.play.bc;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<bl, a<CardFrsGodAutoVideoView>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajh;
    private ci<bl> bdp;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bdp = new q(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.ajh, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003d: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bs : 0x0039: INVOKE  (r2v1 com.baidu.tbadk.core.data.bs A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bl) type: VIRTUAL call: com.baidu.tbadk.core.data.bl.sx():com.baidu.tbadk.core.data.bs)
     com.baidu.tbadk.core.data.bs.channelId long)] */
    private bc z(bl blVar) {
        if (blVar == null) {
            return null;
        }
        bc bcVar = new bc();
        bcVar.mLocate = blVar.so() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bcVar.bur = cfm.cfe;
        bcVar.buq = blVar.getTid();
        bcVar.fcj = blVar.YO;
        if (blVar.sx() != null && blVar.sx().channelId > 0) {
            bcVar.UX = new StringBuilder().append(blVar.sx().channelId).toString();
        }
        blVar.ss();
        return bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        if (aVar == null || aVar.UY() == null) {
            return null;
        }
        aVar.UY().a(z(blVar));
        aVar.UY().a(blVar);
        aVar.UY().a(this.bdp);
        com.baidu.tieba.frs.d.b.adw().a(cfm, blVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.forumName = str;
    }
}
