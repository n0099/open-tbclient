package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.CardFrsGodAutoVideoView;
import com.baidu.tieba.play.bc;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<bm, a<CardFrsGodAutoVideoView>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajP;
    private ci<bm> bgj;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bgj = new q(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.ajP, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        return new a(aVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003d: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bt : 0x0039: INVOKE  (r2v1 com.baidu.tbadk.core.data.bt A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bm) type: VIRTUAL call: com.baidu.tbadk.core.data.bm.sv():com.baidu.tbadk.core.data.bt)
     com.baidu.tbadk.core.data.bt.channelId long)] */
    private bc A(bm bmVar) {
        if (bmVar == null) {
            return null;
        }
        bc bcVar = new bc();
        bcVar.mLocate = bmVar.sl() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bcVar.bxM = cnC.cnu;
        bcVar.bxL = bmVar.getTid();
        bcVar.fmz = bmVar.YP;
        if (bmVar.sv() != null && bmVar.sv().channelId > 0) {
            bcVar.UW = new StringBuilder().append(bmVar.sv().channelId).toString();
        }
        bmVar.sp();
        return bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bm bmVar, a aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().a(A(bmVar));
        aVar.Wp().a(bmVar);
        aVar.Wp().a(this.bgj);
        com.baidu.tieba.frs.d.b.aho().a(cnC, bmVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.forumName = str;
    }
}
