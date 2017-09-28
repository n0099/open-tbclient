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
    public BdUniqueId aPx;
    private c.a aVH;
    private x cVT;
    private r cZz;
    private TbPageContext<?> mG;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVH = null;
        this.cVT = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.XR().cB(true);
                if (view != null && g.this.cZz != null && g.this.cZz.getView() != null && lVar != null && lVar.Nj() != null && !StringUtils.isNull(lVar.Nj().getTid())) {
                    if (view.getId() != g.this.cZz.getView().getId()) {
                        if (g.this.cZz.getHeaderImg() == null || view.getId() != g.this.cZz.getHeaderImg().getId()) {
                            if (g.this.cZz.Xu() == null || view.getId() != g.this.cZz.Xu().getId()) {
                                if (g.this.cZz.bnj == null || g.this.cZz.bnj.getBarNameTv() == null || view.getId() != g.this.cZz.bnj.getBarNameTv().getId()) {
                                    if (g.this.cZz.Xt() != null && view.getId() == g.this.cZz.Xt().getId()) {
                                        TiebaStatic.log(lVar.jy("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.Yf());
                                return;
                            }
                            TiebaStatic.log(lVar.jx("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jx("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jx("c12192"));
                }
            }
        };
        this.mG = tbPageContext;
        apJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.cZz = new r(this.mG);
        this.cZz.k(this.aPx);
        return new com.baidu.tieba.card.a.a<>(this.cZz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.Yr() == null) {
            return null;
        }
        lVar.hR(i + 1);
        u.XR().a(lVar.jw("c12190"));
        aVar.Yr().a(lVar);
        aVar.Yr().b(this.cVT);
        aVar.Yr().a(this.aVH);
        return aVar.getView();
    }

    private void apJ() {
        com.baidu.tieba.card.data.l.bNt = "c10705";
        com.baidu.tieba.card.data.l.bNu = "c10730";
        com.baidu.tieba.card.data.l.bNv = "c10731";
        com.baidu.tieba.card.data.l.bNw = "c10704";
        com.baidu.tieba.card.data.l.bNx = "c10755";
        com.baidu.tieba.card.data.l.bNy = "c10710";
        com.baidu.tieba.card.data.l.bNz = "c10736";
        com.baidu.tieba.card.data.l.bNA = "c10737";
        com.baidu.tieba.card.data.l.bNB = "c10711";
        com.baidu.tieba.card.data.l.bNC = "c10758";
        com.baidu.tieba.card.data.l.bND = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.aVH = aVar;
    }
}
