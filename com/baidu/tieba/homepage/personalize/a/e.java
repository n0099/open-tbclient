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
    public BdUniqueId aPq;
    private x bob;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cDY;
    private com.baidu.adp.lib.e.b<TbImageView> cDZ;
    private com.baidu.tieba.card.l dhx;
    private com.baidu.tieba.homepage.personalize.model.e dhy;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bob = new x() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.ZX().cv(true);
                if (e.this.dhx != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l) && e.this.dhy != null) {
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                    if (lVar.blk != null) {
                        if ((view.getTag() instanceof String) && lVar.Np() != null && lVar.Np().getId() != null && !com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.Np().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bu(com.baidu.adp.lib.g.b.c(lVar.Np().getTid(), 0L));
                            e.this.dhy.a(com.baidu.adp.lib.g.b.c(lVar.Np().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aaa(), lVar.aac(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (e.this.dhx.bSC == null || view.getId() != e.this.dhx.bSC.getId()) {
                                if (view.getId() == e.this.dhx.getView().getId()) {
                                    TiebaStatic.log(new ak("c11004").ac("tid", lVar.blk.getTid()));
                                    TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", lVar.blk.getId()));
                                    return;
                                }
                                TiebaStatic.log(new ak("c11004").ac("tid", lVar.blk.getTid()));
                                return;
                            }
                            TiebaStatic.log(new ak("c10803").r("obj_locate", 7).ac("tid", lVar.blk.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ac("tid", lVar.blk.getTid()));
                    }
                }
            }
        };
        this.cDY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alu */
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
        this.cDZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.e.3
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
        this.dhx = new com.baidu.tieba.card.l(this.mPageContext);
        this.dhx.setSingleImageRatio(0.75d);
        this.dhx.setConstrainLayoutPool(this.cDY);
        this.dhx.setConstrainImagePool(this.cDZ);
        this.dhx.k(this.aPq);
        return new com.baidu.tieba.card.a.a(this.dhx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a aVar) {
        if (lVar == null || aVar == null || aVar.aax() == null) {
            return null;
        }
        lVar.ij(i + 1);
        aVar.aax().a((com.baidu.tieba.card.a) lVar);
        aVar.aax().b(this.bob);
        if (lVar.blk != null && lVar.blk.getTid() != null) {
            u.ZX().a(new ak("c11003").ac("tid", lVar.blk.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.dhx != null) {
            this.dhx.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhy = eVar;
    }
}
