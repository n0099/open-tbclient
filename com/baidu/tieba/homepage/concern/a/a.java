package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String agJ;
    public BdUniqueId ePz;
    private aa hyv;
    private com.baidu.tieba.card.k iGZ;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hyv = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && a.this.iGZ != null && a.this.iGZ.getView() != null && kVar != null && kVar.bce() != null && !StringUtils.isNull(kVar.bce().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, kVar, view == a.this.iGZ.cbD() ? 1 : 2);
                    if (view == a.this.iGZ.gje.getCommentContainer() || view == a.this.iGZ.hhh.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.ai("obj_locate", 7);
                        aqVar.ai("obj_type", 5);
                        aqVar.dD("tid", kVar.bce().getTid());
                        aqVar.dD("nid", kVar.bce().getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> b(ViewGroup viewGroup) {
        this.iGZ = new com.baidu.tieba.card.k(this.mPageContext, this.ePz);
        this.iGZ.ie(true);
        if (this.ePz != null) {
            this.iGZ.p(this.ePz);
        }
        return new com.baidu.tieba.card.a.a<>(this.iGZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (kVar == null || aVar == null || aVar.ccF() == null) {
            return null;
        }
        kVar.vy(i + 1);
        com.baidu.tieba.card.s.cbY().e(kVar.He("c12351"));
        if (aVar.ccF() instanceof com.baidu.tieba.a.e) {
            aVar.ccF().setPage(this.agJ);
        }
        aVar.ccF().a(kVar);
        aVar.ccF().c(this.hyv);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dk(String str) {
        this.agJ = str;
    }
}
