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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRC;
    private String bHB;
    private ad dTe;
    private com.baidu.tieba.homepage.concern.view.b dTm;
    private ad<k> dTn;
    private com.baidu.adp.lib.e.b<TbImageView> dqA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqz;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dqz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avZ */
            public ConstrainImageLayout ig() {
                return new ConstrainImageLayout(e.this.mPageContext.getPageActivity());
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
        this.dqA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AO */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(e.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(f.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds1));
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
        this.dTe = new ad<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, k kVar) {
                if (view != null && e.this.dTm != null && e.this.dTm.getView() != null && kVar != null && kVar.Tg() != null && !StringUtils.isNull(kVar.Tg().getTid())) {
                    an anVar = new an("c12352");
                    if ((e.this.dTm.getHeaderImg() != null && view.getId() == e.this.dTm.getHeaderImg().getId()) || (e.this.dTm.aiF() != null && view.getId() == e.this.dTm.aiF().getId())) {
                        anVar.r("obj_locate", 1);
                    } else {
                        anVar.r("obj_locate", 2);
                    }
                    anVar.ae("obj_type", kVar.ajo());
                    anVar.ae("tid", kVar.threadData.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    anVar.r("obj_param1", kVar.ajr() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.dTn = new ad<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, k kVar) {
                if (kVar != null && kVar.Tg() != null) {
                    o.kY(kVar.Tg().getTid());
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
        this.dTm = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        this.dTm.setSingleImageRatio(0.75d);
        this.dTm.setConstrainLayoutPool(this.dqz);
        this.dTm.setConstrainImagePool(this.dqA);
        this.dTm.b(this.dTn);
        if (this.aRC != null) {
            this.dTm.j(this.aRC);
        }
        return new com.baidu.tieba.card.a.a<>(this.dTm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> aVar) {
        if (kVar == null || aVar == null || aVar.ajC() == null) {
            return null;
        }
        kVar.iW(i + 1);
        v.ajb().a(kVar.lg("c12351"));
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        aVar.ajC().a(kVar);
        aVar.ajC().b(this.dTe);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
