package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    private String GC;
    public BdUniqueId cKf;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fAu;
    private com.baidu.adp.lib.e.b<TbImageView> fAv;
    private ab fdI;
    private com.baidu.tieba.homepage.concern.view.a geH;
    private ab<com.baidu.tieba.card.data.k> geI;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fAu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bmb */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(h.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.fAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoe */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(h.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.fdI = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && h.this.geH != null && h.this.geH.getView() != null && kVar != null && kVar.agI() != null && !StringUtils.isNull(kVar.agI().getTid())) {
                    an anVar = new an("c12352");
                    if ((h.this.geH.getHeaderImg() != null && view.getId() == h.this.geH.getHeaderImg().getId()) || (h.this.geH.bac() != null && view.getId() == h.this.geH.bac().getId())) {
                        anVar.O("obj_locate", 1);
                    } else {
                        anVar.O("obj_locate", 2);
                    }
                    anVar.bS("obj_type", kVar.baI());
                    anVar.bS("tid", kVar.cbq.getTid());
                    anVar.p("fid", kVar.cbq.getFid());
                    anVar.bS("obj_source", "1");
                    anVar.O("obj_param1", kVar.baL() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.geI = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (kVar != null && kVar.agI() != null) {
                    com.baidu.tieba.card.n.uz(kVar.agI().getTid());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> b(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.a aVar = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        aVar.setSingleImageRatio(0.75d);
        aVar.setConstrainLayoutPool(this.fAu);
        aVar.setConstrainImagePool(this.fAv);
        aVar.d(this.geI);
        if (this.cKf != null) {
            aVar.l(this.cKf);
        }
        if (!ab(1) || !ab(2)) {
            aVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.concern.a.h.4
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    h.this.g(i, i2, i3);
                    if (h.this.ab(1) && h.this.ab(2)) {
                        aVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.geH = aVar;
        return new com.baidu.tieba.card.a.a<>(this.geH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.baZ() == null) {
            return null;
        }
        kVar.oP(i + 1);
        t.baw().c(kVar.uF("c12351"));
        if (aVar.baZ() instanceof com.baidu.tieba.a.e) {
            aVar.baZ().setPage(this.GC);
        }
        aVar.baZ().a(kVar);
        aVar.baZ().d(this.fdI);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }
}
