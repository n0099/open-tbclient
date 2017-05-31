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
public class t extends com.baidu.adp.widget.ListView.a<bl, a<com.baidu.tieba.frs.entelechy.view.u>> implements cg, com.baidu.tieba.frs.d.e {
    public static int bYF = 5;
    public static int bYG = 10;
    public static int bYH = 15;
    private TbPageContext<?> ajh;
    private ci<bl> bdp;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bl blVar, String str) {
        if (blVar != null) {
            int su = blVar.su();
            as asVar = new as(str);
            asVar.Z("obj_locate", iu(su));
            asVar.Z("tid", blVar.getTid());
            asVar.r("obj_type", 2);
            TiebaStatic.log(asVar);
        }
    }

    private String iu(int i) {
        if (i == bYF) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == bYG) {
            return "10";
        }
        if (i != bYH) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bdp = new u(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.u uVar = new com.baidu.tieba.frs.entelechy.view.u(this.ajh, this.mPageId);
        uVar.j(this.mPageId);
        uVar.setForumName(this.forumName);
        return new a(uVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003d: IGET  (r2v1 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bs : 0x0039: INVOKE  (r2v0 com.baidu.tbadk.core.data.bs A[REMOVE]) = (r6v0 com.baidu.tbadk.core.data.bl) type: VIRTUAL call: com.baidu.tbadk.core.data.bl.sx():com.baidu.tbadk.core.data.bs)
     com.baidu.tbadk.core.data.bs.channelId long)] */
    private bc z(bl blVar) {
        bc bcVar = null;
        if (blVar != null) {
            bcVar = new bc();
            bcVar.mLocate = iu(blVar.su());
            bcVar.bur = cfm.cfe;
            bcVar.buq = blVar.getTid();
            bcVar.fcj = blVar.YO;
            if (blVar.sx() != null && blVar.sx().channelId > 0) {
                bcVar.UX = new StringBuilder().append(blVar.sx().channelId).toString();
            }
            blVar.ss();
        }
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
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.forumName = str;
    }
}
