package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.entelechy.view.az;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.a<bg, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUs;
    private com.baidu.adp.lib.f.b<TbImageView> bUt;
    private com.baidu.tieba.frs.entelechy.view.t bWu;
    private cf<bg> bWv;
    private String mForumName;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bWv = new u(this);
        this.bUs = new com.baidu.adp.lib.f.b<>(new v(this), 6, 0);
        this.bUt = new com.baidu.adp.lib.f.b<>(new w(this), 12, 0);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public a a(ViewGroup viewGroup) {
        this.bWu = new com.baidu.tieba.frs.entelechy.view.t(this.GM);
        this.bWu.setConstrainLayoutPool(this.bUs);
        this.bWu.setConstrainImagePool(this.bUt);
        this.bWu.setForumName(this.mForumName);
        this.bWu.j(this.GM.getUniqueId());
        return new a(this.bWu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, a aVar) {
        aVar.bWx.i(bgVar);
        aVar.bWx.setOnSubCardOnClickListenner(this.bWv);
        com.baidu.tieba.frs.g.b.aeX().a(cdn, bgVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bWu != null) {
            this.bWu.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.view.t bWx;

        public a(com.baidu.tieba.frs.entelechy.view.t tVar) {
            super(tVar.getView());
            this.bWx = tVar;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
