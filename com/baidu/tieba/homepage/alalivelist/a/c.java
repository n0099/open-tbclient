package com.baidu.tieba.homepage.alalivelist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.alalivelist.view.b, a> {
    public BdUniqueId aOO;
    private com.baidu.tieba.homepage.alalivelist.view.c cRj;
    x<com.baidu.tieba.homepage.alalivelist.view.b> cRk;
    private TbPageContext<?> oW;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cRk = new x<com.baidu.tieba.homepage.alalivelist.view.b>() { // from class: com.baidu.tieba.homepage.alalivelist.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.alalivelist.view.b bVar) {
            }
        };
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cRj = new com.baidu.tieba.homepage.alalivelist.view.c(this.oW);
        this.cRj.i(this.oW.getUniqueId());
        return new a(this.cRj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.alalivelist.view.b bVar, a aVar) {
        aVar.cRm.a(bVar);
        aVar.cRm.b(this.cRk);
        int i2 = 0;
        if (bVar != null && bVar.bcN != null) {
            i2 = bVar.bcN.rY().live_type;
        }
        TiebaStatic.log(new aj("c11826").r("obj_type", i2));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.homepage.alalivelist.view.c cRm;

        public a(com.baidu.tieba.homepage.alalivelist.view.c cVar) {
            super(cVar.getView());
            this.cRm = cVar;
        }
    }
}
