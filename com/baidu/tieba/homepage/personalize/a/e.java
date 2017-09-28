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
    public BdUniqueId aPx;
    private x bmG;
    private com.baidu.tieba.card.l cZu;
    private com.baidu.tieba.homepage.personalize.model.e cZv;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwD;
    private com.baidu.adp.lib.e.b<TbImageView> cwE;
    private TbPageContext<?> mG;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bmG = new x() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.XR().cB(true);
                if (e.this.cZu != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l) && e.this.cZv != null) {
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                    if (lVar.threadData != null) {
                        if ((view.getTag() instanceof String) && lVar.Nj() != null && lVar.Nj().getId() != null && !com.baidu.tieba.homepage.personalize.f.bt(com.baidu.adp.lib.g.b.c(lVar.Nj().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bs(com.baidu.adp.lib.g.b.c(lVar.Nj().getTid(), 0L));
                            e.this.cZv.a(com.baidu.adp.lib.g.b.c(lVar.Nj().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.XU(), lVar.XW(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (e.this.cZu.bLi == null || view.getId() != e.this.cZu.bLi.getId()) {
                                if (view.getId() == e.this.cZu.getView().getId()) {
                                    TiebaStatic.log(new ak("c11004").ad("tid", lVar.threadData.getTid()));
                                    TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ad("tid", lVar.threadData.getId()));
                                    return;
                                }
                                TiebaStatic.log(new ak("c11004").ad("tid", lVar.threadData.getTid()));
                                return;
                            }
                            TiebaStatic.log(new ak("c10803").r("obj_locate", 7).ad("tid", lVar.threadData.getTid()));
                            return;
                        }
                        TiebaStatic.log(new ak("c11004").ad("tid", lVar.threadData.getTid()));
                    }
                }
            }
        };
        this.cwD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajm */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(e.this.mG.getPageActivity());
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
        this.cwE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(e.this.mG.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.e.common_color_10043));
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
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cZu = new com.baidu.tieba.card.l(this.mG);
        this.cZu.setSingleImageRatio(0.75d);
        this.cZu.setConstrainLayoutPool(this.cwD);
        this.cZu.setConstrainImagePool(this.cwE);
        this.cZu.k(this.aPx);
        return new com.baidu.tieba.card.a.a(this.cZu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a aVar) {
        if (lVar == null || aVar == null || aVar.Yr() == null) {
            return null;
        }
        lVar.hR(i + 1);
        aVar.Yr().a((com.baidu.tieba.card.a) lVar);
        aVar.Yr().b(this.bmG);
        if (lVar.threadData != null && lVar.threadData.getTid() != null) {
            u.XR().a(new ak("c11003").ad("tid", lVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cZu != null) {
            this.cZu.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cZv = eVar;
    }
}
