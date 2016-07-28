package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.k, a> {
    private TbPageContext<?> EA;
    public BdUniqueId aTm;
    private com.baidu.tieba.card.u cuk;
    private bx<com.baidu.tieba.card.a.k> cul;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.k.OB);
        this.cul = new q(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a a(ViewGroup viewGroup) {
        this.cuk = new com.baidu.tieba.card.u(this.EA, this.aTm);
        return new a(this.cuk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.k kVar, a aVar) {
        this.cuk = aVar.cun;
        aVar.cun.d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        aVar.cun.a(kVar);
        aVar.cun.a(this.cul);
        bw.Lf().b(new ay("c11006"));
        return aVar.getView();
    }

    public void jz(int i) {
        if (this.cuk != null) {
            this.cuk.d(this.EA, i);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.u cun;

        public a(com.baidu.tieba.card.u uVar) {
            super(uVar.getView());
            this.cun = uVar;
        }
    }
}
