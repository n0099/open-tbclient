package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.widget.ListView.a<bi, a<com.baidu.tieba.frs.entelechy.view.x>> implements cd, com.baidu.tieba.frs.e.e {
    public static int bUV = 5;
    public static int bUW = 10;
    public static int bUX = 15;
    private TbPageContext<?> ajU;
    private cf<bi> bUw;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bi biVar, String str) {
        if (biVar != null) {
            int tp = biVar.tp();
            as asVar = new as(str);
            asVar.aa("obj_locate", ig(tp));
            asVar.aa("tid", biVar.getTid());
            asVar.s("obj_type", 2);
            TiebaStatic.log(asVar);
        }
    }

    private String ig(int i) {
        if (i == bUV) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == bUW) {
            return "10";
        }
        if (i != bUX) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUw = new x(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.x xVar = new com.baidu.tieba.frs.entelechy.view.x(this.ajU);
        xVar.j(this.ajU.getUniqueId());
        xVar.setForumName(this.forumName);
        return new a(xVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003d: IGET  (r2v1 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bp : 0x0039: INVOKE  (r2v0 com.baidu.tbadk.core.data.bp A[REMOVE]) = (r6v0 com.baidu.tbadk.core.data.bi) type: VIRTUAL call: com.baidu.tbadk.core.data.bi.ts():com.baidu.tbadk.core.data.bp)
     com.baidu.tbadk.core.data.bp.channelId long)] */
    private bb j(bi biVar) {
        bb bbVar = null;
        if (biVar != null) {
            bbVar = new bb();
            bbVar.mLocate = ig(biVar.tp());
            bbVar.bsM = cbn.cbf;
            bbVar.bsL = biVar.getTid();
            bbVar.eXw = biVar.ZA;
            if (biVar.ts() != null && biVar.ts().channelId > 0) {
                bbVar.VR = new StringBuilder().append(biVar.ts().channelId).toString();
            }
            biVar.tm();
        }
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        if (aVar == null || aVar.UB() == null) {
            return null;
        }
        aVar.UB().a(j(biVar));
        aVar.UB().onBindDataToView(biVar);
        aVar.UB().setOnSubCardOnClickListenner(this.bUw);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.forumName = str;
    }
}
