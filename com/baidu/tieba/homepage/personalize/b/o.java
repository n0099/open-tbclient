package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m>> {
    private TbPageContext<?> GO;
    public BdUniqueId bbl;
    private com.baidu.tieba.card.m cra;
    private cb<com.baidu.tieba.card.data.j> crb;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.j.TYPE);
        this.crb = new p(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        this.cra = new com.baidu.tieba.card.m(this.GO, this.bbl);
        return new com.baidu.tieba.card.a.a(this.cra);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m> aVar) {
        this.cra = aVar.Po();
        aVar.Po().a(jVar);
        aVar.Po().setOnSubCardOnClickListenner(this.crb);
        aVar.Po().onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        bz.OH().a(new at("c11006"));
        return aVar.getView();
    }

    public void jA(int i) {
        if (this.cra != null) {
            this.cra.onChangeSkinType(this.GO, i);
        }
    }
}
