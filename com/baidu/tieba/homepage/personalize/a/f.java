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
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    public BdUniqueId aSy;
    private c.a aYP;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNG;
    private com.baidu.adp.lib.e.b<TbImageView> cNH;
    private v dof;
    private com.baidu.tieba.card.l drN;
    private com.baidu.tieba.homepage.personalize.model.e drO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (view.getId() == this.drN.getView().getId()) {
            TiebaStatic.log(lVar.acp());
        } else if (this.drN.caM != null && view.getId() == this.drN.caM.getId()) {
            TiebaStatic.log(lVar.act());
        } else if (this.drN.getHeaderImg() != null && view.getId() == this.drN.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.acr());
        } else if (this.drN.abw() != null && view.getId() == this.drN.abw().getId()) {
            TiebaStatic.log(lVar.acr());
        } else if (this.drN.bvI != null && this.drN.bvI.getBarNameTv() != null && view.getId() == this.drN.bvI.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.acq());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(lVar.acs());
        } else if (this.drN.abv() != null && view.getId() == this.drN.abv().getId()) {
            TiebaStatic.log(lVar.jZ("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ac("tid", lVar.threadData.getTid()));
        } else if (view.getId() == this.drN.getView().getId()) {
            TiebaStatic.log(new ak("c11004").ac("tid", lVar.threadData.getTid()));
            TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", lVar.threadData.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").ac("tid", lVar.threadData.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.cNG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anM */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(f.this.mPageContext.getPageActivity());
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
        this.cNH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0096d.common_color_10264));
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
        this.dof = new v<l>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, l lVar) {
                s.abX().cC(true);
                if (view != null && f.this.drN != null && f.this.drN.getView() != null && f.this.drO != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bD(com.baidu.adp.lib.g.b.c(lVar.Ox().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bC(com.baidu.adp.lib.g.b.c(lVar.Ox().getTid(), 0L));
                        f.this.drO.a(com.baidu.adp.lib.g.b.c(lVar.Ox().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.acf(), lVar.ach(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (f.this.mType == l.TYPE) {
                        f.this.b(view, lVar);
                    } else if (f.this.mType == l.cdR) {
                        f.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        auu();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.drN = new com.baidu.tieba.card.l(this.mPageContext);
        this.drN.setConstrainLayoutPool(this.cNG);
        this.drN.setConstrainImagePool(this.cNH);
        this.drN.k(this.aSy);
        this.drN.currentPageType = 2;
        if (this.drN.bvI != null) {
            this.drN.bvI.anO = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.drN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (lVar == null || aVar == null || aVar.acC() == null) {
            return null;
        }
        lVar.iG(i + 1);
        s.abX().a(lVar.aco());
        aVar.acC().a(lVar);
        aVar.acC().b(this.dof);
        aVar.acC().a(this.aYP);
        return aVar.getView();
    }

    private void auu() {
        l.cdG = "c10705";
        l.cdH = "c10730";
        l.cdI = "c10731";
        l.cdJ = "c10704";
        l.cdK = "c10755";
        l.cdL = "c10710";
        l.cdM = "c10736";
        l.cdN = "c10737";
        l.cdO = "c10711";
        l.cdP = "c10758";
        l.cdQ = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.drN != null) {
            this.drN.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.drO = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aYP = aVar;
    }
}
