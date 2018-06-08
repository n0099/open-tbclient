package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<p>> implements com.baidu.tieba.a.f {
    public BdUniqueId aQJ;
    private String bER;
    private NEGFeedBackView.a bgZ;
    private ab dNe;
    private p dQT;
    private com.baidu.tieba.homepage.personalize.model.e dQU;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dod;
    private com.baidu.adp.lib.e.b<TbImageView> doe;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.dQT.getView().getId()) {
            TiebaStatic.log(kVar.ajB());
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", kVar.ajB());
        } else if (this.dQT.cyE != null && view.getId() == this.dQT.cyE.getId()) {
            TiebaStatic.log(kVar.ajF());
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", kVar.ajF());
        } else if (this.dQT.getHeaderImg() != null && view.getId() == this.dQT.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.ajD());
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", kVar.ajD());
        } else if (this.dQT.aiL() != null && view.getId() == this.dQT.aiL().getId()) {
            TiebaStatic.log(kVar.ajD());
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", kVar.ajD());
        } else if (this.dQT.bFe != null && this.dQT.bFe.getBarNameTv() != null && view.getId() == this.dQT.bFe.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.ajC());
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", kVar.ajC());
        } else if (this.dQT.bFT != null && this.dQT.bFT.axM != null && view.getId() == this.dQT.bFT.axM.getId()) {
            TiebaStatic.log(kVar.ajC());
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", kVar.ajC());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.ajE());
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", kVar.ajE());
        } else if (this.dQT.aiK() != null && view.getId() == this.dQT.aiK().getId()) {
            TiebaStatic.log(kVar.ll("c10760"));
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", kVar.ll("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            am ah = new am("c11004").ah("tid", kVar.threadData.getTid());
            TiebaStatic.log(ah);
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", ah);
        } else if (view.getId() == this.dQT.getView().getId()) {
            am ah2 = new am("c11004").ah("tid", kVar.threadData.getTid());
            TiebaStatic.log(ah2);
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", ah2);
            am ah3 = new am("c10806").r("obj_locate", 1).ah("tid", kVar.threadData.getId());
            TiebaStatic.log(ah3);
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", ah3);
        } else {
            am ah4 = new am("c11004").ah("tid", kVar.threadData.getTid());
            TiebaStatic.log(ah4);
            com.baidu.tieba.a.d.Qe().a("page_recommend", "clk_", ah4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgZ = null;
        this.dod = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avY */
            public ConstrainImageLayout mo9if() {
                return new ConstrainImageLayout(f.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.doe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AI */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0141d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.dNe = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.ajh().cG(true);
                if (view != null && f.this.dQT != null && f.this.dQT.getView() != null && f.this.dQU != null && kVar != null && kVar.Sz() != null && !StringUtils.isNull(kVar.Sz().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bQ(com.baidu.adp.lib.g.b.c(kVar.Sz().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bP(com.baidu.adp.lib.g.b.c(kVar.Sz().getTid(), 0L));
                        f.this.dQU.a(com.baidu.adp.lib.g.b.c(kVar.Sz().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.ajp(), kVar.ajr(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cBJ) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aCS();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        this.dQT = new p(this.mPageContext);
        this.dQT.setConstrainLayoutPool(this.dod);
        this.dQT.setConstrainImagePool(this.doe);
        this.dQT.j(this.aQJ);
        this.dQT.currentPageType = 2;
        if (this.dQT.bFe != null) {
            this.dQT.bFe.aka = 2;
        }
        if (this.dQT.bFT != null && this.dQT.bFT.axN != null) {
            this.dQT.bFT.axN.aka = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.dQT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.ajG() == null) {
            return null;
        }
        kVar.iN(i + 1);
        v.ajh().a(kVar.ajA());
        com.baidu.tieba.a.d.Qe().a("page_recommend", "show_", kVar.ajA());
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        aVar.ajG().a(kVar);
        aVar.ajG().b(this.dNe);
        aVar.ajG().a(this.bgZ);
        return aVar.getView();
    }

    private void aCS() {
        com.baidu.tieba.card.data.k.cBy = "c10705";
        com.baidu.tieba.card.data.k.cBz = "c10730";
        com.baidu.tieba.card.data.k.cBA = "c10731";
        com.baidu.tieba.card.data.k.cBB = "c10704";
        com.baidu.tieba.card.data.k.cBC = "c10755";
        com.baidu.tieba.card.data.k.cBD = "c10710";
        com.baidu.tieba.card.data.k.cBE = "c10736";
        com.baidu.tieba.card.data.k.cBF = "c10737";
        com.baidu.tieba.card.data.k.cBG = "c10711";
        com.baidu.tieba.card.data.k.cBH = "c10758";
        com.baidu.tieba.card.data.k.cBI = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dQT != null) {
            this.dQT.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dQU = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bgZ = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
