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
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    public BdUniqueId bGo;
    private c.a bMG;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dCL;
    private com.baidu.adp.lib.e.b<TbImageView> dCM;
    private v ear;
    private com.baidu.tieba.card.l edX;
    private com.baidu.tieba.homepage.personalize.model.e edY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (view.getId() == this.edX.getView().getId()) {
            TiebaStatic.log(lVar.ajU());
        } else if (this.edX.cPw != null && view.getId() == this.edX.cPw.getId()) {
            TiebaStatic.log(lVar.ajY());
        } else if (this.edX.getHeaderImg() != null && view.getId() == this.edX.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.ajW());
        } else if (this.edX.ajb() != null && view.getId() == this.edX.ajb().getId()) {
            TiebaStatic.log(lVar.ajW());
        } else if (this.edX.ciE != null && this.edX.ciE.getBarNameTv() != null && view.getId() == this.edX.ciE.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.ajV());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(lVar.ajX());
        } else if (this.edX.aja() != null && view.getId() == this.edX.aja().getId()) {
            TiebaStatic.log(lVar.kf("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", lVar.threadData.getTid()));
        } else if (view.getId() == this.edX.getView().getId()) {
            TiebaStatic.log(new ak("c11004").ab("tid", lVar.threadData.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", lVar.threadData.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", lVar.threadData.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMG = null;
        this.dCL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avp */
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
        this.dCM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ek */
            public TbImageView nk() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0108d.common_color_10264));
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
        this.ear = new v<l>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, l lVar) {
                s.ajC().df(true);
                if (view != null && f.this.edX != null && f.this.edX.getView() != null && f.this.edY != null && lVar != null && lVar.VW() != null && !StringUtils.isNull(lVar.VW().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(lVar.VW().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(lVar.VW().getTid(), 0L));
                        f.this.edY.a(com.baidu.adp.lib.g.b.c(lVar.VW().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.ajK(), lVar.ajM(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (f.this.mType == l.TYPE) {
                        f.this.b(view, lVar);
                    } else if (f.this.mType == l.cSz) {
                        f.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.edX = new com.baidu.tieba.card.l(this.mPageContext);
        this.edX.setConstrainLayoutPool(this.dCL);
        this.edX.setConstrainImagePool(this.dCM);
        this.edX.j(this.bGo);
        this.edX.currentPageType = 2;
        if (this.edX.ciE != null) {
            this.edX.ciE.bbP = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.edX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (lVar == null || aVar == null || aVar.akh() == null) {
            return null;
        }
        lVar.lE(i + 1);
        s.ajC().a(lVar.ajT());
        aVar.akh().a(lVar);
        aVar.akh().b(this.ear);
        aVar.akh().a(this.bMG);
        return aVar.getView();
    }

    private void aBx() {
        l.cSo = "c10705";
        l.cSp = "c10730";
        l.cSq = "c10731";
        l.cSr = "c10704";
        l.cSs = "c10755";
        l.cSt = "c10710";
        l.cSu = "c10736";
        l.cSv = "c10737";
        l.cSw = "c10711";
        l.cSx = "c10758";
        l.cSy = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.edX != null) {
            this.edX.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.edY = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bMG = aVar;
    }
}
