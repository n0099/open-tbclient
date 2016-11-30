package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.an;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.c, a> {
    private TbPageContext<?> GO;
    private BdUniqueId bcf;
    private com.baidu.tieba.card.h cLw;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.f.cML);
        this.GO = tbPageContext;
        this.cLw = new com.baidu.tieba.card.h(this.GO);
        this.cLw.j("c10714", "c10739", "c10712", "c10738");
        this.cLw.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bcf = bdUniqueId;
        if (this.cLw != null) {
            this.cLw.i(this.bcf);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.c cVar, a aVar) {
        if (aVar.cLu == null) {
            return null;
        }
        aVar.cLu.a((com.baidu.tieba.card.data.j) cVar);
        bx.Pl().a(new av("c10714").ab("obj_param3", an.Pe()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a a(ViewGroup viewGroup) {
        if (this.cLw == null) {
            this.cLw = new com.baidu.tieba.card.h(this.GO);
            this.cLw.i(this.bcf);
            this.cLw.j("c10714", "c10739", "c10712", "c10738");
        }
        return new a(this.cLw);
    }

    public void onChangeSkinType(int i) {
        if (this.cLw != null) {
            this.cLw.onChangeSkinType(this.GO, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.h cLu;

        public a(com.baidu.tieba.card.h hVar) {
            super(hVar.getView());
            this.cLu = hVar;
        }
    }
}
