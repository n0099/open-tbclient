package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> implements com.baidu.tieba.a.f {
    private String aiw;
    public BdUniqueId fzO;
    private com.baidu.tieba.card.ab iyx;
    private com.baidu.tieba.card.l jKo;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iyx = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && b.this.jKo != null && b.this.jKo.getView() != null && jVar != null && jVar.bmn() != null && !StringUtils.isNull(jVar.bmn().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == b.this.jKo.crL() ? 1 : 2);
                    if (view == b.this.jKo.hbL.getCommentContainer() || view == b.this.jKo.igV.getCommentContainer()) {
                        ar arVar = new ar("c12942");
                        arVar.al("obj_locate", 7);
                        arVar.al("obj_type", 5);
                        arVar.dY("tid", jVar.bmn().getTid());
                        arVar.dY("nid", jVar.bmn().getNid());
                        com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(view);
                        if (bM != null) {
                            arVar.dY("obj_cur_page", bM.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                            arVar.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                        }
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
        this.jKo = new com.baidu.tieba.card.l(this.mPageContext, this.fzO);
        this.jKo.jj(true);
        if (this.fzO != null) {
            this.jKo.o(this.fzO);
        }
        return new com.baidu.tieba.card.a.a<>(this.jKo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (jVar == null || aVar == null || aVar.csM() == null) {
            return null;
        }
        jVar.ym(i + 1);
        com.baidu.tieba.card.t.csg().e(jVar.Jw("c12351"));
        if (aVar.csM() instanceof com.baidu.tieba.a.e) {
            aVar.csM().setPage(this.aiw);
        }
        aVar.csM().a(jVar);
        aVar.csM().c(this.iyx);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
