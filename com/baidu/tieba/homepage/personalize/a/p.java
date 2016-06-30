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
    private TbPageContext<?> Ea;
    public BdUniqueId aSq;
    private com.baidu.tieba.card.u crA;
    private bx<com.baidu.tieba.card.a.k> crB;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.k.Op);
        this.crB = new q(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a a(ViewGroup viewGroup) {
        this.crA = new com.baidu.tieba.card.u(this.Ea, this.aSq);
        return new a(this.crA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.k kVar, a aVar) {
        this.crA = aVar.crD;
        aVar.crD.d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.crD.a(kVar);
        aVar.crD.a(this.crB);
        bw.Lg().a(new ay("c11006"));
        return aVar.getView();
    }

    public void jt(int i) {
        if (this.crA != null) {
            this.crA.d(this.Ea, i);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.u crD;

        public a(com.baidu.tieba.card.u uVar) {
            super(uVar.getView());
            this.crD = uVar;
        }
    }
}
