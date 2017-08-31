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
    public BdUniqueId aOx;
    private h.a alx;
    private x cYE;
    private r dcq;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alx = null;
        this.cYE = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.XY().cC(true);
                if (view != null && g.this.dcq != null && g.this.dcq.getView() != null && lVar != null && lVar.MR() != null && !StringUtils.isNull(lVar.MR().getTid())) {
                    if (view.getId() != g.this.dcq.getView().getId()) {
                        if (g.this.dcq.getHeaderImg() == null || view.getId() != g.this.dcq.getHeaderImg().getId()) {
                            if (g.this.dcq.XD() == null || view.getId() != g.this.dcq.XD().getId()) {
                                if (g.this.dcq.blz == null || g.this.dcq.blz.getBarNameTv() == null || view.getId() != g.this.dcq.blz.getBarNameTv().getId()) {
                                    if (g.this.dcq.XC() != null && view.getId() == g.this.dcq.XC().getId()) {
                                        TiebaStatic.log(lVar.jC("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.Ym());
                                return;
                            }
                            TiebaStatic.log(lVar.jB("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jB("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jB("c12192"));
                }
            }
        };
        this.mF = tbPageContext;
        aqS();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dcq = new r(this.mF);
        this.dcq.l(this.aOx);
        return new com.baidu.tieba.card.a.a<>(this.dcq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.Yy() == null) {
            return null;
        }
        lVar.hH(i + 1);
        u.XY().a(lVar.jA("c12190"));
        aVar.Yy().a(lVar);
        aVar.Yy().b(this.cYE);
        aVar.Yy().a(this.alx);
        return aVar.getView();
    }

    private void aqS() {
        com.baidu.tieba.card.data.l.bMX = "c10705";
        com.baidu.tieba.card.data.l.bMY = "c10730";
        com.baidu.tieba.card.data.l.bMZ = "c10731";
        com.baidu.tieba.card.data.l.bNa = "c10704";
        com.baidu.tieba.card.data.l.bNb = "c10755";
        com.baidu.tieba.card.data.l.bNc = "c10710";
        com.baidu.tieba.card.data.l.bNd = "c10736";
        com.baidu.tieba.card.data.l.bNe = "c10737";
        com.baidu.tieba.card.data.l.bNf = "c10711";
        com.baidu.tieba.card.data.l.bNg = "c10758";
        com.baidu.tieba.card.data.l.bNh = "c10757";
    }

    public void setEventCallback(h.a aVar) {
        this.alx = aVar;
    }
}
