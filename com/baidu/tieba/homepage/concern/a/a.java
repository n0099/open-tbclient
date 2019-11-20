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
    private String Gc;
    public BdUniqueId cJo;
    private ab fcR;
    private com.baidu.tieba.card.l gdG;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fcR = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gdG != null && a.this.gdG.getView() != null && jVar != null && jVar.agG() != null && !StringUtils.isNull(jVar.agG().getTid())) {
                    boolean z = view == a.this.gdG.aZZ();
                    an anVar = new an("c12352");
                    anVar.O("obj_locate", z ? 1 : 2);
                    anVar.bS("obj_type", jVar.baG());
                    anVar.bS("tid", jVar.caz.getTid());
                    anVar.p("fid", jVar.caz.getFid());
                    anVar.bS("obj_source", "1");
                    TiebaStatic.log(anVar);
                    if (view == a.this.gdG.dTn.getCommentContainer() || view == a.this.gdG.dTo.cqW.getCommentContainer()) {
                        an anVar2 = new an("c12942");
                        anVar2.O("obj_locate", 7);
                        anVar2.O("obj_type", 5);
                        anVar2.bS("tid", jVar.agG().getTid());
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
        this.gdG = new com.baidu.tieba.card.l(this.mPageContext);
        this.gdG.ef(true);
        if (this.cJo != null) {
            this.gdG.l(this.cJo);
        }
        return new com.baidu.tieba.card.a.a<>(this.gdG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (jVar == null || aVar == null || aVar.baX() == null) {
            return null;
        }
        jVar.oO(i + 1);
        t.bau().c(jVar.uE("c12351"));
        if (aVar.baX() instanceof com.baidu.tieba.a.e) {
            aVar.baX().setPage(this.Gc);
        }
        aVar.baX().a(jVar);
        aVar.baX().d(this.fcR);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }
}
