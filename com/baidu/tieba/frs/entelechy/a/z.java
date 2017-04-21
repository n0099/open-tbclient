package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
import java.util.HashSet;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.a<bi, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajU;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bUP;
    private com.baidu.adp.lib.e.b<TbImageView> bUQ;
    private int bUy;
    private com.baidu.tieba.frs.entelechy.view.aa bVa;
    private HashSet<String> bVb;
    private cf<bi> bbB;
    private String mForumName;

    private void r(bi biVar) {
        if (this.bVb == null) {
            this.bVb = new HashSet<>();
        }
        if (biVar.getTid() != null && !this.bVb.contains(biVar.getTid())) {
            this.bVb.add(biVar.getTid());
            TiebaStatic.log(new as("c11662").s("obj_param1", 1).aa("post_id", biVar.getTid()));
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUy = 0;
        this.bbB = new aa(this);
        this.bUP = new com.baidu.adp.lib.e.b<>(new ab(this), 6, 0);
        this.bUQ = new com.baidu.adp.lib.e.b<>(new ac(this), 12, 0);
        this.ajU = tbPageContext;
        this.bUy = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa> onCreateViewHolder(ViewGroup viewGroup) {
        this.bVa = new com.baidu.tieba.frs.entelechy.view.aa(this.ajU);
        this.bVa.setConstrainLayoutPool(this.bUP);
        this.bVa.setConstrainImagePool(this.bUQ);
        this.bVa.j(this.ajU.getUniqueId());
        return new com.baidu.tieba.card.b.a<>(this.bVa);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa> aVar) {
        if (biVar != null && biVar.rW()) {
            r(biVar);
        }
        if (aVar == null || aVar.UB() == null) {
            return null;
        }
        aVar.UB().onBindDataToView(biVar);
        aVar.UB().setForumName(this.mForumName);
        aVar.UB().setOnSubCardOnClickListenner(this.bbB);
        com.baidu.tieba.frs.e.b.aeq().a(cbn, biVar);
        if (biVar != null) {
            biVar.tm();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bVa != null) {
            this.bVa.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
