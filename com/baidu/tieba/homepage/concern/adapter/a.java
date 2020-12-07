package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String aiw;
    public BdUniqueId fzO;
    private com.baidu.tieba.card.ab iyx;
    private com.baidu.tieba.card.k jKm;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iyx = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.jKm != null && a.this.jKm.getView() != null && jVar != null && jVar.bmn() != null && !StringUtils.isNull(jVar.bmn().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == a.this.jKm.crL() ? 1 : 2);
                    if (view == a.this.jKm.hbL.getCommentContainer() || view == a.this.jKm.igV.getCommentContainer()) {
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> c(ViewGroup viewGroup) {
        this.jKm = new com.baidu.tieba.card.k(this.mPageContext, this.fzO);
        this.jKm.jj(true);
        if (this.fzO != null) {
            this.jKm.o(this.fzO);
        }
        return new com.baidu.tieba.card.a.a<>(this.jKm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
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
        if (jVar.bmn() != null && jVar.bmn().bpj() != null) {
            ar arVar = new ar("c14007");
            arVar.al("obj_locate", 2);
            arVar.w("obj_param1", jVar.bmn().bpj().live_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
