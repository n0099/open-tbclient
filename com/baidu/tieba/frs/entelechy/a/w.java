package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.widget.ListView.a<bh, a<com.baidu.tieba.frs.entelechy.view.x>> implements cd, com.baidu.tieba.frs.e.e {
    public static int bLK = 5;
    public static int bLL = 10;
    public static int bLM = 15;
    private TbPageContext<?> FY;
    private cf<bh> bLl;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bh bhVar, String str) {
        if (bhVar != null) {
            int sw = bhVar.sw();
            ar arVar = new ar(str);
            arVar.ab("obj_locate", ib(sw));
            arVar.ab("tid", bhVar.getTid());
            arVar.s("obj_type", 2);
            TiebaStatic.log(arVar);
        }
    }

    private String ib(int i) {
        if (i == bLK) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == bLL) {
            return "10";
        }
        if (i != bLM) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLl = new x(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.x xVar = new com.baidu.tieba.frs.entelechy.view.x(this.FY);
        xVar.j(this.FY.getUniqueId());
        xVar.setForumName(this.forumName);
        return new a(xVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0039: IGET  (r2v1 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bo : 0x0035: INVOKE  (r2v0 com.baidu.tbadk.core.data.bo A[REMOVE]) = (r6v0 com.baidu.tbadk.core.data.bh) type: VIRTUAL call: com.baidu.tbadk.core.data.bh.sz():com.baidu.tbadk.core.data.bo)
     com.baidu.tbadk.core.data.bo.channelId long)] */
    private bb j(bh bhVar) {
        bb bbVar = null;
        if (bhVar != null) {
            bbVar = new bb();
            bbVar.mLocate = ib(bhVar.sw());
            bbVar.bjT = bTj.bTb;
            bbVar.bjS = bhVar.getTid();
            if (bhVar.sz() != null && bhVar.sz().channelId > 0) {
                bbVar.Ql = new StringBuilder().append(bhVar.sz().channelId).toString();
            }
            bhVar.st();
        }
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, a aVar) {
        if (aVar == null || aVar.Sd() == null) {
            return null;
        }
        aVar.Sd().a(j(bhVar));
        aVar.Sd().onBindDataToView(bhVar);
        aVar.Sd().setOnSubCardOnClickListenner(this.bLl);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.forumName = str;
    }
}
