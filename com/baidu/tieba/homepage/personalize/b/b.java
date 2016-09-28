package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.an;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.c, a> {
    private TbPageContext<?> GM;
    private BdUniqueId aYW;
    private com.baidu.tieba.card.h cGl;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.f.cHy);
        this.GM = tbPageContext;
        this.cGl = new com.baidu.tieba.card.h(this.GM);
        this.cGl.j("c10714", "c10739", "c10712", "c10738");
        this.cGl.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aYW = bdUniqueId;
        if (this.cGl != null) {
            this.cGl.i(this.aYW);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.c cVar, a aVar) {
        if (aVar.cGj == null) {
            return null;
        }
        aVar.cGj.a((com.baidu.tieba.card.data.j) cVar);
        cb.Oj().a(new ax("c10714").ab("obj_param3", an.Oc()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public a a(ViewGroup viewGroup) {
        if (this.cGl == null) {
            this.cGl = new com.baidu.tieba.card.h(this.GM);
            this.cGl.i(this.aYW);
            this.cGl.j("c10714", "c10739", "c10712", "c10738");
        }
        return new a(this.cGl);
    }

    public void onChangeSkinType(int i) {
        if (this.cGl != null) {
            this.cGl.onChangeSkinType(this.GM, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.h cGj;

        public a(com.baidu.tieba.card.h hVar) {
            super(hVar.getView());
            this.cGj = hVar;
        }
    }
}
