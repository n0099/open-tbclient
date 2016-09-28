package com.baidu.tieba.homepage.personalize.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<e, a> {
    private final TbPageContext<?> GM;
    private cd<e> bVT;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new d(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a a(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.personalize.d.a aVar = new com.baidu.tieba.homepage.personalize.d.a(this.GM);
        aVar.setOnSubCardOnClickListenner(this.bVT);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        cb.Oj().a(new ax("c11272"));
        aVar.cIb.onBindDataToView(eVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.personalize.d.a cIb;

        public a(com.baidu.tieba.homepage.personalize.d.a aVar) {
            super(aVar.getView());
            this.cIb = aVar;
        }
    }
}
