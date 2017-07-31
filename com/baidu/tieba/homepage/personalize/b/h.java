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
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private h.a amc;
    private x cQm;
    private com.baidu.tieba.card.n cTQ;
    private com.baidu.tieba.homepage.personalize.model.e cTR;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cnQ;
    private com.baidu.adp.lib.e.b<TbImageView> cnR;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amc = null;
        this.cnQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agV */
            public com.baidu.tbadk.widget.layout.b fT() {
                return new com.baidu.tbadk.widget.layout.b(h.this.alI.getPageActivity());
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
        this.cnR = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.b.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xm */
            public TbImageView fT() {
                TbImageView tbImageView = new TbImageView(h.this.alI.getPageActivity());
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
        this.cQm = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.WB().cA(true);
                if (view != null && h.this.cTQ != null && h.this.cTQ.getView() != null && h.this.cTR != null && lVar != null && lVar.MF() != null && !StringUtils.isNull(lVar.MF().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L));
                        h.this.cTR.a(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.WF(), lVar.WH(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.cTQ.getView().getId()) {
                        if (h.this.cTQ.bHA == null || view.getId() != h.this.cTQ.bHA.getId()) {
                            if (h.this.cTQ.getHeaderImg() == null || view.getId() != h.this.cTQ.getHeaderImg().getId()) {
                                if (h.this.cTQ.Wh() == null || view.getId() != h.this.cTQ.Wh().getId()) {
                                    if (h.this.cTQ.bkZ != null && h.this.cTQ.bkZ.getBarNameTv() != null && view.getId() == h.this.cTQ.bkZ.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.WQ());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.cTQ.Wg() != null && view.getId() == h.this.cTQ.Wg().getId()) {
                                            TiebaStatic.log(lVar.jn("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.WS());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.WR());
                                return;
                            }
                            TiebaStatic.log(lVar.WR());
                            return;
                        }
                        TiebaStatic.log(lVar.WT());
                        return;
                    }
                    TiebaStatic.log(lVar.WP());
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> onCreateViewHolder(ViewGroup viewGroup) {
        this.cTQ = new com.baidu.tieba.card.n(this.alI);
        this.cTQ.setConstrainLayoutPool(this.cnQ);
        this.cTQ.setConstrainImagePool(this.cnR);
        this.cTQ.j(this.aOM);
        return new com.baidu.tieba.card.a.a<>(this.cTQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> aVar) {
        if (lVar == null || aVar == null || aVar.Xc() == null) {
            return null;
        }
        lVar.hv(i + 1);
        u.WB().a(lVar.WO());
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

    public void setFromCDN(boolean z) {
        if (this.cTQ != null) {
            this.cTQ.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cTR = eVar;
    }

    public void setEventCallback(h.a aVar) {
        this.amc = aVar;
    }
}
