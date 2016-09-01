package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.c, a> {
    private TbPageContext<?> GM;
    private BdUniqueId aYu;
    private com.baidu.tieba.card.j cFx;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.f.cGJ);
        this.GM = tbPageContext;
        this.cFx = new com.baidu.tieba.card.j(this.GM);
        this.cFx.j("c10714", "c10739", "c10712", "c10738");
        this.cFx.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aYu = bdUniqueId;
        if (this.cFx != null) {
            this.cFx.i(this.aYu);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.c cVar, a aVar) {
        if (aVar.cFv == null) {
            return null;
        }
        aVar.cFv.a((com.baidu.tieba.card.data.j) cVar);
        cd.NI().b(new ay("c10714").ab("obj_param3", ap.NC()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public a a(ViewGroup viewGroup) {
        if (this.cFx == null) {
            this.cFx = new com.baidu.tieba.card.j(this.GM);
            this.cFx.i(this.aYu);
            this.cFx.j("c10714", "c10739", "c10712", "c10738");
        }
        return new a(this.cFx);
    }

    public void onChangeSkinType(int i) {
        if (this.cFx != null) {
            this.cFx.onChangeSkinType(this.GM, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.j cFv;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.cFv = jVar;
        }
    }
}
