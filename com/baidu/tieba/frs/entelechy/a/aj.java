package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.play.bc;
/* loaded from: classes.dex */
public class aj extends com.baidu.tieba.frs.p<bl, a<com.baidu.tieba.frs.entelechy.view.a>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajh;
    private ci<bl> bdp;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bdp = new ak(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.ajh, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.mForumName);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, a aVar) {
        if (aVar == null || aVar.UY() == null) {
            return null;
        }
        aVar.UY().a(z(blVar));
        aVar.UY().a(blVar);
        aVar.UY().setForumName(this.mForumName);
        aVar.UY().a(this.bdp);
        com.baidu.tieba.frs.d.b.adw().a(cfm, blVar);
        com.baidu.tieba.frs.d.b.adw().H(blVar);
        if (blVar != null) {
            TiebaStatic.log(new as("c12125").Z("tid", blVar.getId()).r("obj_locate", ZS() ? 2 : 1).f("obj_id", blVar.rM() != null ? blVar.rM().live_id : -1L).r("obj_type", 1));
            blVar.ss();
        }
        return aVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004a: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bs : 0x0046: INVOKE  (r2v1 com.baidu.tbadk.core.data.bs A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bl) type: VIRTUAL call: com.baidu.tbadk.core.data.bl.sx():com.baidu.tbadk.core.data.bs)
     com.baidu.tbadk.core.data.bs.channelId long)] */
    private bc z(bl blVar) {
        if (blVar == null) {
            return null;
        }
        bc bcVar = new bc();
        bcVar.mLocate = blVar.so() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bcVar.bur = cfm.cfe;
        bcVar.buq = blVar.getTid();
        bcVar.mSource = blVar.YM;
        bcVar.fcg = blVar.YR;
        bcVar.fch = blVar.YN;
        bcVar.fcj = blVar.YO;
        if (blVar.sx() != null && blVar.sx().channelId > 0) {
            bcVar.UX = new StringBuilder().append(blVar.sx().channelId).toString();
        } else {
            bcVar.UX = "0";
        }
        return bcVar;
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
