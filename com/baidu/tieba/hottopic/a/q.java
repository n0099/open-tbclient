package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ar;
import com.baidu.tieba.card.bb;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.s, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private bb<com.baidu.tieba.card.a.s> bJA;
    private ar bJH;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJA = new r(this);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public a b(ViewGroup viewGroup) {
        this.bJH = new ar(this.Nw);
        this.bJH.j(this.aPF);
        return new a(this.bJH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.s sVar, a aVar) {
        aVar.bJJ.a(sVar);
        aVar.bJJ.a(this.bJA);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ar bJJ;

        public a(ar arVar) {
            super(arVar.getView());
            this.bJJ = arVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
    }
}
