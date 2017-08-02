package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    public BdUniqueId aNy;
    private TbPageContext<?> ako;
    private x bjm;
    private com.baidu.tieba.card.l cSq;
    private com.baidu.tieba.homepage.personalize.model.e cSr;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cmE;
    private com.baidu.adp.lib.e.b<TbImageView> cmF;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bjm = new x() { // from class: com.baidu.tieba.homepage.personalize.b.e.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.Ww().cA(true);
                if (e.this.cSq != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l) && e.this.cSr != null) {
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                    if (lVar.threadData != null) {
                        if ((view.getTag() instanceof String) && lVar.MA() != null && lVar.MA().getId() != null && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(lVar.MA().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.MA().getTid(), 0L));
                            e.this.cSr.a(com.baidu.adp.lib.g.b.c(lVar.MA().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.WA(), lVar.WC(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (e.this.cSq.bGh == null || view.getId() != e.this.cSq.bGh.getId()) {
                                if (view.getId() == e.this.cSq.getView().getId()) {
                                    TiebaStatic.log(new aj("c11004").aa("tid", lVar.threadData.getTid()));
                                    TiebaStatic.log(new aj("c10806").r("obj_locate", 1).aa("tid", lVar.threadData.getId()));
                                    return;
                                }
                                TiebaStatic.log(new aj("c11004").aa("tid", lVar.threadData.getTid()));
                                return;
                            }
                            TiebaStatic.log(new aj("c10803").r("obj_locate", 7).aa("tid", lVar.threadData.getTid()));
                            return;
                        }
                        TiebaStatic.log(new aj("c11004").aa("tid", lVar.threadData.getTid()));
                    }
                }
            }
        };
        this.cmE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agO */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(e.this.ako.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void o(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b q(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cmF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.b.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xe */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(e.this.ako.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ai.getColor(d.e.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView p(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.ako = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cSq = new com.baidu.tieba.card.l(this.ako);
        this.cSq.setSingleImageRatio(0.75d);
        this.cSq.setConstrainLayoutPool(this.cmE);
        this.cSq.setConstrainImagePool(this.cmF);
        this.cSq.j(this.aNy);
        return new com.baidu.tieba.card.a.a(this.cSq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a aVar) {
        if (lVar == null || aVar == null || aVar.WX() == null) {
            return null;
        }
        lVar.hu(i + 1);
        aVar.WX().a((com.baidu.tieba.card.a) lVar);
        aVar.WX().a(this.bjm);
        if (lVar.threadData != null && lVar.threadData.getTid() != null) {
            u.Ww().a(new aj("c11003").aa("tid", lVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cSq != null) {
            this.cSq.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cSr = eVar;
    }
}
