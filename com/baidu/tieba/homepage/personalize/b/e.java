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
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private x bkw;
    private com.baidu.tieba.card.l cTJ;
    private com.baidu.tieba.homepage.personalize.model.e cTK;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cnQ;
    private com.baidu.adp.lib.e.b<TbImageView> cnR;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkw = new x() { // from class: com.baidu.tieba.homepage.personalize.b.e.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.WB().cA(true);
                if (e.this.cTJ != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l) && e.this.cTK != null) {
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                    if (lVar.threadData != null) {
                        if ((view.getTag() instanceof String) && lVar.MF() != null && lVar.MF().getId() != null && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L));
                            e.this.cTK.a(com.baidu.adp.lib.g.b.d(lVar.MF().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.WF(), lVar.WH(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (e.this.cTJ.bHr == null || view.getId() != e.this.cTJ.bHr.getId()) {
                                if (view.getId() == e.this.cTJ.getView().getId()) {
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
        this.cnQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agV */
            public com.baidu.tbadk.widget.layout.b fT() {
                return new com.baidu.tbadk.widget.layout.b(e.this.alI.getPageActivity());
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
        this.cnR = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.b.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xm */
            public TbImageView fT() {
                TbImageView tbImageView = new TbImageView(e.this.alI.getPageActivity());
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
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cTJ = new com.baidu.tieba.card.l(this.alI);
        this.cTJ.setSingleImageRatio(0.75d);
        this.cTJ.setConstrainLayoutPool(this.cnQ);
        this.cTJ.setConstrainImagePool(this.cnR);
        this.cTJ.j(this.aOM);
        return new com.baidu.tieba.card.a.a(this.cTJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a aVar) {
        if (lVar == null || aVar == null || aVar.Xc() == null) {
            return null;
        }
        lVar.hv(i + 1);
        aVar.Xc().a((com.baidu.tieba.card.a) lVar);
        aVar.Xc().a(this.bkw);
        if (lVar.threadData != null && lVar.threadData.getTid() != null) {
            u.WB().a(new aj("c11003").aa("tid", lVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cTJ != null) {
            this.cTJ.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cTK = eVar;
    }
}
