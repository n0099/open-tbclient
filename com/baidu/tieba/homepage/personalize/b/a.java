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
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, C0064a> {
    private TbPageContext<?> GO;
    private BdUniqueId bcf;
    private com.baidu.tieba.card.h cLt;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.b.cMJ);
        this.GO = tbPageContext;
        this.cLt = new com.baidu.tieba.card.h(this.GO);
        this.cLt.j("c10715", "c10741", "c10713", "c10740");
        this.cLt.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bcf = bdUniqueId;
        if (this.cLt != null) {
            this.cLt.i(this.bcf);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, C0064a c0064a) {
        if (c0064a.cLu == null) {
            return null;
        }
        c0064a.cLu.a((com.baidu.tieba.card.data.j) bVar);
        bx.Pl().a(new av("c10715").ab("obj_param3", an.Pe()));
        return c0064a.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public C0064a a(ViewGroup viewGroup) {
        if (this.cLt == null) {
            this.cLt = new com.baidu.tieba.card.h(this.GO);
            this.cLt.i(this.bcf);
            this.cLt.j("c10715", "c10741", "c10713", "c10740");
        }
        return new C0064a(this.cLt);
    }

    public void onChangeSkinType(int i) {
        if (this.cLt != null) {
            this.cLt.onChangeSkinType(this.GO, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.homepage.personalize.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064a extends y.a {
        public com.baidu.tieba.card.h cLu;

        public C0064a(com.baidu.tieba.card.h hVar) {
            super(hVar.getView());
            this.cLu = hVar;
        }
    }
}
