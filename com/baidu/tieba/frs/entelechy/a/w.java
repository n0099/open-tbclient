package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.widget.ListView.a<bk, a<com.baidu.tieba.frs.entelechy.view.u>> implements cb, com.baidu.tieba.frs.c.e {
    public static int bSP = 5;
    public static int bSQ = 10;
    public static int bSR = 15;
    private TbPageContext<?> ajr;
    private cd<bk> bSq;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bk bkVar, String str) {
        if (bkVar != null) {
            int sz = bkVar.sz();
            as asVar = new as(str);
            asVar.aa("obj_locate", hW(sz));
            asVar.aa("tid", bkVar.getTid());
            asVar.s("obj_type", 2);
            TiebaStatic.log(asVar);
        }
    }

    private String hW(int i) {
        if (i == bSP) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == bSQ) {
            return "10";
        }
        if (i != bSR) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bSq = new x(this);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.u uVar = new com.baidu.tieba.frs.entelechy.view.u(this.ajr, this.mPageId);
        uVar.j(this.mPageId);
        uVar.setForumName(this.forumName);
        return new a(uVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003d: IGET  (r2v1 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.br : 0x0039: INVOKE  (r2v0 com.baidu.tbadk.core.data.br A[REMOVE]) = (r6v0 com.baidu.tbadk.core.data.bk) type: VIRTUAL call: com.baidu.tbadk.core.data.bk.sC():com.baidu.tbadk.core.data.br)
     com.baidu.tbadk.core.data.br.channelId long)] */
    private bb o(bk bkVar) {
        bb bbVar = null;
        if (bkVar != null) {
            bbVar = new bb();
            bbVar.mLocate = hW(bkVar.sz());
            bbVar.btj = bZb.bYT;
            bbVar.bti = bkVar.getTid();
            bbVar.eTw = bkVar.YS;
            if (bkVar.sC() != null && bkVar.sC().channelId > 0) {
                bbVar.Vk = new StringBuilder().append(bkVar.sC().channelId).toString();
            }
            bkVar.sw();
        }
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
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.forumName = str;
    }
}
