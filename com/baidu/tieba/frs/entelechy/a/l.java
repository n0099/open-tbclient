package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.by;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<ax, a> {
    private TbPageContext<?> DV;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> boU;
    private com.baidu.adp.lib.f.b<TbImageView> boV;
    private com.baidu.tieba.frs.entelechy.c.s boY;
    private by boZ;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boZ = new m(this);
        this.boU = new com.baidu.adp.lib.f.b<>(new n(this), 6, 0);
        this.boV = new com.baidu.adp.lib.f.b<>(new o(this), 12, 0);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public a b(ViewGroup viewGroup) {
        this.boY = new com.baidu.tieba.frs.entelechy.c.s(this.DV);
        this.boY.setConstrainLayoutPool(this.boU);
        this.boY.setConstrainImagePool(this.boV);
        this.boY.j(this.DV.getUniqueId());
        return new a(this.boY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ax axVar, a aVar) {
        aVar.bpb.h(axVar);
        aVar.bpb.a(this.boZ);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.boY != null) {
            this.boY.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.c.s bpb;

        public a(com.baidu.tieba.frs.entelechy.c.s sVar) {
            super(sVar.getView());
            this.bpb = sVar;
        }
    }
}
