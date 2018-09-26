package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b>> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dwN;
    private com.baidu.adp.lib.e.b<TbImageView> dwO;
    private com.baidu.tieba.homepage.concern.view.b eaD;
    private ad<k> eaE;
    private ad eav;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dwN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ayk */
            public ConstrainImageLayout jm() {
                return new ConstrainImageLayout(e.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void r(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout t(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dwO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ca */
            public TbImageView jm() {
                TbImageView tbImageView = new TbImageView(e.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void r(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView s(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView t(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.eav = new ad<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, k kVar) {
                if (view != null && e.this.eaD != null && e.this.eaD.getView() != null && kVar != null && kVar.UT() != null && !StringUtils.isNull(kVar.UT().getTid())) {
                    am amVar = new am("c12352");
                    if ((e.this.eaD.getHeaderImg() != null && view.getId() == e.this.eaD.getHeaderImg().getId()) || (e.this.eaD.akp() != null && view.getId() == e.this.eaD.akp().getId())) {
                        amVar.w("obj_locate", 1);
                    } else {
                        amVar.w("obj_locate", 2);
                    }
                    amVar.al("obj_type", kVar.akZ());
                    amVar.al("tid", kVar.threadData.getTid());
                    amVar.g(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.w("obj_param1", kVar.alc() ? 2 : 1);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.eaE = new ad<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, k kVar) {
                if (kVar != null && kVar.UT() != null) {
                    o.lA(kVar.UT().getTid());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.b bVar = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        bVar.setSingleImageRatio(0.75d);
        bVar.setConstrainLayoutPool(this.dwN);
        bVar.setConstrainImagePool(this.dwO);
        bVar.b(this.eaE);
        if (this.aUU != null) {
            bVar.j(this.aUU);
        }
        if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
            bVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.concern.a.e.4
                @Override // com.baidu.adp.widget.a.b
                public void k(int i, int i2, int i3) {
                    e.this.setPreloadSize(i, i2, i3);
                    if (e.this.isPreloadSizeReady(1) && e.this.isPreloadSizeReady(2)) {
                        bVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.eaD = bVar;
        return new com.baidu.tieba.card.a.a<>(this.eaD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> aVar) {
        if (kVar == null || aVar == null || aVar.aln() == null) {
            return null;
        }
        kVar.jv(i + 1);
        v.akM().a(kVar.lI("c12351"));
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        aVar.aln().a(kVar);
        aVar.aln().b(this.eav);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
