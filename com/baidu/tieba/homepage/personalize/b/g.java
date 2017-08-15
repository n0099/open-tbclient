package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<r>> {
    public BdUniqueId aON;
    private h.a amd;
    private x cSl;
    private r cVN;
    private TbPageContext<?> oV;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amd = null;
        this.cSl = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.WX().cA(true);
                if (view != null && g.this.cVN != null && g.this.cVN.getView() != null && lVar != null && lVar.MF() != null && !StringUtils.isNull(lVar.MF().getTid())) {
                    if (view.getId() != g.this.cVN.getView().getId()) {
                        if (g.this.cVN.getHeaderImg() == null || view.getId() != g.this.cVN.getHeaderImg().getId()) {
                            if (g.this.cVN.WD() == null || view.getId() != g.this.cVN.WD().getId()) {
                                if (g.this.cVN.bld == null || g.this.cVN.bld.getBarNameTv() == null || view.getId() != g.this.cVN.bld.getBarNameTv().getId()) {
                                    if (g.this.cVN.WC() != null && view.getId() == g.this.cVN.WC().getId()) {
                                        TiebaStatic.log(lVar.jo("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.Xm());
                                return;
                            }
                            TiebaStatic.log(lVar.jn("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jn("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jn("c12192"));
                }
            }
        };
        this.oV = tbPageContext;
        apo();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.cVN = new r(this.oV);
        this.cVN.j(this.aON);
        return new com.baidu.tieba.card.a.a<>(this.cVN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.Xy() == null) {
            return null;
        }
        lVar.hw(i + 1);
        u.WX().a(lVar.jm("c12190"));
        aVar.Xy().a(lVar);
        aVar.Xy().b(this.cSl);
        aVar.Xy().a(this.amd);
        return aVar.getView();
    }

    private void apo() {
        com.baidu.tieba.card.data.l.bKe = "c10705";
        com.baidu.tieba.card.data.l.bKf = "c10730";
        com.baidu.tieba.card.data.l.bKg = "c10731";
        com.baidu.tieba.card.data.l.bKh = "c10704";
        com.baidu.tieba.card.data.l.bKi = "c10755";
        com.baidu.tieba.card.data.l.bKj = "c10710";
        com.baidu.tieba.card.data.l.bKk = "c10736";
        com.baidu.tieba.card.data.l.bKl = "c10737";
        com.baidu.tieba.card.data.l.bKm = "c10711";
        com.baidu.tieba.card.data.l.bKn = "c10758";
        com.baidu.tieba.card.data.l.bKo = "c10757";
    }

    public void setEventCallback(h.a aVar) {
        this.amd = aVar;
    }
}
