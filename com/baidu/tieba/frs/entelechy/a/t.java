package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.frs.entelechy.view.q;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.a<az, a> {
    private TbPageContext<?> Ea;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bHW;
    private com.baidu.adp.lib.f.b<TbImageView> bHX;
    private q bJG;
    private bx bJH;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJH = new u(this);
        this.bHW = new com.baidu.adp.lib.f.b<>(new v(this), 6, 0);
        this.bHX = new com.baidu.adp.lib.f.b<>(new w(this), 12, 0);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public a a(ViewGroup viewGroup) {
        this.bJG = new q(this.Ea);
        this.bJG.setConstrainLayoutPool(this.bHW);
        this.bJG.setConstrainImagePool(this.bHX);
        this.bJG.j(this.Ea.getUniqueId());
        return new a(this.bJG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, az azVar, a aVar) {
        aVar.bJJ.h(azVar);
        aVar.bJJ.a(this.bJH);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bJG != null) {
            this.bJG.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public q bJJ;

        public a(q qVar) {
            super(qVar.getView());
            this.bJJ = qVar;
        }
    }
}
