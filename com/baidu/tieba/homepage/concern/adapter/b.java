package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes21.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> implements com.baidu.tieba.a.f {
    private String ahw;
    public BdUniqueId fsa;
    private com.baidu.tieba.card.ab inF;
    private com.baidu.tieba.card.l jwM;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.inF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && b.this.jwM != null && b.this.jwM.getView() != null && jVar != null && jVar.bjd() != null && !StringUtils.isNull(jVar.bjd().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == b.this.jwM.cny() ? 1 : 2);
                    if (view == b.this.jwM.gSy.getCommentContainer() || view == b.this.jwM.hVY.getCommentContainer()) {
                        ar arVar = new ar("c12942");
                        arVar.ak("obj_locate", 7);
                        arVar.ak("obj_type", 5);
                        arVar.dR("tid", jVar.bjd().getTid());
                        arVar.dR("nid", jVar.bjd().getNid());
                        TiebaStatic.log(arVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> c(ViewGroup viewGroup) {
        this.jwM = new com.baidu.tieba.card.l(this.mPageContext, this.fsa);
        this.jwM.iU(true);
        if (this.fsa != null) {
            this.jwM.o(this.fsa);
        }
        return new com.baidu.tieba.card.a.a<>(this.jwM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (jVar == null || aVar == null || aVar.coz() == null) {
            return null;
        }
        jVar.xH(i + 1);
        com.baidu.tieba.card.t.cnT().e(jVar.IG("c12351"));
        if (aVar.coz() instanceof com.baidu.tieba.a.e) {
            aVar.coz().setPage(this.ahw);
        }
        aVar.coz().a(jVar);
        aVar.coz().c(this.inF);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }
}
