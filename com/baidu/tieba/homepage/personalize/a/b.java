package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.bw;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, a> {
    private TbPageContext<?> EA;
    private BdUniqueId aTm;
    private com.baidu.tieba.card.p ctQ;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.b.cvc);
        this.EA = tbPageContext;
        this.ctQ = new com.baidu.tieba.card.p(this.EA);
        this.ctQ.i("c10715", "c10741", "c10713", "c10740");
        this.ctQ.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTm = bdUniqueId;
        if (this.ctQ != null) {
            this.ctQ.i(this.aTm);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, a aVar) {
        if (aVar.ctR == null) {
            return null;
        }
        aVar.ctR.a((com.baidu.tieba.card.a.j) bVar);
        bw.Lf().b(new ay("c10715").ab("obj_param3", at.KZ()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a a(ViewGroup viewGroup) {
        if (this.ctQ == null) {
            this.ctQ = new com.baidu.tieba.card.p(this.EA);
            this.ctQ.i(this.aTm);
            this.ctQ.i("c10715", "c10741", "c10713", "c10740");
        }
        return new a(this.ctQ);
    }

    public void onChangeSkinType(int i) {
        if (this.ctQ != null) {
            this.ctQ.d(this.EA, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.p ctR;

        public a(com.baidu.tieba.card.p pVar) {
            super(pVar.getView());
            this.ctR = pVar;
        }
    }
}
