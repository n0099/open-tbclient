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
    private TbPageContext<?> ajT;
    private com.baidu.tieba.frs.entelechy.view.aa bSJ;
    private HashSet<String> bSK;
    private int bSh;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSy;
    private com.baidu.adp.lib.e.b<TbImageView> bSz;
    private cf<bi> baF;
    private String mForumName;

    private void r(bi biVar) {
        if (this.bSK == null) {
            this.bSK = new HashSet<>();
        }
        if (biVar.getTid() != null && !this.bSK.contains(biVar.getTid())) {
            this.bSK.add(biVar.getTid());
            TiebaStatic.log(new as("c11662").s("obj_param1", 1).aa("post_id", biVar.getTid()));
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSh = 0;
        this.baF = new aa(this);
        this.bSy = new com.baidu.adp.lib.e.b<>(new ab(this), 6, 0);
        this.bSz = new com.baidu.adp.lib.e.b<>(new ac(this), 12, 0);
        this.ajT = tbPageContext;
        this.bSh = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa> onCreateViewHolder(ViewGroup viewGroup) {
        this.bSJ = new com.baidu.tieba.frs.entelechy.view.aa(this.ajT);
        this.bSJ.setConstrainLayoutPool(this.bSy);
        this.bSJ.setConstrainImagePool(this.bSz);
        this.bSJ.j(this.ajT.getUniqueId());
        return new com.baidu.tieba.card.b.a<>(this.bSJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa> aVar) {
        if (biVar != null && biVar.rW()) {
            r(biVar);
        }
        if (aVar == null || aVar.Tz() == null) {
            return null;
        }
        aVar.Tz().onBindDataToView(biVar);
        aVar.Tz().setForumName(this.mForumName);
        aVar.Tz().setOnSubCardOnClickListenner(this.baF);
        com.baidu.tieba.frs.e.b.adp().a(bYW, biVar);
        if (biVar != null) {
            biVar.tm();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bSJ != null) {
            this.bSJ.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
