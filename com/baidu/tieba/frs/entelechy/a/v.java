package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.frs.entelechy.view.r;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<be, a> implements com.baidu.tieba.frs.h.e {
    private TbPageContext<?> EA;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bJr;
    private com.baidu.adp.lib.f.b<TbImageView> bJs;
    private r bLk;
    private bx<be> bLl;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLl = new w(this);
        this.bJr = new com.baidu.adp.lib.f.b<>(new x(this), 6, 0);
        this.bJs = new com.baidu.adp.lib.f.b<>(new y(this), 12, 0);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public a a(ViewGroup viewGroup) {
        this.bLk = new r(this.EA);
        this.bLk.setConstrainLayoutPool(this.bJr);
        this.bLk.setConstrainImagePool(this.bJs);
        this.bLk.j(this.EA.getUniqueId());
        return new a(this.bLk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, be beVar, a aVar) {
        aVar.bLn.i(beVar);
        aVar.bLn.a(this.bLl);
        com.baidu.tieba.frs.h.b.aam().a(bSh, beVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bLk != null) {
            this.bLk.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public r bLn;

        public a(r rVar) {
            super(rVar.getView());
            this.bLn = rVar;
        }
    }
}
