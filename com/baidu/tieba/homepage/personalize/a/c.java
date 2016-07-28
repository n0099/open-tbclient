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
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.c, a> {
    private TbPageContext<?> EA;
    private BdUniqueId aTm;
    private com.baidu.tieba.card.p ctT;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.f.cve);
        this.EA = tbPageContext;
        this.ctT = new com.baidu.tieba.card.p(this.EA);
        this.ctT.i("c10714", "c10739", "c10712", "c10738");
        this.ctT.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTm = bdUniqueId;
        if (this.ctT != null) {
            this.ctT.i(this.aTm);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.c cVar, a aVar) {
        if (aVar.ctR == null) {
            return null;
        }
        aVar.ctR.a((com.baidu.tieba.card.a.j) cVar);
        bw.Lf().b(new ay("c10714").ab("obj_param3", at.KZ()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public a a(ViewGroup viewGroup) {
        if (this.ctT == null) {
            this.ctT = new com.baidu.tieba.card.p(this.EA);
            this.ctT.i(this.aTm);
            this.ctT.i("c10714", "c10739", "c10712", "c10738");
        }
        return new a(this.ctT);
    }

    public void onChangeSkinType(int i) {
        if (this.ctT != null) {
            this.ctT.d(this.EA, i);
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
