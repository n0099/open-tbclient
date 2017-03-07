package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.widget.ListView.a<bj, a<com.baidu.tieba.frs.entelechy.view.x>> implements cd, com.baidu.tieba.frs.e.e {
    public static int bSQ = 5;
    public static int bSR = 10;
    public static int bSS = 15;
    private TbPageContext<?> ajF;
    private cf<bj> bSr;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bj bjVar, String str) {
        if (bjVar != null) {
            int sR = bjVar.sR();
            as asVar = new as(str);
            asVar.Z("obj_locate", hX(sR));
            asVar.Z("tid", bjVar.getTid());
            asVar.s("obj_type", 2);
            TiebaStatic.log(asVar);
        }
    }

    private String hX(int i) {
        if (i == bSQ) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == bSR) {
            return "10";
        }
        if (i != bSS) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSr = new x(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.x xVar = new com.baidu.tieba.frs.entelechy.view.x(this.ajF);
        xVar.j(this.ajF.getUniqueId());
        xVar.setForumName(this.forumName);
        return new a(xVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0039: IGET  (r2v1 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bq : 0x0035: INVOKE  (r2v0 com.baidu.tbadk.core.data.bq A[REMOVE]) = (r6v0 com.baidu.tbadk.core.data.bj) type: VIRTUAL call: com.baidu.tbadk.core.data.bj.sU():com.baidu.tbadk.core.data.bq)
     com.baidu.tbadk.core.data.bq.channelId long)] */
    private bb j(bj bjVar) {
        bb bbVar = null;
        if (bjVar != null) {
            bbVar = new bb();
            bbVar.mLocate = hX(bjVar.sR());
            bbVar.bqC = cav.can;
            bbVar.bqB = bjVar.getTid();
            if (bjVar.sU() != null && bjVar.sU().channelId > 0) {
                bbVar.Vy = new StringBuilder().append(bjVar.sU().channelId).toString();
            }
            bjVar.sO();
        }
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, a aVar) {
        if (aVar == null || aVar.Tb() == null) {
            return null;
        }
        aVar.Tb().a(j(bjVar));
        aVar.Tb().onBindDataToView(bjVar);
        aVar.Tb().setOnSubCardOnClickListenner(this.bSr);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.forumName = str;
    }
}
