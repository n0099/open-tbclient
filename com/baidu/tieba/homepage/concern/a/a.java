package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String afx;
    public BdUniqueId eEU;
    private aa hly;
    private com.baidu.tieba.card.k isE;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hly = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.isE != null && a.this.isE.getView() != null && jVar != null && jVar.aTN() != null && !StringUtils.isNull(jVar.aTN().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.isE.bRq() ? 1 : 2);
                    if (view == a.this.isE.fXb.getCommentContainer() || view == a.this.isE.gUl.getCommentContainer()) {
                        ap apVar = new ap("c12942");
                        apVar.ah("obj_locate", 7);
                        apVar.ah("obj_type", 5);
                        apVar.dn("tid", jVar.aTN().getTid());
                        apVar.dn("nid", jVar.aTN().getNid());
                        TiebaStatic.log(apVar);
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> b(ViewGroup viewGroup) {
        this.isE = new com.baidu.tieba.card.k(this.mPageContext, this.eEU);
        this.isE.hH(true);
        if (this.eEU != null) {
            this.isE.p(this.eEU);
        }
        return new com.baidu.tieba.card.a.a<>(this.isE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (jVar == null || aVar == null || aVar.bSs() == null) {
            return null;
        }
        jVar.tj(i + 1);
        com.baidu.tieba.card.s.bRL().e(jVar.EE("c12351"));
        if (aVar.bSs() instanceof com.baidu.tieba.a.e) {
            aVar.bSs().setPage(this.afx);
        }
        aVar.bSs().a(jVar);
        aVar.bSs().c(this.hly);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }
}
