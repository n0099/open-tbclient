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
    public BdUniqueId bGE;
    private c.a bMW;
    private int cardShowType;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dHH;
    private com.baidu.adp.lib.e.b<TbImageView> dHI;
    private v ebW;
    private com.baidu.tieba.card.l efG;
    private com.baidu.tieba.homepage.personalize.model.e efH;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.efG.getView().getId()) {
            TiebaStatic.log(lVar.alc());
        } else if (this.efG.cUt != null && view.getId() == this.efG.cUt.getId()) {
            TiebaStatic.log(lVar.alg());
        } else if (this.efG.getHeaderImg() != null && view.getId() == this.efG.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.ale());
        } else if (this.efG.akj() != null && view.getId() == this.efG.akj().getId()) {
            TiebaStatic.log(lVar.ale());
        } else if (this.efG.ciT != null && this.efG.ciT.getBarNameTv() != null && view.getId() == this.efG.ciT.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.ald());
        } else if (this.efG.cSM != null && this.efG.cSM.bcH != null && view.getId() == this.efG.cSM.bcH.getId()) {
            TiebaStatic.log(lVar.ald());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(lVar.alf());
        } else if (this.efG.aki() != null && view.getId() == this.efG.aki().getId()) {
            TiebaStatic.log(lVar.kv("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").aa("tid", lVar.threadData.getTid()));
        } else if (view.getId() == this.efG.getView().getId()) {
            TiebaStatic.log(new ak("c11004").aa("tid", lVar.threadData.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).aa("tid", lVar.threadData.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").aa("tid", lVar.threadData.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMW = null;
        this.cardShowType = 0;
        this.dHH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awx */
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
        this.dHI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ed */
            public TbImageView nl() {
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
        this.ebW = new v<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                s.akK().dg(true);
                if (view != null && f.this.efG != null && f.this.efG.getView() != null && f.this.efH != null && lVar != null && lVar.VM() != null && !StringUtils.isNull(lVar.VM().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(lVar.VM().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(lVar.VM().getTid(), 0L));
                        f.this.efH.a(com.baidu.adp.lib.g.b.c(lVar.VM().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.akS(), lVar.akU(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.l.TYPE) {
                        f.this.b(view, lVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.l.cXw) {
                        f.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBH();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.efG = new com.baidu.tieba.card.l(this.mPageContext);
        this.efG.setConstrainLayoutPool(this.dHH);
        this.efG.setConstrainImagePool(this.dHI);
        this.efG.j(this.bGE);
        this.efG.currentPageType = 2;
        if (this.efG.ciT != null) {
            this.efG.ciT.bbX = 2;
        }
        if (this.efG.cSM != null && this.efG.cSM.bcI != null) {
            this.efG.cSM.bcI.bbX = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.efG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (lVar == null || aVar == null || aVar.alp() == null) {
            return null;
        }
        lVar.lH(i + 1);
        s.akK().a(lVar.alb());
        if (lVar.threadData != null) {
            lVar.threadData.aPd = this.cardShowType;
        }
        aVar.alp().a(lVar);
        aVar.alp().b(this.ebW);
        aVar.alp().a(this.bMW);
        return aVar.getView();
    }

    private void aBH() {
        com.baidu.tieba.card.data.l.cXl = "c10705";
        com.baidu.tieba.card.data.l.cXm = "c10730";
        com.baidu.tieba.card.data.l.cXn = "c10731";
        com.baidu.tieba.card.data.l.cXo = "c10704";
        com.baidu.tieba.card.data.l.cXp = "c10755";
        com.baidu.tieba.card.data.l.cXq = "c10710";
        com.baidu.tieba.card.data.l.cXr = "c10736";
        com.baidu.tieba.card.data.l.cXs = "c10737";
        com.baidu.tieba.card.data.l.cXt = "c10711";
        com.baidu.tieba.card.data.l.cXu = "c10758";
        com.baidu.tieba.card.data.l.cXv = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.efG != null) {
            this.efG.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efH = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bMW = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
