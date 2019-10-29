package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> implements com.baidu.tieba.a.f {
    private String GC;
    public BdUniqueId cKf;
    private ab fdI;
    private com.baidu.tieba.card.l gey;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fdI = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gey != null && a.this.gey.getView() != null && jVar != null && jVar.agI() != null && !StringUtils.isNull(jVar.agI().getTid())) {
                    boolean z = view == a.this.gey.bab();
                    an anVar = new an("c12352");
                    anVar.O("obj_locate", z ? 1 : 2);
                    anVar.bS("obj_type", jVar.baI());
                    anVar.bS("tid", jVar.cbq.getTid());
                    anVar.p("fid", jVar.cbq.getFid());
                    anVar.bS("obj_source", "1");
                    TiebaStatic.log(anVar);
                    if (view == a.this.gey.dUe.getCommentContainer() || view == a.this.gey.dUf.crO.getCommentContainer()) {
                        an anVar2 = new an("c12942");
                        anVar2.O("obj_locate", 7);
                        anVar2.O("obj_type", 5);
                        anVar2.bS("tid", jVar.agI().getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> b(ViewGroup viewGroup) {
        this.gey = new com.baidu.tieba.card.l(this.mPageContext);
        this.gey.ef(true);
        if (this.cKf != null) {
            this.gey.l(this.cKf);
        }
        return new com.baidu.tieba.card.a.a<>(this.gey);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (jVar == null || aVar == null || aVar.baZ() == null) {
            return null;
        }
        jVar.oP(i + 1);
        t.baw().c(jVar.uE("c12351"));
        if (aVar.baZ() instanceof com.baidu.tieba.a.e) {
            aVar.baZ().setPage(this.GC);
        }
        aVar.baZ().a(jVar);
        aVar.baZ().d(this.fdI);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }
}
