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
    public BdUniqueId bII;
    private c.a bPd;
    private int cardShowType;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKN;
    private com.baidu.adp.lib.e.b<TbImageView> dKO;
    private v egi;
    private com.baidu.tieba.card.k ejS;
    private com.baidu.tieba.homepage.personalize.model.e ejT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.ejS.getView().getId()) {
            TiebaStatic.log(kVar.alL());
        } else if (this.ejS.cXc != null && view.getId() == this.ejS.cXc.getId()) {
            TiebaStatic.log(kVar.alP());
        } else if (this.ejS.getHeaderImg() != null && view.getId() == this.ejS.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.alN());
        } else if (this.ejS.akS() != null && view.getId() == this.ejS.akS().getId()) {
            TiebaStatic.log(kVar.alN());
        } else if (this.ejS.cmk != null && this.ejS.cmk.getBarNameTv() != null && view.getId() == this.ejS.cmk.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.alM());
        } else if (this.ejS.cmX != null && this.ejS.cmX.bey != null && view.getId() == this.ejS.cmX.bey.getId()) {
            TiebaStatic.log(kVar.alM());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.alO());
        } else if (this.ejS.akR() != null && view.getId() == this.ejS.akR().getId()) {
            TiebaStatic.log(kVar.kC("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", kVar.threadData.getTid()));
        } else if (view.getId() == this.ejS.getView().getId()) {
            TiebaStatic.log(new ak("c11004").ab("tid", kVar.threadData.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", kVar.threadData.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", kVar.threadData.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bPd = null;
        this.cardShowType = 0;
        this.dKN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axw */
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
        this.dKO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ey */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0140d.common_color_10264));
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
        this.egi = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                r.alt().dk(true);
                if (view != null && f.this.ejS != null && f.this.ejS.getView() != null && f.this.ejT != null && kVar != null && kVar.WE() != null && !StringUtils.isNull(kVar.WE().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(kVar.WE().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(kVar.WE().getTid(), 0L));
                        f.this.ejT.a(com.baidu.adp.lib.g.b.c(kVar.WE().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.alB(), kVar.alD(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.daj) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDb();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> onCreateViewHolder(ViewGroup viewGroup) {
        this.ejS = new com.baidu.tieba.card.k(this.mPageContext);
        this.ejS.setConstrainLayoutPool(this.dKN);
        this.ejS.setConstrainImagePool(this.dKO);
        this.ejS.j(this.bII);
        this.ejS.currentPageType = 2;
        if (this.ejS.cmk != null) {
            this.ejS.cmk.aQE = 2;
        }
        if (this.ejS.cmX != null && this.ejS.cmX.bez != null) {
            this.ejS.cmX.bez.aQE = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.ejS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (kVar == null || aVar == null || aVar.alY() == null) {
            return null;
        }
        kVar.lD(i + 1);
        r.alt().a(kVar.alK());
        if (kVar.threadData != null) {
            kVar.threadData.aQz = this.cardShowType;
        }
        aVar.alY().a(kVar);
        aVar.alY().b(this.egi);
        aVar.alY().a(this.bPd);
        return aVar.getView();
    }

    private void aDb() {
        com.baidu.tieba.card.data.k.cZY = "c10705";
        com.baidu.tieba.card.data.k.cZZ = "c10730";
        com.baidu.tieba.card.data.k.daa = "c10731";
        com.baidu.tieba.card.data.k.dab = "c10704";
        com.baidu.tieba.card.data.k.dac = "c10755";
        com.baidu.tieba.card.data.k.dad = "c10710";
        com.baidu.tieba.card.data.k.dae = "c10736";
        com.baidu.tieba.card.data.k.daf = "c10737";
        com.baidu.tieba.card.data.k.dag = "c10711";
        com.baidu.tieba.card.data.k.dah = "c10758";
        com.baidu.tieba.card.data.k.dai = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.ejS != null) {
            this.ejS.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ejT = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bPd = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
