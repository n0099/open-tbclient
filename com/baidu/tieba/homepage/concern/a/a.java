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
    private String aey;
    public BdUniqueId ebv;
    private z gEg;
    private com.baidu.tieba.card.j hIy;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gEg = new z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.hIy != null && a.this.hIy.getView() != null && jVar != null && jVar.aIw() != null && !StringUtils.isNull(jVar.aIw().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.hIy.bEC() ? 1 : 2);
                    if (view == a.this.hIy.fsr.getCommentContainer() || view == a.this.hIy.ftd.dJa.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.af("obj_locate", 7);
                        anVar.af("obj_type", 5);
                        anVar.cI("tid", jVar.aIw().getTid());
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
        this.hIy = new com.baidu.tieba.card.j(this.mPageContext, this.ebv);
        this.hIy.gC(true);
        if (this.ebv != null) {
            this.hIy.m(this.ebv);
        }
        return new com.baidu.tieba.card.a.a<>(this.hIy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        if (jVar == null || aVar == null || aVar.bFB() == null) {
            return null;
        }
        jVar.rN(i + 1);
        com.baidu.tieba.card.r.bEY().e(jVar.BG("c12351"));
        if (aVar.bFB() instanceof com.baidu.tieba.a.e) {
            aVar.bFB().setPage(this.aey);
        }
        aVar.bFB().a(jVar);
        aVar.bFB().c(this.gEg);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }
}
