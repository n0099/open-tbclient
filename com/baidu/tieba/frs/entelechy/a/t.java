package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.az;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.a<bi, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUl;
    private com.baidu.adp.lib.f.b<TbImageView> bUm;
    private com.baidu.tieba.frs.entelechy.view.t bWt;
    private cd<bi> bWu;
    private String mForumName;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bWu = new u(this);
        this.bUl = new com.baidu.adp.lib.f.b<>(new v(this), 6, 0);
        this.bUm = new com.baidu.adp.lib.f.b<>(new w(this), 12, 0);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public a a(ViewGroup viewGroup) {
        this.bWt = new com.baidu.tieba.frs.entelechy.view.t(this.GM);
        this.bWt.setConstrainLayoutPool(this.bUl);
        this.bWt.setConstrainImagePool(this.bUm);
        this.bWt.setForumName(this.mForumName);
        this.bWt.j(this.GM.getUniqueId());
        return new a(this.bWt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        aVar.bWw.k(biVar);
        aVar.bWw.setOnSubCardOnClickListenner(this.bWu);
        com.baidu.tieba.frs.g.b.afl().a(cdl, biVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bWt != null) {
            this.bWt.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.view.t bWw;

        public a(com.baidu.tieba.frs.entelechy.view.t tVar) {
            super(tVar.getView());
            this.bWw = tVar;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
