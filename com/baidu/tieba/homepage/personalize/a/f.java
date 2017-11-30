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
    public BdUniqueId aSv;
    private c.a aYN;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNv;
    private com.baidu.adp.lib.e.b<TbImageView> cNw;
    private v dmZ;
    private com.baidu.tieba.card.l dqI;
    private com.baidu.tieba.homepage.personalize.model.e dqJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (view.getId() == this.dqI.getView().getId()) {
            TiebaStatic.log(lVar.acf());
        } else if (this.dqI.caI != null && view.getId() == this.dqI.caI.getId()) {
            TiebaStatic.log(lVar.acj());
        } else if (this.dqI.getHeaderImg() != null && view.getId() == this.dqI.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.ach());
        } else if (this.dqI.abv() != null && view.getId() == this.dqI.abv().getId()) {
            TiebaStatic.log(lVar.ach());
        } else if (this.dqI.bvH != null && this.dqI.bvH.getBarNameTv() != null && view.getId() == this.dqI.bvH.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.acg());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(lVar.aci());
        } else if (this.dqI.abu() != null && view.getId() == this.dqI.abu().getId()) {
            TiebaStatic.log(lVar.kb("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ac("tid", lVar.threadData.getTid()));
        } else if (view.getId() == this.dqI.getView().getId()) {
            TiebaStatic.log(new ak("c11004").ac("tid", lVar.threadData.getTid()));
            TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", lVar.threadData.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").ac("tid", lVar.threadData.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYN = null;
        this.cNv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anD */
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
        this.cNw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wN */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0082d.common_color_10264));
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
        this.dmZ = new v<l>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, l lVar) {
                s.abU().cB(true);
                if (view != null && f.this.dqI != null && f.this.dqI.getView() != null && f.this.dqJ != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bD(com.baidu.adp.lib.g.b.c(lVar.Ox().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bC(com.baidu.adp.lib.g.b.c(lVar.Ox().getTid(), 0L));
                        f.this.dqJ.a(com.baidu.adp.lib.g.b.c(lVar.Ox().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.abV(), lVar.abX(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (f.this.mType == l.TYPE) {
                        f.this.b(view, lVar);
                    } else if (f.this.mType == l.cdD) {
                        f.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aul();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.dqI = new com.baidu.tieba.card.l(this.mPageContext);
        this.dqI.setConstrainLayoutPool(this.cNv);
        this.dqI.setConstrainImagePool(this.cNw);
        this.dqI.k(this.aSv);
        this.dqI.currentPageType = 2;
        if (this.dqI.bvH != null) {
            this.dqI.bvH.anM = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.dqI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (lVar == null || aVar == null || aVar.acs() == null) {
            return null;
        }
        lVar.iE(i + 1);
        s.abU().a(lVar.ace());
        aVar.acs().a(lVar);
        aVar.acs().b(this.dmZ);
        aVar.acs().a(this.aYN);
        return aVar.getView();
    }

    private void aul() {
        l.cds = "c10705";
        l.cdt = "c10730";
        l.cdu = "c10731";
        l.cdv = "c10704";
        l.cdw = "c10755";
        l.cdx = "c10710";
        l.cdy = "c10736";
        l.cdz = "c10737";
        l.cdA = "c10711";
        l.cdB = "c10758";
        l.cdC = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dqI != null) {
            this.dqI.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dqJ = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aYN = aVar;
    }
}
