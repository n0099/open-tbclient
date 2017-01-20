package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.r;
import java.util.HashSet;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> FY;
    private cf<bh> aUz;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bLE;
    private com.baidu.adp.lib.e.b<TbImageView> bLF;
    private com.baidu.tieba.frs.entelechy.view.aa bLP;
    private HashSet<String> bLQ;
    private int bLn;
    private String mForumName;

    private void r(bh bhVar) {
        if (this.bLQ == null) {
            this.bLQ = new HashSet<>();
        }
        if (bhVar.getTid() != null && !this.bLQ.contains(bhVar.getTid())) {
            this.bLQ.add(bhVar.getTid());
            TiebaStatic.log(new ar("c11662").s("obj_param1", 1).ab("post_id", bhVar.getTid()));
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLn = 0;
        this.aUz = new aa(this);
        this.bLE = new com.baidu.adp.lib.e.b<>(new ab(this), 6, 0);
        this.bLF = new com.baidu.adp.lib.e.b<>(new ac(this), 12, 0);
        this.FY = tbPageContext;
        this.bLn = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa> onCreateViewHolder(ViewGroup viewGroup) {
        this.bLP = new com.baidu.tieba.frs.entelechy.view.aa(this.FY);
        this.bLP.setConstrainLayoutPool(this.bLE);
        this.bLP.setConstrainImagePool(this.bLF);
        this.bLP.j(this.FY.getUniqueId());
        return new com.baidu.tieba.card.b.a<>(this.bLP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa> aVar) {
        if (bhVar != null && bhVar.rf()) {
            r(bhVar);
        }
        if (aVar == null || aVar.Sd() == null) {
            return null;
        }
        aVar.Sd().onBindDataToView(bhVar);
        aVar.Sd().setForumName(this.mForumName);
        aVar.Sd().setOnSubCardOnClickListenner(this.aUz);
        com.baidu.tieba.frs.e.b.acx().a(bTj, bhVar);
        if (bhVar != null) {
            bhVar.st();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bLP != null) {
            this.bLP.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
