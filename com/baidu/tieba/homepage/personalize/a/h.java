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
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<n>> {
    public BdUniqueId aPy;
    private c.a aVM;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cEr;
    private com.baidu.adp.lib.e.b<TbImageView> cEs;
    private x deu;
    private n dhY;
    private com.baidu.tieba.homepage.personalize.model.e dhZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVM = null;
        this.cEr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alI */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(h.this.mPageContext.getPageActivity());
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
        this.cEs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(h.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0080d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
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
        this.deu = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.aaj().cw(true);
                if (view != null && h.this.dhY != null && h.this.dhY.getView() != null && h.this.dhZ != null && lVar != null && lVar.NA() != null && !StringUtils.isNull(lVar.NA().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.NA().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(lVar.NA().getTid(), 0L));
                        h.this.dhZ.a(com.baidu.adp.lib.g.b.c(lVar.NA().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aam(), lVar.aao(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.dhY.getView().getId()) {
                        if (h.this.dhY.bSW == null || view.getId() != h.this.dhY.bSW.getId()) {
                            if (h.this.dhY.getHeaderImg() == null || view.getId() != h.this.dhY.getHeaderImg().getId()) {
                                if (h.this.dhY.ZM() == null || view.getId() != h.this.dhY.ZM().getId()) {
                                    if (h.this.dhY.boM != null && h.this.dhY.boM.getBarNameTv() != null && view.getId() == h.this.dhY.boM.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.aax());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.dhY.ZL() != null && view.getId() == h.this.dhY.ZL().getId()) {
                                            TiebaStatic.log(lVar.jV("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.aaz());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.aay());
                                return;
                            }
                            TiebaStatic.log(lVar.aay());
                            return;
                        }
                        TiebaStatic.log(lVar.aaA());
                        return;
                    }
                    TiebaStatic.log(lVar.aaw());
                }
            }
        };
        this.mPageContext = tbPageContext;
        ast();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a<n> onCreateViewHolder(ViewGroup viewGroup) {
        this.dhY = new n(this.mPageContext);
        this.dhY.setConstrainLayoutPool(this.cEr);
        this.dhY.setConstrainImagePool(this.cEs);
        this.dhY.k(this.aPy);
        return new com.baidu.tieba.card.a.a<>(this.dhY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<n> aVar) {
        if (lVar == null || aVar == null || aVar.aaJ() == null) {
            return null;
        }
        lVar.ih(i + 1);
        u.aaj().a(lVar.aav());
        aVar.aaJ().a(lVar);
        aVar.aaJ().b(this.deu);
        aVar.aaJ().a(this.aVM);
        return aVar.getView();
    }

    private void ast() {
        com.baidu.tieba.card.data.l.bUY = "c10705";
        com.baidu.tieba.card.data.l.bUZ = "c10730";
        com.baidu.tieba.card.data.l.bVa = "c10731";
        com.baidu.tieba.card.data.l.bVb = "c10704";
        com.baidu.tieba.card.data.l.bVc = "c10755";
        com.baidu.tieba.card.data.l.bVd = "c10710";
        com.baidu.tieba.card.data.l.bVe = "c10736";
        com.baidu.tieba.card.data.l.bVf = "c10737";
        com.baidu.tieba.card.data.l.bVg = "c10711";
        com.baidu.tieba.card.data.l.bVh = "c10758";
        com.baidu.tieba.card.data.l.bVi = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dhY != null) {
            this.dhY.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhZ = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aVM = aVar;
    }
}
