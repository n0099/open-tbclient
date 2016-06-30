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
    private TbPageContext<?> Ea;
    private BdUniqueId aSq;
    private com.baidu.tieba.card.p crg;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.b.css);
        this.Ea = tbPageContext;
        this.crg = new com.baidu.tieba.card.p(this.Ea);
        this.crg.i("c10715", "c10741", "c10713", "c10740");
        this.crg.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSq = bdUniqueId;
        if (this.crg != null) {
            this.crg.i(this.aSq);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, a aVar) {
        if (aVar.crh == null) {
            return null;
        }
        aVar.crh.a((com.baidu.tieba.card.a.j) bVar);
        bw.Lg().a(new ay("c10715").ab("obj_param3", at.La()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a a(ViewGroup viewGroup) {
        if (this.crg == null) {
            this.crg = new com.baidu.tieba.card.p(this.Ea);
            this.crg.i(this.aSq);
            this.crg.i("c10715", "c10741", "c10713", "c10740");
        }
        return new a(this.crg);
    }

    public void onChangeSkinType(int i) {
        if (this.crg != null) {
            this.crg.d(this.Ea, i);
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
