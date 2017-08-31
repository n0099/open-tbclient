package com.baidu.tieba.homepage.personalize.b;

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
    public BdUniqueId aOx;
    private x bkW;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cvd;
    private com.baidu.adp.lib.e.b<TbImageView> cve;
    private com.baidu.tieba.card.l dcl;
    private com.baidu.tieba.homepage.personalize.model.e dcm;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkW = new x() { // from class: com.baidu.tieba.homepage.personalize.b.e.1
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                u.XY().cC(true);
                if (e.this.dcl != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l) && e.this.dcm != null) {
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                    if (lVar.threadData != null) {
                        if ((view.getTag() instanceof String) && lVar.MR() != null && lVar.MR().getId() != null && !com.baidu.tieba.homepage.personalize.f.bw(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.f.bv(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L));
                            e.this.dcm.a(com.baidu.adp.lib.g.b.c(lVar.MR().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.Yb(), lVar.Yd(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        if (!(view instanceof TbImageView)) {
                            if (e.this.dcl.bKV == null || view.getId() != e.this.dcl.bKV.getId()) {
                                if (view.getId() == e.this.dcl.getView().getId()) {
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
        this.cvd = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.personalize.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aiX */
            public com.baidu.tbadk.widget.layout.b fJ() {
                return new com.baidu.tbadk.widget.layout.b(e.this.mF.getPageActivity());
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
        this.cve = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.b.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xo */
            public TbImageView fJ() {
                TbImageView tbImageView = new TbImageView(e.this.mF.getPageActivity());
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
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dcl = new com.baidu.tieba.card.l(this.mF);
        this.dcl.setSingleImageRatio(0.75d);
        this.dcl.setConstrainLayoutPool(this.cvd);
        this.dcl.setConstrainImagePool(this.cve);
        this.dcl.l(this.aOx);
        return new com.baidu.tieba.card.a.a(this.dcl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a aVar) {
        if (lVar == null || aVar == null || aVar.Yy() == null) {
            return null;
        }
        lVar.hH(i + 1);
        aVar.Yy().a((com.baidu.tieba.card.a) lVar);
        aVar.Yy().b(this.bkW);
        if (lVar.threadData != null && lVar.threadData.getTid() != null) {
            u.XY().a(new ak("c11003").ad("tid", lVar.threadData.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.dcl != null) {
            this.dcl.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dcm = eVar;
    }
}
