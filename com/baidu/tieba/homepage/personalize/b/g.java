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
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private h.a amc;
    private x cQm;
    private r cTO;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amc = null;
        this.cQm = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.WB().cA(true);
                if (view != null && g.this.cTO != null && g.this.cTO.getView() != null && lVar != null && lVar.MF() != null && !StringUtils.isNull(lVar.MF().getTid())) {
                    if (view.getId() != g.this.cTO.getView().getId()) {
                        if (g.this.cTO.getHeaderImg() == null || view.getId() != g.this.cTO.getHeaderImg().getId()) {
                            if (g.this.cTO.Wh() == null || view.getId() != g.this.cTO.Wh().getId()) {
                                if (g.this.cTO.bkZ == null || g.this.cTO.bkZ.getBarNameTv() == null || view.getId() != g.this.cTO.bkZ.getBarNameTv().getId()) {
                                    if (g.this.cTO.Wg() != null && view.getId() == g.this.cTO.Wg().getId()) {
                                        TiebaStatic.log(lVar.jn("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.WQ());
                                return;
                            }
                            TiebaStatic.log(lVar.jm("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jm("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jm("c12192"));
                }
            }
        };
        this.alI = tbPageContext;
        aoH();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.cTO = new r(this.alI);
        this.cTO.j(this.aOM);
        return new com.baidu.tieba.card.a.a<>(this.cTO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.Xc() == null) {
            return null;
        }
        lVar.hv(i + 1);
        u.WB().a(lVar.jl("c12190"));
        aVar.Xc().a(lVar);
        aVar.Xc().a(this.cQm);
        aVar.Xc().a(this.amc);
        return aVar.getView();
    }

    private void aoH() {
        com.baidu.tieba.card.data.l.bJv = "c10705";
        com.baidu.tieba.card.data.l.bJw = "c10730";
        com.baidu.tieba.card.data.l.bJx = "c10731";
        com.baidu.tieba.card.data.l.bJy = "c10704";
        com.baidu.tieba.card.data.l.bJz = "c10755";
        com.baidu.tieba.card.data.l.bJA = "c10710";
        com.baidu.tieba.card.data.l.bJB = "c10736";
        com.baidu.tieba.card.data.l.bJC = "c10737";
        com.baidu.tieba.card.data.l.bJD = "c10711";
        com.baidu.tieba.card.data.l.bJE = "c10758";
        com.baidu.tieba.card.data.l.bJF = "c10757";
    }

    public void setEventCallback(h.a aVar) {
        this.amc = aVar;
    }
}
