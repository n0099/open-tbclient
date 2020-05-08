package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> implements com.baidu.tieba.a.f {
    private String aeB;
    public BdUniqueId ebA;
    private z gEm;
    private com.baidu.tieba.card.j hIE;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gEm = new z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.hIE != null && a.this.hIE.getView() != null && jVar != null && jVar.aIu() != null && !StringUtils.isNull(jVar.aIu().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.hIE.bEA() ? 1 : 2);
                    if (view == a.this.hIE.fsw.getCommentContainer() || view == a.this.hIE.fti.dJe.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.af("obj_locate", 7);
                        anVar.af("obj_type", 5);
                        anVar.cI("tid", jVar.aIu().getTid());
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
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> b(ViewGroup viewGroup) {
        this.hIE = new com.baidu.tieba.card.j(this.mPageContext, this.ebA);
        this.hIE.gC(true);
        if (this.ebA != null) {
            this.hIE.m(this.ebA);
        }
        return new com.baidu.tieba.card.a.a<>(this.hIE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        if (jVar == null || aVar == null || aVar.bFz() == null) {
            return null;
        }
        jVar.rN(i + 1);
        com.baidu.tieba.card.r.bEW().e(jVar.BJ("c12351"));
        if (aVar.bFz() instanceof com.baidu.tieba.a.e) {
            aVar.bFz().setPage(this.aeB);
        }
        aVar.bFz().a(jVar);
        aVar.bFz().c(this.gEm);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }
}
