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
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, C0065a> {
    private TbPageContext<?> GM;
    private BdUniqueId aYW;
    private com.baidu.tieba.card.h cGi;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.b.cHw);
        this.GM = tbPageContext;
        this.cGi = new com.baidu.tieba.card.h(this.GM);
        this.cGi.j("c10715", "c10741", "c10713", "c10740");
        this.cGi.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aYW = bdUniqueId;
        if (this.cGi != null) {
            this.cGi.i(this.aYW);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, C0065a c0065a) {
        if (c0065a.cGj == null) {
            return null;
        }
        c0065a.cGj.a((com.baidu.tieba.card.data.j) bVar);
        cb.Oj().a(new ax("c10715").ab("obj_param3", an.Oc()));
        return c0065a.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public C0065a a(ViewGroup viewGroup) {
        if (this.cGi == null) {
            this.cGi = new com.baidu.tieba.card.h(this.GM);
            this.cGi.i(this.aYW);
            this.cGi.j("c10715", "c10741", "c10713", "c10740");
        }
        return new C0065a(this.cGi);
    }

    public void onChangeSkinType(int i) {
        if (this.cGi != null) {
            this.cGi.onChangeSkinType(this.GM, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.homepage.personalize.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065a extends y.a {
        public com.baidu.tieba.card.h cGj;

        public C0065a(com.baidu.tieba.card.h hVar) {
            super(hVar.getView());
            this.cGj = hVar;
        }
    }
}
