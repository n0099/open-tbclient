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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.a<bg, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUs;
    private com.baidu.adp.lib.f.b<TbImageView> bUt;
    private int bVX;
    private com.baidu.tieba.frs.entelechy.view.x bWB;
    private cf<bg> bWv;
    private String mForumName;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVX = 0;
        this.bWv = new aa(this);
        this.bUs = new com.baidu.adp.lib.f.b<>(new ab(this), 6, 0);
        this.bUt = new com.baidu.adp.lib.f.b<>(new ac(this), 12, 0);
        this.GM = tbPageContext;
        this.bVX = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: E */
    public a a(ViewGroup viewGroup) {
        this.bWB = new com.baidu.tieba.frs.entelechy.view.x(this.GM);
        this.bWB.setConstrainLayoutPool(this.bUs);
        this.bWB.setConstrainImagePool(this.bUt);
        this.bWB.j(this.GM.getUniqueId());
        return new a(this.bWB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, a aVar) {
        aVar.bWD.onBindDataToView(bgVar);
        aVar.bWD.setForumName(this.mForumName);
        aVar.bWD.setOnSubCardOnClickListenner(this.bWv);
        com.baidu.tieba.frs.g.b.aeX().a(cdn, bgVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bWB != null) {
            this.bWB.setFromCDN(z);
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
