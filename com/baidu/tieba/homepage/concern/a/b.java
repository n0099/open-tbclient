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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f>> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dwN;
    private com.baidu.adp.lib.e.b<TbImageView> dwO;
    private ad<com.baidu.tieba.homepage.concern.b.b> eav;
    private com.baidu.tieba.homepage.concern.view.f eax;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dwN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ayk */
            public ConstrainImageLayout jm() {
                return new ConstrainImageLayout(b.this.mPageContext.getPageActivity());
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
        this.dwO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ca */
            public TbImageView jm() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
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
        this.eav = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.eax != null) {
                    am amVar = new am("c12407");
                    amVar.g(ImageViewerConfig.FORUM_ID, bVar.dhr.getFid());
                    amVar.al("tid", bVar.dhr.getTid());
                    amVar.w("obj_type", 1);
                    amVar.al(VideoPlayActivityConfig.OBJ_ID, bVar.eaW.getUserId());
                    if ((b.this.eax.ebo == null || view.getId() != b.this.eax.ebo.getId()) && (b.this.eax.bNC.getHeaderImg() == null || view.getId() != b.this.eax.bNC.getHeaderImg().getId())) {
                        if (b.this.eax.ebm != null && view.getId() == b.this.eax.ebm.getId()) {
                            amVar.w("obj_locate", 3);
                        } else {
                            amVar.w("obj_locate", 2);
                        }
                    } else {
                        amVar.w("obj_locate", 1);
                    }
                    amVar.w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aFC());
                    TiebaStatic.log(amVar);
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
        this.eax = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.eax.setConstrainLayoutPool(this.dwN);
        this.eax.setConstrainImagePool(this.dwO);
        if (this.aUU != null) {
            this.eax.j(this.aUU);
        }
        this.eax.b(this.eav);
        this.eax.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.eax);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.eaW == null || aVar == null || StringUtils.isNull(bVar.eaW.getName()) || StringUtils.isNull(bVar.eaW.getUserId())) {
            return null;
        }
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        aVar.aln().a(bVar);
        aVar.aln().b(this.eav);
        aVar.aln().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.akM().a(new am("c12353").g("uid", TbadkCoreApplication.getCurrentAccountId()).al(VideoPlayActivityConfig.OBJ_ID, bVar.eaW.getUserId()).w("obj_type", 1).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aFC()).al("tid", bVar.dhr.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
