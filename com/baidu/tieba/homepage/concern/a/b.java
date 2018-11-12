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
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f>> implements com.baidu.tieba.a.f {
    private String bWE;
    public BdUniqueId bag;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dGe;
    private com.baidu.adp.lib.e.b<TbImageView> dGf;
    private ad<com.baidu.tieba.homepage.concern.b.b> ejJ;
    private com.baidu.tieba.homepage.concern.view.f ejL;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dGe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBd */
            public ConstrainImageLayout jz() {
                return new ConstrainImageLayout(b.this.mPageContext.getPageActivity());
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
        this.dGf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ep */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
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
        this.ejJ = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.ejL != null) {
                    am amVar = new am("c12407");
                    amVar.h(ImageViewerConfig.FORUM_ID, bVar.dqz.getFid());
                    amVar.ax("tid", bVar.dqz.getTid());
                    amVar.x("obj_type", 1);
                    amVar.ax(VideoPlayActivityConfig.OBJ_ID, bVar.ekk.getUserId());
                    if ((b.this.ejL.ekC == null || view.getId() != b.this.ejL.ekC.getId()) && (b.this.ejL.bWQ.getHeaderImg() == null || view.getId() != b.this.ejL.bWQ.getHeaderImg().getId())) {
                        if (b.this.ejL.ekA != null && view.getId() == b.this.ejL.ekA.getId()) {
                            amVar.x("obj_locate", 3);
                        } else {
                            amVar.x("obj_locate", 2);
                        }
                    } else {
                        amVar.x("obj_locate", 1);
                    }
                    amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aIs());
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.ejL = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.ejL.setConstrainLayoutPool(this.dGe);
        this.ejL.setConstrainImagePool(this.dGf);
        if (this.bag != null) {
            this.ejL.j(this.bag);
        }
        this.ejL.b(this.ejJ);
        this.ejL.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.ejL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.ekk == null || aVar == null || StringUtils.isNull(bVar.ekk.getName()) || StringUtils.isNull(bVar.ekk.getUserId())) {
            return null;
        }
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        aVar.aor().a(bVar);
        aVar.aor().b(this.ejJ);
        aVar.aor().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.anQ().a(new am("c12353").h("uid", TbadkCoreApplication.getCurrentAccountId()).ax(VideoPlayActivityConfig.OBJ_ID, bVar.ekk.getUserId()).x("obj_type", 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aIs()).ax("tid", bVar.dqz.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
