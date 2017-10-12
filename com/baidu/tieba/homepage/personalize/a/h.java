package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n>> {
    public BdUniqueId aPx;
    private c.a aVH;
    private x cVT;
    private com.baidu.tieba.card.n cZB;
    private com.baidu.tieba.homepage.personalize.model.e cZC;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwD;
    private com.baidu.adp.lib.e.b<TbImageView> cwE;
    private TbPageContext<?> mG;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVH = null;
        this.cwD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajm */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(h.this.mG.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cwE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(h.this.mG.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.e.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView o(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView p(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.cVT = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.XR().cB(true);
                if (view != null && h.this.cZB != null && h.this.cZB.getView() != null && h.this.cZC != null && lVar != null && lVar.Nj() != null && !StringUtils.isNull(lVar.Nj().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bt(com.baidu.adp.lib.g.b.c(lVar.Nj().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bs(com.baidu.adp.lib.g.b.c(lVar.Nj().getTid(), 0L));
                        h.this.cZC.a(com.baidu.adp.lib.g.b.c(lVar.Nj().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.XU(), lVar.XW(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.cZB.getView().getId()) {
                        if (h.this.cZB.bLr == null || view.getId() != h.this.cZB.bLr.getId()) {
                            if (h.this.cZB.getHeaderImg() == null || view.getId() != h.this.cZB.getHeaderImg().getId()) {
                                if (h.this.cZB.Xu() == null || view.getId() != h.this.cZB.Xu().getId()) {
                                    if (h.this.cZB.bnj != null && h.this.cZB.bnj.getBarNameTv() != null && view.getId() == h.this.cZB.bnj.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.Yf());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.cZB.Xt() != null && view.getId() == h.this.cZB.Xt().getId()) {
                                            TiebaStatic.log(lVar.jx("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.Yh());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.Yg());
                                return;
                            }
                            TiebaStatic.log(lVar.Yg());
                            return;
                        }
                        TiebaStatic.log(lVar.Yi());
                        return;
                    }
                    TiebaStatic.log(lVar.Ye());
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> onCreateViewHolder(ViewGroup viewGroup) {
        this.cZB = new com.baidu.tieba.card.n(this.mG);
        this.cZB.setConstrainLayoutPool(this.cwD);
        this.cZB.setConstrainImagePool(this.cwE);
        this.cZB.k(this.aPx);
        return new com.baidu.tieba.card.a.a<>(this.cZB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> aVar) {
        if (lVar == null || aVar == null || aVar.Yr() == null) {
            return null;
        }
        lVar.hR(i + 1);
        u.XR().a(lVar.Yd());
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

    public void setFromCDN(boolean z) {
        if (this.cZB != null) {
            this.cZB.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cZC = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aVH = aVar;
    }
}
