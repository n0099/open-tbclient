package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    public BdUniqueId aPy;
    private x bok;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cEr;
    private com.baidu.adp.lib.e.b<TbImageView> cEs;
    private com.baidu.tieba.card.l dhR;
    private com.baidu.tieba.homepage.personalize.model.e dhS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bok = new x() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.aaj().cw(true);
                if (e.this.dhR != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l) && e.this.dhS != null) {
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                    if (lVar.blt != null) {
                        if ((view.getTag() instanceof String) && lVar.NA() != null && lVar.NA().getId() != null && !com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.NA().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(lVar.NA().getTid(), 0L));
                            e.this.dhS.a(com.baidu.adp.lib.g.b.c(lVar.NA().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aam(), lVar.aao(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (e.this.dhR.bSP == null || view.getId() != e.this.dhR.bSP.getId()) {
                                if (view.getId() == e.this.dhR.getView().getId()) {
                                    TiebaStatic.log(new ak("c11004").ac("tid", lVar.blt.getTid()));
                                    TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", lVar.blt.getId()));
                                    return;
                                }
                                TiebaStatic.log(new ak("c11004").ac("tid", lVar.blt.getTid()));
                                return;
                            }
                            TiebaStatic.log(new ak("c10803").r("obj_locate", 7).ac("tid", lVar.blt.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ac("tid", lVar.blt.getTid()));
                    }
                }
            }
        };
        this.cEr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alI */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(e.this.mPageContext.getPageActivity());
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
        this.cEs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(e.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0080d.common_color_10043));
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
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dhR = new com.baidu.tieba.card.l(this.mPageContext);
        this.dhR.setSingleImageRatio(0.75d);
        this.dhR.setConstrainLayoutPool(this.cEr);
        this.dhR.setConstrainImagePool(this.cEs);
        this.dhR.k(this.aPy);
        return new com.baidu.tieba.card.a.a(this.dhR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a aVar) {
        if (lVar == null || aVar == null || aVar.aaJ() == null) {
            return null;
        }
        lVar.ih(i + 1);
        aVar.aaJ().a((com.baidu.tieba.card.a) lVar);
        aVar.aaJ().b(this.bok);
        if (lVar.blt != null && lVar.blt.getTid() != null) {
            u.aaj().a(new ak("c11003").ac("tid", lVar.blt.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.dhR != null) {
            this.dhR.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhS = eVar;
    }
}
