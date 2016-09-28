package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.az;
import com.baidu.tieba.r;
import java.util.HashSet;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.a<bi, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUl;
    private com.baidu.adp.lib.f.b<TbImageView> bUm;
    private int bVW;
    private com.baidu.tieba.frs.entelechy.view.x bWA;
    private HashSet<String> bWB;
    private cd<bi> bWu;
    private String mForumName;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVW = 0;
        this.bWu = new aa(this);
        this.bUl = new com.baidu.adp.lib.f.b<>(new ab(this), 6, 0);
        this.bUm = new com.baidu.adp.lib.f.b<>(new ac(this), 12, 0);
        this.GM = tbPageContext;
        this.bVW = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds14);
    }

    private void j(bi biVar) {
        if (this.bWB == null) {
            this.bWB = new HashSet<>();
        }
        if (biVar.getTid() != null && !this.bWB.contains(biVar.getTid())) {
            this.bWB.add(biVar.getTid());
            TiebaStatic.log(new ax("c11662").s("obj_param1", 1).ab("post_id", biVar.getTid()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: E */
    public a a(ViewGroup viewGroup) {
        this.bWA = new com.baidu.tieba.frs.entelechy.view.x(this.GM);
        this.bWA.setConstrainLayoutPool(this.bUl);
        this.bWA.setConstrainImagePool(this.bUm);
        this.bWA.j(this.GM.getUniqueId());
        return new a(this.bWA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        if (biVar != null && biVar.rw()) {
            j(biVar);
        }
        aVar.bWD.onBindDataToView(biVar);
        aVar.bWD.setForumName(this.mForumName);
        aVar.bWD.setOnSubCardOnClickListenner(this.bWu);
        com.baidu.tieba.frs.g.b.afl().a(cdl, biVar);
        if (biVar != null) {
            biVar.sL();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bWA != null) {
            this.bWA.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.view.x bWD;

        public a(com.baidu.tieba.frs.entelechy.view.x xVar) {
            super(xVar.getView());
            this.bWD = xVar;
        }
    }
}
