package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<bg, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c>> {
    private ab<bg> dAU;
    private com.baidu.tieba.homepage.daily.view.c fYJ;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dAU = new ab<bg>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                int i = 2;
                if (view != null && bgVar != null && f.this.fYJ != null && f.this.fYJ.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.P("obj_type", 2);
                    amVar.bT("tid", bgVar.getTid());
                    amVar.l("fid", bgVar.getFid());
                    if (view.getId() != f.this.fYJ.btg() && view.getId() != f.this.fYJ.bth()) {
                        if (view.getId() == f.this.fYJ.bti()) {
                            i = 3;
                        }
                    } else {
                        i = 1;
                    }
                    amVar.P("obj_locate", i);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.fYJ = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.fYJ.setTag(this.mPageId);
        this.fYJ.setShareReportFrom(7);
        this.fYJ.tn(11);
        this.fYJ.setStType(n.adi());
        this.fYJ.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.fYJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bgVar == null || aVar == null || aVar.aYp() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.P("obj_type", 2);
        amVar.bT("tid", bgVar.getTid());
        amVar.l("fid", bgVar.getFid());
        t.aXM().b(amVar);
        aVar.aYp().d(this.dAU);
        aVar.aYp().a(bgVar);
        return aVar.getView();
    }
}
