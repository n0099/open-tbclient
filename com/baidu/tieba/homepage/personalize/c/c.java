package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<e, a> {
    private final TbPageContext<?> ajh;
    private ci<e> bdp;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bdp = new d(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.personalize.c.a aVar = new com.baidu.tieba.homepage.personalize.c.a(this.ajh);
        aVar.a(this.bdp);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        cf.Uw().a(new as("c11272"));
        aVar.cDf.a(eVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends z.a {
        public com.baidu.tieba.homepage.personalize.c.a cDf;

        public a(com.baidu.tieba.homepage.personalize.c.a aVar) {
            super(aVar.getView());
            this.cDf = aVar;
        }
    }
}
