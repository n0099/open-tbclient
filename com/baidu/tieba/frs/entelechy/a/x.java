package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.frs.entelechy.view.ba;
import com.baidu.tieba.frs.entelechy.view.s;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<bk, a> implements ba, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> GO;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bXs;
    private com.baidu.adp.lib.f.b<TbImageView> bXt;
    private s bZK;
    private bz<bk> bZL;
    private String mForumName;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZL = new y(this);
        this.bXs = new com.baidu.adp.lib.f.b<>(new z(this), 6, 0);
        this.bXt = new com.baidu.adp.lib.f.b<>(new aa(this), 12, 0);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: J */
    public a a(ViewGroup viewGroup) {
        this.bZK = new s(this.GO);
        this.bZK.setConstrainLayoutPool(this.bXs);
        this.bZK.setConstrainImagePool(this.bXt);
        this.bZK.setForumName(this.mForumName);
        this.bZK.j(this.GO.getUniqueId());
        return new a(this.bZK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        aVar.bZN.j(bkVar);
        aVar.bZN.setOnSubCardOnClickListenner(this.bZL);
        com.baidu.tieba.frs.h.b.agV().a(chm, bkVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bZK != null) {
            this.bZK.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public s bZN;

        public a(s sVar) {
            super(sVar.getView());
            this.bZN = sVar;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
