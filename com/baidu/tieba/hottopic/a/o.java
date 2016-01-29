package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.an;
import com.baidu.tieba.card.bb;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.r, a> {
    private TbPageContext<?> Nw;
    private bb<com.baidu.tieba.card.a.r> bJA;
    private an bJE;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJA = new p(this);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: T */
    public a b(ViewGroup viewGroup) {
        this.bJE = new an(this.Nw);
        return new a(this.bJE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.r rVar, a aVar) {
        if (aVar == null || aVar.bJG == null) {
            return null;
        }
        aVar.bJG.a(rVar);
        aVar.bJG.a(this.bJA);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public an bJG;

        public a(an anVar) {
            super(anVar.getView());
            this.bJG = anVar;
        }
    }
}
