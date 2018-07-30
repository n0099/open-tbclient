package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bHB;
    private ad<com.baidu.tieba.homepage.concern.b.b> dTj;
    private com.baidu.tieba.homepage.concern.view.f dTl;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqB;
    private com.baidu.adp.lib.e.b<TbImageView> dqC;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dqB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awa */
            public ConstrainImageLayout ig() {
                return new ConstrainImageLayout(b.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dqC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AR */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(d.C0140d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.dTj = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.dTl != null) {
                    an anVar = new an("c12407");
                    anVar.f(ImageViewerConfig.FORUM_ID, bVar.dbA.getFid());
                    anVar.af("tid", bVar.dbA.getTid());
                    anVar.r("obj_type", 1);
                    anVar.af(VideoPlayActivityConfig.OBJ_ID, bVar.dTI.getUserId());
                    if ((b.this.dTl.dUa == null || view.getId() != b.this.dTl.dUa.getId()) && (b.this.dTl.bHN.getHeaderImg() == null || view.getId() != b.this.dTl.bHN.getHeaderImg().getId())) {
                        if (b.this.dTl.dTY != null && view.getId() == b.this.dTl.dTY.getId()) {
                            anVar.r("obj_locate", 3);
                        } else {
                            anVar.r("obj_locate", 2);
                        }
                    } else {
                        anVar.r("obj_locate", 1);
                    }
                    anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aDs());
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dTl = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.dTl.setConstrainLayoutPool(this.dqB);
        this.dTl.setConstrainImagePool(this.dqC);
        if (this.aRF != null) {
            this.dTl.j(this.aRF);
        }
        this.dTl.b(this.dTj);
        this.dTl.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.dTl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.dTI == null || aVar == null || StringUtils.isNull(bVar.dTI.getName()) || StringUtils.isNull(bVar.dTI.getUserId())) {
            return null;
        }
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        aVar.ajz().a(bVar);
        aVar.ajz().b(this.dTj);
        aVar.ajz().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aiY().a(new an("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).af(VideoPlayActivityConfig.OBJ_ID, bVar.dTI.getUserId()).r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aDs()).af("tid", bVar.dbA.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }
}
