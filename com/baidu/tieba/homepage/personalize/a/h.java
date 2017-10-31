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
    public BdUniqueId aPq;
    private c.a aVE;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cDY;
    private com.baidu.adp.lib.e.b<TbImageView> cDZ;
    private x ddZ;
    private n dhE;
    private com.baidu.tieba.homepage.personalize.model.e dhF;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVE = null;
        this.cDY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alu */
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
        this.cDZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.h.2
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
        this.ddZ = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.ZX().cv(true);
                if (view != null && h.this.dhE != null && h.this.dhE.getView() != null && h.this.dhF != null && lVar != null && lVar.Np() != null && !StringUtils.isNull(lVar.Np().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.Np().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(lVar.Np().getTid(), 0L));
                        h.this.dhF.a(com.baidu.adp.lib.g.b.c(lVar.Np().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aaa(), lVar.aac(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.dhE.getView().getId()) {
                        if (h.this.dhE.bSJ == null || view.getId() != h.this.dhE.bSJ.getId()) {
                            if (h.this.dhE.getHeaderImg() == null || view.getId() != h.this.dhE.getHeaderImg().getId()) {
                                if (h.this.dhE.ZA() == null || view.getId() != h.this.dhE.ZA().getId()) {
                                    if (h.this.dhE.boD != null && h.this.dhE.boD.getBarNameTv() != null && view.getId() == h.this.dhE.boD.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.aal());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.dhE.Zz() != null && view.getId() == h.this.dhE.Zz().getId()) {
                                            TiebaStatic.log(lVar.jU("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.aan());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.aam());
                                return;
                            }
                            TiebaStatic.log(lVar.aam());
                            return;
                        }
                        TiebaStatic.log(lVar.aao());
                        return;
                    }
                    TiebaStatic.log(lVar.aak());
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
    public com.baidu.tieba.card.a.a<n> onCreateViewHolder(ViewGroup viewGroup) {
        this.dhE = new n(this.mPageContext);
        this.dhE.setConstrainLayoutPool(this.cDY);
        this.dhE.setConstrainImagePool(this.cDZ);
        this.dhE.k(this.aPq);
        return new com.baidu.tieba.card.a.a<>(this.dhE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<n> aVar) {
        if (lVar == null || aVar == null || aVar.aax() == null) {
            return null;
        }
        lVar.ij(i + 1);
        u.ZX().a(lVar.aaj());
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

    public void setFromCDN(boolean z) {
        if (this.dhE != null) {
            this.dhE.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhF = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aVE = aVar;
    }
}
