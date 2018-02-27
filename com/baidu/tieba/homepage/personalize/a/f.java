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
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId bIv;
    private c.a bOQ;
    private int cardShowType;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKB;
    private com.baidu.adp.lib.e.b<TbImageView> dKC;
    private v efW;
    private com.baidu.tieba.card.k ejG;
    private com.baidu.tieba.homepage.personalize.model.e ejH;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.ejG.getView().getId()) {
            TiebaStatic.log(kVar.alK());
        } else if (this.ejG.cWQ != null && view.getId() == this.ejG.cWQ.getId()) {
            TiebaStatic.log(kVar.alO());
        } else if (this.ejG.getHeaderImg() != null && view.getId() == this.ejG.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.alM());
        } else if (this.ejG.akR() != null && view.getId() == this.ejG.akR().getId()) {
            TiebaStatic.log(kVar.alM());
        } else if (this.ejG.clX != null && this.ejG.clX.getBarNameTv() != null && view.getId() == this.ejG.clX.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.alL());
        } else if (this.ejG.cmL != null && this.ejG.cmL.bel != null && view.getId() == this.ejG.cmL.bel.getId()) {
            TiebaStatic.log(kVar.alL());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.alN());
        } else if (this.ejG.akQ() != null && view.getId() == this.ejG.akQ().getId()) {
            TiebaStatic.log(kVar.kC("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", kVar.threadData.getTid()));
        } else if (view.getId() == this.ejG.getView().getId()) {
            TiebaStatic.log(new ak("c11004").ab("tid", kVar.threadData.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", kVar.threadData.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", kVar.threadData.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOQ = null;
        this.cardShowType = 0;
        this.dKB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axv */
            public com.baidu.tbadk.widget.layout.b nl() {
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
        this.dKC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ex */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0141d.common_color_10264));
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
        this.efW = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                r.als().dk(true);
                if (view != null && f.this.ejG != null && f.this.ejG.getView() != null && f.this.ejH != null && kVar != null && kVar.WD() != null && !StringUtils.isNull(kVar.WD().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(kVar.WD().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(kVar.WD().getTid(), 0L));
                        f.this.ejH.a(com.baidu.adp.lib.g.b.c(kVar.WD().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.alA(), kVar.alC(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cZX) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDa();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> onCreateViewHolder(ViewGroup viewGroup) {
        this.ejG = new com.baidu.tieba.card.k(this.mPageContext);
        this.ejG.setConstrainLayoutPool(this.dKB);
        this.ejG.setConstrainImagePool(this.dKC);
        this.ejG.j(this.bIv);
        this.ejG.currentPageType = 2;
        if (this.ejG.clX != null) {
            this.ejG.clX.aQt = 2;
        }
        if (this.ejG.cmL != null && this.ejG.cmL.bem != null) {
            this.ejG.cmL.bem.aQt = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.ejG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (kVar == null || aVar == null || aVar.alX() == null) {
            return null;
        }
        kVar.lD(i + 1);
        r.als().a(kVar.alJ());
        if (kVar.threadData != null) {
            kVar.threadData.aQo = this.cardShowType;
        }
        aVar.alX().a(kVar);
        aVar.alX().b(this.efW);
        aVar.alX().a(this.bOQ);
        return aVar.getView();
    }

    private void aDa() {
        com.baidu.tieba.card.data.k.cZM = "c10705";
        com.baidu.tieba.card.data.k.cZN = "c10730";
        com.baidu.tieba.card.data.k.cZO = "c10731";
        com.baidu.tieba.card.data.k.cZP = "c10704";
        com.baidu.tieba.card.data.k.cZQ = "c10755";
        com.baidu.tieba.card.data.k.cZR = "c10710";
        com.baidu.tieba.card.data.k.cZS = "c10736";
        com.baidu.tieba.card.data.k.cZT = "c10737";
        com.baidu.tieba.card.data.k.cZU = "c10711";
        com.baidu.tieba.card.data.k.cZV = "c10758";
        com.baidu.tieba.card.data.k.cZW = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.ejG != null) {
            this.ejG.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ejH = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bOQ = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
