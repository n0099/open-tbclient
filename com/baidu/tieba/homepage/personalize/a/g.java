package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<r>> {
    public BdUniqueId aPq;
    private c.a aVE;
    private x ddZ;
    private r dhC;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVE = null;
        this.ddZ = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.ZX().cv(true);
                if (view != null && g.this.dhC != null && g.this.dhC.getView() != null && lVar != null && lVar.Np() != null && !StringUtils.isNull(lVar.Np().getTid())) {
                    if (view.getId() != g.this.dhC.getView().getId()) {
                        if (g.this.dhC.getHeaderImg() == null || view.getId() != g.this.dhC.getHeaderImg().getId()) {
                            if (g.this.dhC.ZA() == null || view.getId() != g.this.dhC.ZA().getId()) {
                                if (g.this.dhC.boD == null || g.this.dhC.boD.getBarNameTv() == null || view.getId() != g.this.dhC.boD.getBarNameTv().getId()) {
                                    if (g.this.dhC.Zz() != null && view.getId() == g.this.dhC.Zz().getId()) {
                                        TiebaStatic.log(lVar.jU("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.aal());
                                return;
                            }
                            TiebaStatic.log(lVar.jT("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jT("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jT("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        asc();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dhC = new r(this.mPageContext);
        this.dhC.k(this.aPq);
        return new com.baidu.tieba.card.a.a<>(this.dhC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.aax() == null) {
            return null;
        }
        lVar.ij(i + 1);
        u.ZX().a(lVar.jS("c12190"));
        aVar.aax().a(lVar);
        aVar.aax().b(this.ddZ);
        aVar.aax().a(this.aVE);
        return aVar.getView();
    }

    private void asc() {
        com.baidu.tieba.card.data.l.bUL = "c10705";
        com.baidu.tieba.card.data.l.bUM = "c10730";
        com.baidu.tieba.card.data.l.bUN = "c10731";
        com.baidu.tieba.card.data.l.bUO = "c10704";
        com.baidu.tieba.card.data.l.bUP = "c10755";
        com.baidu.tieba.card.data.l.bUQ = "c10710";
        com.baidu.tieba.card.data.l.bUR = "c10736";
        com.baidu.tieba.card.data.l.bUS = "c10737";
        com.baidu.tieba.card.data.l.bUT = "c10711";
        com.baidu.tieba.card.data.l.bUU = "c10758";
        com.baidu.tieba.card.data.l.bUV = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.aVE = aVar;
    }
}
