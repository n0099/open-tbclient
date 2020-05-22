package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String aeX;
    public BdUniqueId epM;
    private aa gSU;
    private com.baidu.tieba.card.k hXo;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gSU = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.hXo != null && a.this.hXo.getView() != null && jVar != null && jVar.aOi() != null && !StringUtils.isNull(jVar.aOi().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.hXo.bKV() ? 1 : 2);
                    if (view == a.this.hXo.fGo.getCommentContainer() || view == a.this.hXo.gBE.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.ag("obj_locate", 7);
                        anVar.ag("obj_type", 5);
                        anVar.dh("tid", jVar.aOi().getTid());
                        anVar.dh("nid", jVar.aOi().getNid());
                        TiebaStatic.log(anVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> b(ViewGroup viewGroup) {
        this.hXo = new com.baidu.tieba.card.k(this.mPageContext, this.epM);
        this.hXo.gU(true);
        if (this.epM != null) {
            this.hXo.o(this.epM);
        }
        return new com.baidu.tieba.card.a.a<>(this.hXo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (jVar == null || aVar == null || aVar.bLU() == null) {
            return null;
        }
        jVar.sr(i + 1);
        com.baidu.tieba.card.s.bLq().e(jVar.Ds("c12351"));
        if (aVar.bLU() instanceof com.baidu.tieba.a.e) {
            aVar.bLU().setPage(this.aeX);
        }
        aVar.bLU().a(jVar);
        aVar.bLU().c(this.gSU);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }
}
