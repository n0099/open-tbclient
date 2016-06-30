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
    private TbPageContext<?> Ea;
    private BdUniqueId aSq;
    private com.baidu.tieba.card.p crj;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.f.csu);
        this.Ea = tbPageContext;
        this.crj = new com.baidu.tieba.card.p(this.Ea);
        this.crj.i("c10714", "c10739", "c10712", "c10738");
        this.crj.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSq = bdUniqueId;
        if (this.crj != null) {
            this.crj.i(this.aSq);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.c cVar, a aVar) {
        if (aVar.crh == null) {
            return null;
        }
        aVar.crh.a((com.baidu.tieba.card.a.j) cVar);
        bw.Lg().a(new ay("c10714").ab("obj_param3", at.La()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public a a(ViewGroup viewGroup) {
        if (this.crj == null) {
            this.crj = new com.baidu.tieba.card.p(this.Ea);
            this.crj.i(this.aSq);
            this.crj.i("c10714", "c10739", "c10712", "c10738");
        }
        return new a(this.crj);
    }

    public void onChangeSkinType(int i) {
        if (this.crj != null) {
            this.crj.d(this.Ea, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.p crh;

        public a(com.baidu.tieba.card.p pVar) {
            super(pVar.getView());
            this.crh = pVar;
        }
    }
}
