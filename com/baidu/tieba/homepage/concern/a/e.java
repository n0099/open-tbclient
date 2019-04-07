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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b>> implements com.baidu.tieba.a.f {
    private String YA;
    public BdUniqueId cnZ;
    private ab eEg;
    private com.baidu.tieba.homepage.concern.view.b fGu;
    private ab<k> fGv;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdJ;
    private com.baidu.adp.lib.e.b<TbImageView> fdK;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fdJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beG */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(e.this.mPageContext.getPageActivity());
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
        this.fdK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aeY */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(e.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0277d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
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
        this.eEg = new ab<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (view != null && e.this.fGu != null && e.this.fGu.getView() != null && kVar != null && kVar.WO() != null && !StringUtils.isNull(kVar.WO().getTid())) {
                    am amVar = new am("c12352");
                    if ((e.this.fGu.getHeaderImg() != null && view.getId() == e.this.fGu.getHeaderImg().getId()) || (e.this.fGu.aQk() != null && view.getId() == e.this.fGu.aQk().getId())) {
                        amVar.T("obj_locate", 1);
                    } else {
                        amVar.T("obj_locate", 2);
                    }
                    amVar.bJ("obj_type", kVar.aQP());
                    amVar.bJ("tid", kVar.threadData.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.T("obj_param1", kVar.aQS() ? 2 : 1);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.fGv = new ab<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (kVar != null && kVar.WO() != null) {
                    n.tz(kVar.WO().getTid());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.b bVar = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        bVar.setSingleImageRatio(0.75d);
        bVar.setConstrainLayoutPool(this.fdJ);
        bVar.setConstrainImagePool(this.fdK);
        bVar.d(this.fGv);
        if (this.cnZ != null) {
            bVar.k(this.cnZ);
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
        this.fGu = bVar;
        return new com.baidu.tieba.card.a.a<>(this.fGu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> aVar) {
        if (kVar == null || aVar == null || aVar.aRg() == null) {
            return null;
        }
        kVar.oo(i + 1);
        t.aQD().b(kVar.tG("c12351"));
        if (aVar.aRg() instanceof com.baidu.tieba.a.e) {
            aVar.aRg().setPage(this.YA);
        }
        aVar.aRg().a(kVar);
        aVar.aRg().d(this.eEg);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }
}
