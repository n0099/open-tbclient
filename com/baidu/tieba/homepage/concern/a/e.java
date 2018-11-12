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
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b>> implements com.baidu.tieba.a.f {
    private String bWE;
    public BdUniqueId bag;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dGe;
    private com.baidu.adp.lib.e.b<TbImageView> dGf;
    private ad ejJ;
    private com.baidu.tieba.homepage.concern.view.b ejR;
    private ad<k> ejS;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dGe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBd */
            public ConstrainImageLayout jz() {
                return new ConstrainImageLayout(e.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout v(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout w(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dGf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ep */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(e.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView v(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView w(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.ejJ = new ad<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, k kVar) {
                if (view != null && e.this.ejR != null && e.this.ejR.getView() != null && kVar != null && kVar.YL() != null && !StringUtils.isNull(kVar.YL().getTid())) {
                    am amVar = new am("c12352");
                    if ((e.this.ejR.getHeaderImg() != null && view.getId() == e.this.ejR.getHeaderImg().getId()) || (e.this.ejR.ant() != null && view.getId() == e.this.ejR.ant().getId())) {
                        amVar.x("obj_locate", 1);
                    } else {
                        amVar.x("obj_locate", 2);
                    }
                    amVar.ax("obj_type", kVar.aod());
                    amVar.ax("tid", kVar.threadData.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.x("obj_param1", kVar.aog() ? 2 : 1);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.ejS = new ad<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, k kVar) {
                if (kVar != null && kVar.YL() != null) {
                    o.me(kVar.YL().getTid());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.b bVar = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        bVar.setSingleImageRatio(0.75d);
        bVar.setConstrainLayoutPool(this.dGe);
        bVar.setConstrainImagePool(this.dGf);
        bVar.b(this.ejS);
        if (this.bag != null) {
            bVar.j(this.bag);
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
        this.ejR = bVar;
        return new com.baidu.tieba.card.a.a<>(this.ejR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> aVar) {
        if (kVar == null || aVar == null || aVar.aor() == null) {
            return null;
        }
        kVar.km(i + 1);
        v.anQ().a(kVar.ml("c12351"));
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        aVar.aor().a(kVar);
        aVar.aor().b(this.ejJ);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
