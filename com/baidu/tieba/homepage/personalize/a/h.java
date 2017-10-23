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
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n>> {
    public BdUniqueId aPk;
    private c.a aVu;
    private x cVH;
    private com.baidu.tieba.card.n cZo;
    private com.baidu.tieba.homepage.personalize.model.e cZp;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwr;
    private com.baidu.adp.lib.e.b<TbImageView> cws;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVu = null;
        this.cwr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajh */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(h.this.mH.getPageActivity());
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
        this.cws = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wF */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(h.this.mH.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.e.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
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
        this.cVH = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.XN().cA(true);
                if (view != null && h.this.cZo != null && h.this.cZo.getView() != null && h.this.cZp != null && lVar != null && lVar.Nd() != null && !StringUtils.isNull(lVar.Nd().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(lVar.Nd().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bt(com.baidu.adp.lib.g.b.c(lVar.Nd().getTid(), 0L));
                        h.this.cZp.a(com.baidu.adp.lib.g.b.c(lVar.Nd().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.XQ(), lVar.XS(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view.getId() != h.this.cZo.getView().getId()) {
                        if (h.this.cZo.bLf == null || view.getId() != h.this.cZo.bLf.getId()) {
                            if (h.this.cZo.getHeaderImg() == null || view.getId() != h.this.cZo.getHeaderImg().getId()) {
                                if (h.this.cZo.Xq() == null || view.getId() != h.this.cZo.Xq().getId()) {
                                    if (h.this.cZo.bmV != null && h.this.cZo.bmV.getBarNameTv() != null && view.getId() == h.this.cZo.bmV.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.Yb());
                                        return;
                                    } else if (!(view instanceof TbImageView)) {
                                        if (h.this.cZo.Xp() != null && view.getId() == h.this.cZo.Xp().getId()) {
                                            TiebaStatic.log(lVar.jw("c10760"));
                                            return;
                                        }
                                        return;
                                    } else {
                                        TiebaStatic.log(lVar.Yd());
                                        return;
                                    }
                                }
                                TiebaStatic.log(lVar.Yc());
                                return;
                            }
                            TiebaStatic.log(lVar.Yc());
                            return;
                        }
                        TiebaStatic.log(lVar.Ye());
                        return;
                    }
                    TiebaStatic.log(lVar.Ya());
                }
            }
        };
        this.mH = tbPageContext;
        apE();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> onCreateViewHolder(ViewGroup viewGroup) {
        this.cZo = new com.baidu.tieba.card.n(this.mH);
        this.cZo.setConstrainLayoutPool(this.cwr);
        this.cZo.setConstrainImagePool(this.cws);
        this.cZo.k(this.aPk);
        return new com.baidu.tieba.card.a.a<>(this.cZo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.n> aVar) {
        if (lVar == null || aVar == null || aVar.Yn() == null) {
            return null;
        }
        lVar.hQ(i + 1);
        u.XN().a(lVar.XZ());
        aVar.Yn().a(lVar);
        aVar.Yn().b(this.cVH);
        aVar.Yn().a(this.aVu);
        return aVar.getView();
    }

    private void apE() {
        com.baidu.tieba.card.data.l.bNh = "c10705";
        com.baidu.tieba.card.data.l.bNi = "c10730";
        com.baidu.tieba.card.data.l.bNj = "c10731";
        com.baidu.tieba.card.data.l.bNk = "c10704";
        com.baidu.tieba.card.data.l.bNl = "c10755";
        com.baidu.tieba.card.data.l.bNm = "c10710";
        com.baidu.tieba.card.data.l.bNn = "c10736";
        com.baidu.tieba.card.data.l.bNo = "c10737";
        com.baidu.tieba.card.data.l.bNp = "c10711";
        com.baidu.tieba.card.data.l.bNq = "c10758";
        com.baidu.tieba.card.data.l.bNr = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cZo != null) {
            this.cZo.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cZp = eVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aVu = aVar;
    }
}
