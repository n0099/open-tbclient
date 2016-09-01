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
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, C0062a> {
    private TbPageContext<?> GM;
    private BdUniqueId aYu;
    private com.baidu.tieba.card.j cFu;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.b.cGH);
        this.GM = tbPageContext;
        this.cFu = new com.baidu.tieba.card.j(this.GM);
        this.cFu.j("c10715", "c10741", "c10713", "c10740");
        this.cFu.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aYu = bdUniqueId;
        if (this.cFu != null) {
            this.cFu.i(this.aYu);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, C0062a c0062a) {
        if (c0062a.cFv == null) {
            return null;
        }
        c0062a.cFv.a((com.baidu.tieba.card.data.j) bVar);
        cd.NI().b(new ay("c10715").ab("obj_param3", ap.NC()));
        return c0062a.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public C0062a a(ViewGroup viewGroup) {
        if (this.cFu == null) {
            this.cFu = new com.baidu.tieba.card.j(this.GM);
            this.cFu.i(this.aYu);
            this.cFu.j("c10715", "c10741", "c10713", "c10740");
        }
        return new C0062a(this.cFu);
    }

    public void onChangeSkinType(int i) {
        if (this.cFu != null) {
            this.cFu.onChangeSkinType(this.GM, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0062a extends y.a {
        public com.baidu.tieba.card.j cFv;

        public C0062a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.cFv = jVar;
        }
    }
}
