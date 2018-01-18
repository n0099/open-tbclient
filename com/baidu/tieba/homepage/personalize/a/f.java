package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    public BdUniqueId bGw;
    private c.a bMO;
    private int cardShowType;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dHm;
    private com.baidu.adp.lib.e.b<TbImageView> dHn;
    private v ebB;
    private com.baidu.tieba.card.l efl;
    private com.baidu.tieba.homepage.personalize.model.e efm;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.efl.getView().getId()) {
            TiebaStatic.log(lVar.akX());
        } else if (this.efl.cTY != null && view.getId() == this.efl.cTY.getId()) {
            TiebaStatic.log(lVar.alb());
        } else if (this.efl.getHeaderImg() != null && view.getId() == this.efl.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.akZ());
        } else if (this.efl.ake() != null && view.getId() == this.efl.ake().getId()) {
            TiebaStatic.log(lVar.akZ());
        } else if (this.efl.ciL != null && this.efl.ciL.getBarNameTv() != null && view.getId() == this.efl.ciL.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.akY());
        } else if (this.efl.cSr != null && this.efl.cSr.bcz != null && view.getId() == this.efl.cSr.bcz.getId()) {
            TiebaStatic.log(lVar.akY());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(lVar.ala());
        } else if (this.efl.akd() != null && view.getId() == this.efl.akd().getId()) {
            TiebaStatic.log(lVar.kn("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", lVar.threadData.getTid()));
        } else if (view.getId() == this.efl.getView().getId()) {
            TiebaStatic.log(new ak("c11004").ab("tid", lVar.threadData.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", lVar.threadData.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", lVar.threadData.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMO = null;
        this.cardShowType = 0;
        this.dHm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aws */
            public com.baidu.tbadk.widget.layout.b nk() {
                return new com.baidu.tbadk.widget.layout.b(f.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b at(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b au(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.dHn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Eb */
            public TbImageView nk() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0107d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView at(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView au(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.ebB = new v<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                s.akF().de(true);
                if (view != null && f.this.efl != null && f.this.efl.getView() != null && f.this.efm != null && lVar != null && lVar.VK() != null && !StringUtils.isNull(lVar.VK().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bK(com.baidu.adp.lib.g.b.c(lVar.VK().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bJ(com.baidu.adp.lib.g.b.c(lVar.VK().getTid(), 0L));
                        f.this.efm.a(com.baidu.adp.lib.g.b.c(lVar.VK().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.akN(), lVar.akP(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.l.TYPE) {
                        f.this.b(view, lVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.l.cXb) {
                        f.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBC();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.efl = new com.baidu.tieba.card.l(this.mPageContext);
        this.efl.setConstrainLayoutPool(this.dHm);
        this.efl.setConstrainImagePool(this.dHn);
        this.efl.j(this.bGw);
        this.efl.currentPageType = 2;
        if (this.efl.ciL != null) {
            this.efl.ciL.bbP = 2;
        }
        if (this.efl.cSr != null && this.efl.cSr.bcA != null) {
            this.efl.cSr.bcA.bbP = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.efl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (lVar == null || aVar == null || aVar.alk() == null) {
            return null;
        }
        lVar.lH(i + 1);
        s.akF().a(lVar.akW());
        if (lVar.threadData != null) {
            lVar.threadData.aPa = this.cardShowType;
        }
        aVar.alk().a(lVar);
        aVar.alk().b(this.ebB);
        aVar.alk().a(this.bMO);
        return aVar.getView();
    }

    private void aBC() {
        com.baidu.tieba.card.data.l.cWQ = "c10705";
        com.baidu.tieba.card.data.l.cWR = "c10730";
        com.baidu.tieba.card.data.l.cWS = "c10731";
        com.baidu.tieba.card.data.l.cWT = "c10704";
        com.baidu.tieba.card.data.l.cWU = "c10755";
        com.baidu.tieba.card.data.l.cWV = "c10710";
        com.baidu.tieba.card.data.l.cWW = "c10736";
        com.baidu.tieba.card.data.l.cWX = "c10737";
        com.baidu.tieba.card.data.l.cWY = "c10711";
        com.baidu.tieba.card.data.l.cWZ = "c10758";
        com.baidu.tieba.card.data.l.cXa = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.efl != null) {
            this.efl.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efm = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bMO = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
