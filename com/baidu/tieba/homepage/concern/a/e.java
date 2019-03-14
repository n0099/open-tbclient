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
    public BdUniqueId cnX;
    private ab eEv;
    private com.baidu.tieba.homepage.concern.view.b fGG;
    private ab<k> fGH;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdW;
    private com.baidu.adp.lib.e.b<TbImageView> fdX;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fdW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beI */
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
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
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
        this.eEv = new ab<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (view != null && e.this.fGG != null && e.this.fGG.getView() != null && kVar != null && kVar.WR() != null && !StringUtils.isNull(kVar.WR().getTid())) {
                    am amVar = new am("c12352");
                    if ((e.this.fGG.getHeaderImg() != null && view.getId() == e.this.fGG.getHeaderImg().getId()) || (e.this.fGG.aQm() != null && view.getId() == e.this.fGG.aQm().getId())) {
                        amVar.T("obj_locate", 1);
                    } else {
                        amVar.T("obj_locate", 2);
                    }
                    amVar.bJ("obj_type", kVar.aQR());
                    amVar.bJ("tid", kVar.threadData.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.T("obj_param1", kVar.aQU() ? 2 : 1);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.fGH = new ab<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (kVar != null && kVar.WR() != null) {
                    n.tA(kVar.WR().getTid());
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
        bVar.setConstrainLayoutPool(this.fdW);
        bVar.setConstrainImagePool(this.fdX);
        bVar.d(this.fGH);
        if (this.cnX != null) {
            bVar.k(this.cnX);
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
        this.fGG = bVar;
        return new com.baidu.tieba.card.a.a<>(this.fGG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> aVar) {
        if (kVar == null || aVar == null || aVar.aRi() == null) {
            return null;
        }
        kVar.os(i + 1);
        t.aQF().b(kVar.tH("c12351"));
        if (aVar.aRi() instanceof com.baidu.tieba.a.e) {
            aVar.aRi().setPage(this.YA);
        }
        aVar.aRi().a(kVar);
        aVar.aRi().d(this.eEv);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qL(String str) {
        this.YA = str;
    }
}
