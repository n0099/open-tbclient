package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, a> implements com.baidu.tieba.a.f {
    private String Gc;
    public BdUniqueId cJo;
    private ab fcR;
    private com.baidu.tieba.homepage.concern.view.b geb;
    private TbPageContext<?> mPageContext;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fcR = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && n.this.geb != null && n.this.geb.getView() != null && lVar != null && lVar.agG() != null && !StringUtils.isNull(lVar.agG().getTid())) {
                    an anVar = new an("c12352");
                    if ((n.this.geb.getHeaderImg() != null && view.getId() == n.this.geb.getHeaderImg().getId()) || (n.this.geb.baa() != null && view.getId() == n.this.geb.baa().getId())) {
                        anVar.O("obj_locate", 1);
                    } else {
                        anVar.O("obj_locate", 2);
                    }
                    anVar.O("obj_type", 2);
                    anVar.bS("tid", lVar.caz.getTid());
                    anVar.p("fid", lVar.caz.getFid());
                    anVar.bS("obj_source", "1");
                    anVar.O("obj_param1", lVar.baJ() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public a b(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.b bVar = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        if (this.cJo != null) {
            bVar.l(this.cJo);
        }
        if (!ab(1)) {
            bVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.concern.a.n.2
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    n.this.g(i, i2, i3);
                    if (n.this.ab(1)) {
                        bVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.geb = bVar;
        return new a(this.geb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.gee == null) {
            return null;
        }
        lVar.oO(i + 1);
        t.bau().c(lVar.uF("c12351"));
        if (aVar.gee instanceof com.baidu.tieba.a.e) {
            aVar.gee.setPage(this.Gc);
        }
        aVar.gee.a(lVar);
        aVar.gee.d(this.fcR);
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.homepage.concern.view.b gee;

        public a(com.baidu.tieba.homepage.concern.view.b bVar) {
            super(bVar.getView());
            this.gee = bVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }
}
