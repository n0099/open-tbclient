package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.alalivelist.view.b, a> {
    public BdUniqueId aPx;
    private com.baidu.tieba.homepage.alalivelist.view.c cUN;
    x<com.baidu.tieba.homepage.alalivelist.view.b> cUO;
    private TbPageContext<?> mG;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cUO = new x<com.baidu.tieba.homepage.alalivelist.view.b>() { // from class: com.baidu.tieba.homepage.alalivelist.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.alalivelist.view.b bVar) {
            }
        };
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cUN = new com.baidu.tieba.homepage.alalivelist.view.c(this.mG);
        this.cUN.h(this.aPx);
        return new a(this.cUN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.b bVar, a aVar) {
        aVar.cUQ.a(bVar);
        aVar.cUQ.b(this.cUO);
        int i2 = 0;
        if (bVar != null && bVar.bes != null) {
            i2 = bVar.bes.rN().live_type;
        }
        TiebaStatic.log(new ak("c11826").r("obj_type", i2));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.homepage.alalivelist.view.c cUQ;

        public a(com.baidu.tieba.homepage.alalivelist.view.c cVar) {
            super(cVar.getView());
            this.cUQ = cVar;
        }
    }
}
