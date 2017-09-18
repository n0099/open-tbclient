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
    public BdUniqueId aOu;
    private h.a alv;
    private x cZy;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cvV;
    private com.baidu.adp.lib.e.b<TbImageView> cvW;
    private com.baidu.tieba.card.n ddn;
    private com.baidu.tieba.homepage.personalize.model.e ddo;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alv = null;
        this.cvV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aji */
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
        this.cvW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.b.h.2
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
        this.cZy = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.Yj().cC(true);
                if (view != null && h.this.ddn != null && h.this.ddn.getView() != null && h.this.ddo != null && lVar != null && lVar.MR() != null && !StringUtils.isNull(lVar.MR().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L));
                        h.this.ddo.a(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.Ym(), lVar.Yo(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.ddn.getView().getId()) {
                        if (h.this.ddn.bLV == null || view.getId() != h.this.ddn.bLV.getId()) {
                            if (h.this.ddn.getHeaderImg() == null || view.getId() != h.this.ddn.getHeaderImg().getId()) {
                                if (h.this.ddn.XO() == null || view.getId() != h.this.ddn.XO().getId()) {
                                    if (h.this.ddn.bly != null && h.this.ddn.bly.getBarNameTv() != null && view.getId() == h.this.ddn.bly.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.Yx());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.ddn.XN() != null && view.getId() == h.this.ddn.XN().getId()) {
                                            TiebaStatic.log(lVar.jE("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.Yz());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.Yy());
                                return;
                            }
                            TiebaStatic.log(lVar.Yy());
                            return;
                        }
                        TiebaStatic.log(lVar.YA());
                        return;
                    }
                    TiebaStatic.log(lVar.Yw());
                }
            }
        };
        this.mF = tbPageContext;
        ard();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> onCreateViewHolder(ViewGroup viewGroup) {
        this.ddn = new com.baidu.tieba.card.n(this.mF);
        this.ddn.setConstrainLayoutPool(this.cvV);
        this.ddn.setConstrainImagePool(this.cvW);
        this.ddn.l(this.aOu);
        return new com.baidu.tieba.card.a.a<>(this.ddn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> aVar) {
        if (lVar == null || aVar == null || aVar.YJ() == null) {
            return null;
        }
        lVar.hJ(i + 1);
        u.Yj().a(lVar.Yv());
        aVar.YJ().a(lVar);
        aVar.YJ().b(this.cZy);
        aVar.YJ().a(this.alv);
        return aVar.getView();
    }

    private void ard() {
        com.baidu.tieba.card.data.l.bNO = "c10705";
        com.baidu.tieba.card.data.l.bNP = "c10730";
        com.baidu.tieba.card.data.l.bNQ = "c10731";
        com.baidu.tieba.card.data.l.bNR = "c10704";
        com.baidu.tieba.card.data.l.bNS = "c10755";
        com.baidu.tieba.card.data.l.bNT = "c10710";
        com.baidu.tieba.card.data.l.bNU = "c10736";
        com.baidu.tieba.card.data.l.bNV = "c10737";
        com.baidu.tieba.card.data.l.bNW = "c10711";
        com.baidu.tieba.card.data.l.bNX = "c10758";
        com.baidu.tieba.card.data.l.bNY = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.ddn != null) {
            this.ddn.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ddo = eVar;
    }

    public void setEventCallback(h.a aVar) {
        this.alv = aVar;
    }
}
