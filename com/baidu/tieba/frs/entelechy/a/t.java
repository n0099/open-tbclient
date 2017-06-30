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
public class t extends com.baidu.adp.widget.ListView.a<bm, a<com.baidu.tieba.frs.entelechy.view.u>> implements cg, com.baidu.tieba.frs.d.e {
    public static int cgO = 5;
    public static int cgP = 10;
    public static int cgQ = 15;
    private TbPageContext<?> ajP;
    private ci<bm> bgj;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bm bmVar, String str) {
        if (bmVar != null) {
            int ss = bmVar.ss();
            au auVar = new au(str);
            auVar.Z("obj_locate", iG(ss));
            auVar.Z("tid", bmVar.getTid());
            auVar.r("obj_type", 2);
            TiebaStatic.log(auVar);
        }
    }

    private String iG(int i) {
        if (i == cgO) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == cgP) {
            return "10";
        }
        if (i != cgQ) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bgj = new u(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.u uVar = new com.baidu.tieba.frs.entelechy.view.u(this.ajP, this.mPageId);
        uVar.j(this.mPageId);
        uVar.setForumName(this.forumName);
        return new a(uVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003d: IGET  (r2v1 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bt : 0x0039: INVOKE  (r2v0 com.baidu.tbadk.core.data.bt A[REMOVE]) = (r6v0 com.baidu.tbadk.core.data.bm) type: VIRTUAL call: com.baidu.tbadk.core.data.bm.sv():com.baidu.tbadk.core.data.bt)
     com.baidu.tbadk.core.data.bt.channelId long)] */
    private bc A(bm bmVar) {
        bc bcVar = null;
        if (bmVar != null) {
            bcVar = new bc();
            bcVar.mLocate = iG(bmVar.ss());
            bcVar.bxM = cnC.cnu;
            bcVar.bxL = bmVar.getTid();
            bcVar.fmz = bmVar.YP;
            if (bmVar.sv() != null && bmVar.sv().channelId > 0) {
                bcVar.UW = new StringBuilder().append(bmVar.sv().channelId).toString();
            }
            bmVar.sp();
        }
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
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.forumName = str;
    }
}
