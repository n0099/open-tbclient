package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n>> {
    public BdUniqueId aOx;
    private h.a alx;
    private x cYE;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cvd;
    private com.baidu.adp.lib.e.b<TbImageView> cve;
    private com.baidu.tieba.card.n dcs;
    private com.baidu.tieba.homepage.personalize.model.e dct;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alx = null;
        this.cvd = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aiX */
            public com.baidu.tbadk.widget.layout.b fJ() {
                return new com.baidu.tbadk.widget.layout.b(h.this.mF.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cve = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.b.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xo */
            public TbImageView fJ() {
                TbImageView tbImageView = new TbImageView(h.this.mF.getPageActivity());
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
        this.cYE = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.XY().cC(true);
                if (view != null && h.this.dcs != null && h.this.dcs.getView() != null && h.this.dct != null && lVar != null && lVar.MR() != null && !StringUtils.isNull(lVar.MR().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L));
                        h.this.dct.a(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.Yb(), lVar.Yd(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.dcs.getView().getId()) {
                        if (h.this.dcs.bLe == null || view.getId() != h.this.dcs.bLe.getId()) {
                            if (h.this.dcs.getHeaderImg() == null || view.getId() != h.this.dcs.getHeaderImg().getId()) {
                                if (h.this.dcs.XD() == null || view.getId() != h.this.dcs.XD().getId()) {
                                    if (h.this.dcs.blz != null && h.this.dcs.blz.getBarNameTv() != null && view.getId() == h.this.dcs.blz.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.Ym());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.dcs.XC() != null && view.getId() == h.this.dcs.XC().getId()) {
                                            TiebaStatic.log(lVar.jC("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.Yo());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.Yn());
                                return;
                            }
                            TiebaStatic.log(lVar.Yn());
                            return;
                        }
                        TiebaStatic.log(lVar.Yp());
                        return;
                    }
                    TiebaStatic.log(lVar.Yl());
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> onCreateViewHolder(ViewGroup viewGroup) {
        this.dcs = new com.baidu.tieba.card.n(this.mF);
        this.dcs.setConstrainLayoutPool(this.cvd);
        this.dcs.setConstrainImagePool(this.cve);
        this.dcs.l(this.aOx);
        return new com.baidu.tieba.card.a.a<>(this.dcs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> aVar) {
        if (lVar == null || aVar == null || aVar.Yy() == null) {
            return null;
        }
        lVar.hH(i + 1);
        u.XY().a(lVar.Yk());
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

    public void setFromCDN(boolean z) {
        if (this.dcs != null) {
            this.dcs.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dct = eVar;
    }

    public void setEventCallback(h.a aVar) {
        this.alx = aVar;
    }
}
