package com.baidu.tieba.homepage.personalize.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<e, a> {
    private final TbPageContext<?> GO;
    private cb<e> bES;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bES = new d(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a a(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.personalize.d.a aVar = new com.baidu.tieba.homepage.personalize.d.a(this.GO);
        aVar.setOnSubCardOnClickListenner(this.bES);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        bz.OH().a(new at("c11272"));
        aVar.csv.onBindDataToView(eVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.personalize.d.a csv;

        public a(com.baidu.tieba.homepage.personalize.d.a aVar) {
            super(aVar.getView());
            this.csv = aVar;
        }
    }
}
