package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.play.bc;
/* loaded from: classes.dex */
public class aj extends com.baidu.tieba.frs.p<bm, a<com.baidu.tieba.frs.entelechy.view.a>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajP;
    private ci<bm> bgj;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bgj = new ak(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.ajP, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.mForumName);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bm bmVar, a aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().a(A(bmVar));
        aVar.Wp().a(bmVar);
        aVar.Wp().setForumName(this.mForumName);
        aVar.Wp().a(this.bgj);
        com.baidu.tieba.frs.d.b.aho().a(cnC, bmVar);
        com.baidu.tieba.frs.d.b.aho().I(bmVar);
        if (bmVar != null) {
            TiebaStatic.log(new au("c12125").Z("tid", bmVar.getId()).r("obj_locate", adJ() ? 2 : 1).f("obj_id", bmVar.rJ() != null ? bmVar.rJ().live_id : -1L).r("obj_type", 1));
            bmVar.sp();
        }
        return aVar.getView();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x004a: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bt : 0x0046: INVOKE  (r2v1 com.baidu.tbadk.core.data.bt A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bm) type: VIRTUAL call: com.baidu.tbadk.core.data.bm.sv():com.baidu.tbadk.core.data.bt)
     com.baidu.tbadk.core.data.bt.channelId long)] */
    private bc A(bm bmVar) {
        if (bmVar == null) {
            return null;
        }
        bc bcVar = new bc();
        bcVar.mLocate = bmVar.sl() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bcVar.bxM = cnC.cnu;
        bcVar.bxL = bmVar.getTid();
        bcVar.mSource = bmVar.YN;
        bcVar.fmw = bmVar.YS;
        bcVar.fmx = bmVar.YO;
        bcVar.fmz = bmVar.YP;
        if (bmVar.sv() != null && bmVar.sv().channelId > 0) {
            bcVar.UW = new StringBuilder().append(bmVar.sv().channelId).toString();
        } else {
            bcVar.UW = "0";
        }
        return bcVar;
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
