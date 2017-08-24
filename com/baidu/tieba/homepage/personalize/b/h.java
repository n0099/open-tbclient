package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n>> {
    public BdUniqueId aOO;
    private h.a amd;
    private x cSl;
    private com.baidu.tieba.card.n cVP;
    private com.baidu.tieba.homepage.personalize.model.e cVQ;
    private com.baidu.adp.lib.e.b<TbImageView> coA;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> coz;
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amd = null;
        this.coz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ahk */
            public com.baidu.tbadk.widget.layout.b fT() {
                return new com.baidu.tbadk.widget.layout.b(h.this.oW.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void o(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b q(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.coA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.b.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xm */
            public TbImageView fT() {
                TbImageView tbImageView = new TbImageView(h.this.oW.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ai.getColor(d.e.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView p(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.cSl = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.WU().cA(true);
                if (view != null && h.this.cVP != null && h.this.cVP.getView() != null && h.this.cVQ != null && lVar != null && lVar.MF() != null && !StringUtils.isNull(lVar.MF().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L));
                        h.this.cVQ.a(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.WY(), lVar.Xa(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.cVP.getView().getId()) {
                        if (h.this.cVP.bIk == null || view.getId() != h.this.cVP.bIk.getId()) {
                            if (h.this.cVP.getHeaderImg() == null || view.getId() != h.this.cVP.getHeaderImg().getId()) {
                                if (h.this.cVP.WA() == null || view.getId() != h.this.cVP.WA().getId()) {
                                    if (h.this.cVP.ble != null && h.this.cVP.ble.getBarNameTv() != null && view.getId() == h.this.cVP.ble.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.Xj());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.cVP.Wz() != null && view.getId() == h.this.cVP.Wz().getId()) {
                                            TiebaStatic.log(lVar.jr("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.Xl());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.Xk());
                                return;
                            }
                            TiebaStatic.log(lVar.Xk());
                            return;
                        }
                        TiebaStatic.log(lVar.Xm());
                        return;
                    }
                    TiebaStatic.log(lVar.Xi());
                }
            }
        };
        this.oW = tbPageContext;
        api();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> onCreateViewHolder(ViewGroup viewGroup) {
        this.cVP = new com.baidu.tieba.card.n(this.oW);
        this.cVP.setConstrainLayoutPool(this.coz);
        this.cVP.setConstrainImagePool(this.coA);
        this.cVP.j(this.aOO);
        return new com.baidu.tieba.card.a.a<>(this.cVP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> aVar) {
        if (lVar == null || aVar == null || aVar.Xv() == null) {
            return null;
        }
        lVar.hw(i + 1);
        u.WU().a(lVar.Xh());
        aVar.Xv().a(lVar);
        aVar.Xv().b(this.cSl);
        aVar.Xv().a(this.amd);
        return aVar.getView();
    }

    private void api() {
        com.baidu.tieba.card.data.l.bKf = "c10705";
        com.baidu.tieba.card.data.l.bKg = "c10730";
        com.baidu.tieba.card.data.l.bKh = "c10731";
        com.baidu.tieba.card.data.l.bKi = "c10704";
        com.baidu.tieba.card.data.l.bKj = "c10755";
        com.baidu.tieba.card.data.l.bKk = "c10710";
        com.baidu.tieba.card.data.l.bKl = "c10736";
        com.baidu.tieba.card.data.l.bKm = "c10737";
        com.baidu.tieba.card.data.l.bKn = "c10711";
        com.baidu.tieba.card.data.l.bKo = "c10758";
        com.baidu.tieba.card.data.l.bKp = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cVP != null) {
            this.cVP.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cVQ = eVar;
    }

    public void setEventCallback(h.a aVar) {
        this.amd = aVar;
    }
}
