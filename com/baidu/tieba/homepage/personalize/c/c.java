package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<e, a> {
    private final TbPageContext<?> ajT;
    private cf<e> bSf;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSf = new d(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.personalize.c.a aVar = new com.baidu.tieba.homepage.personalize.c.a(this.ajT);
        aVar.setOnSubCardOnClickListenner(this.bSf);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        cc.ST().a(new as("c11272"));
        aVar.czw.onBindDataToView(eVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.personalize.c.a czw;

        public a(com.baidu.tieba.homepage.personalize.c.a aVar) {
            super(aVar.getView());
            this.czw = aVar;
        }
    }
}
