package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.af;
import com.baidu.tieba.card.bb;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.q, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private bb<com.baidu.tieba.card.a.q> bJA;
    private af bJz;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJA = new m(this);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public a b(ViewGroup viewGroup) {
        this.bJz = new af(this.Nw);
        this.bJz.j(this.aPF);
        return new a(this.bJz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.q qVar, a aVar) {
        aVar.bJC.a(qVar);
        aVar.bJC.a(this.bJA);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bJz != null) {
            this.bJz.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public af bJC;

        public a(af afVar) {
            super(afVar.getView());
            this.bJC = afVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
    }
}
