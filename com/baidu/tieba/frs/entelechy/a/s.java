package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.play.bb;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<bh, a<com.baidu.tieba.frs.entelechy.view.q>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> FY;
    private cf<bh> bLl;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLl = new t(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.q qVar = new com.baidu.tieba.frs.entelechy.view.q(this.FY);
        qVar.j(this.FY.getUniqueId());
        qVar.setForumName(this.forumName);
        return new a(qVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0039: IGET  (r2v2 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.bo : 0x0035: INVOKE  (r2v1 com.baidu.tbadk.core.data.bo A[REMOVE]) = (r7v0 com.baidu.tbadk.core.data.bh) type: VIRTUAL call: com.baidu.tbadk.core.data.bh.sz():com.baidu.tbadk.core.data.bo)
     com.baidu.tbadk.core.data.bo.channelId long)] */
    private bb j(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        bb bbVar = new bb();
        bbVar.mLocate = bhVar.sp() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        bbVar.bjT = bTj.bTb;
        bbVar.bjS = bhVar.getTid();
        if (bhVar.sz() != null && bhVar.sz().channelId > 0) {
            bbVar.Ql = new StringBuilder().append(bhVar.sz().channelId).toString();
        }
        bhVar.st();
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
        com.baidu.tieba.frs.e.b.acx().a(bTj, bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.forumName = str;
    }
}
