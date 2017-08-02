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
    public BdUniqueId aNy;
    private h.a akI;
    private TbPageContext<?> ako;
    private x cOT;
    private com.baidu.tieba.card.n cSx;
    private com.baidu.tieba.homepage.personalize.model.e cSy;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cmE;
    private com.baidu.adp.lib.e.b<TbImageView> cmF;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akI = null;
        this.cmE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agO */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(h.this.ako.getPageActivity());
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
        this.cmF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.b.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xe */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(h.this.ako.getPageActivity());
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
        this.cOT = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.Ww().cA(true);
                if (view != null && h.this.cSx != null && h.this.cSx.getView() != null && h.this.cSy != null && lVar != null && lVar.MA() != null && !StringUtils.isNull(lVar.MA().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(lVar.MA().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.MA().getTid(), 0L));
                        h.this.cSy.a(com.baidu.adp.lib.g.b.c(lVar.MA().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.WA(), lVar.WC(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.cSx.getView().getId()) {
                        if (h.this.cSx.bGq == null || view.getId() != h.this.cSx.bGq.getId()) {
                            if (h.this.cSx.getHeaderImg() == null || view.getId() != h.this.cSx.getHeaderImg().getId()) {
                                if (h.this.cSx.Wc() == null || view.getId() != h.this.cSx.Wc().getId()) {
                                    if (h.this.cSx.bjP != null && h.this.cSx.bjP.getBarNameTv() != null && view.getId() == h.this.cSx.bjP.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.WL());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.cSx.Wb() != null && view.getId() == h.this.cSx.Wb().getId()) {
                                            TiebaStatic.log(lVar.ji("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.WN());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.WM());
                                return;
                            }
                            TiebaStatic.log(lVar.WM());
                            return;
                        }
                        TiebaStatic.log(lVar.WO());
                        return;
                    }
                    TiebaStatic.log(lVar.WK());
                }
            }
        };
        this.ako = tbPageContext;
        aov();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> onCreateViewHolder(ViewGroup viewGroup) {
        this.cSx = new com.baidu.tieba.card.n(this.ako);
        this.cSx.setConstrainLayoutPool(this.cmE);
        this.cSx.setConstrainImagePool(this.cmF);
        this.cSx.j(this.aNy);
        return new com.baidu.tieba.card.a.a<>(this.cSx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> aVar) {
        if (lVar == null || aVar == null || aVar.WX() == null) {
            return null;
        }
        lVar.hu(i + 1);
        u.Ww().a(lVar.WJ());
        aVar.WX().a(lVar);
        aVar.WX().a(this.cOT);
        aVar.WX().a(this.akI);
        return aVar.getView();
    }

    private void aov() {
        com.baidu.tieba.card.data.l.bIl = "c10705";
        com.baidu.tieba.card.data.l.bIm = "c10730";
        com.baidu.tieba.card.data.l.bIn = "c10731";
        com.baidu.tieba.card.data.l.bIo = "c10704";
        com.baidu.tieba.card.data.l.bIp = "c10755";
        com.baidu.tieba.card.data.l.bIq = "c10710";
        com.baidu.tieba.card.data.l.bIr = "c10736";
        com.baidu.tieba.card.data.l.bIs = "c10737";
        com.baidu.tieba.card.data.l.bIt = "c10711";
        com.baidu.tieba.card.data.l.bIu = "c10758";
        com.baidu.tieba.card.data.l.bIv = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cSx != null) {
            this.cSx.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cSy = eVar;
    }

    public void setEventCallback(h.a aVar) {
        this.akI = aVar;
    }
}
