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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTs;
    private String bwO;
    private ab<com.baidu.tieba.homepage.concern.b.b> dBW;
    private com.baidu.tieba.homepage.concern.view.f dBY;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> deO;
    private com.baidu.adp.lib.e.b<TbImageView> deP;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.deO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: arT */
            public ConstrainImageLayout fo() {
                return new ConstrainImageLayout(b.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout o(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout p(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.deP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xh */
            public TbImageView fo() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
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
        this.dBW = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view2 != null && b.this.dBY != null) {
                    al alVar = new al("c12407");
                    alVar.f(ImageViewerConfig.FORUM_ID, bVar.cRB.getFid());
                    alVar.ac("tid", bVar.cRB.getTid());
                    alVar.r("obj_type", 1);
                    alVar.ac(VideoPlayActivityConfig.OBJ_ID, bVar.dCx.getUserId());
                    if ((b.this.dBY.dCO == null || view2.getId() != b.this.dBY.dCO.getId()) && (b.this.dBY.bxa.getHeaderImg() == null || view2.getId() != b.this.dBY.bxa.getHeaderImg().getId())) {
                        if (b.this.dBY.dCM != null && view2.getId() == b.this.dBY.dCM.getId()) {
                            alVar.r("obj_locate", 3);
                        } else {
                            alVar.r("obj_locate", 2);
                        }
                    } else {
                        alVar.r("obj_locate", 1);
                    }
                    alVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.axn());
                    TiebaStatic.log(alVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dBY = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.dBY.setConstrainLayoutPool(this.deO);
        this.dBY.setConstrainImagePool(this.deP);
        if (this.aTs != null) {
            this.dBY.j(this.aTs);
        }
        this.dBY.b(this.dBW);
        this.dBY.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.dBY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.dCx == null || aVar == null || StringUtils.isNull(bVar.dCx.getName()) || StringUtils.isNull(bVar.dCx.getUserId())) {
            return null;
        }
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bwO);
        }
        aVar.afY().a(bVar);
        aVar.afY().b(this.dBW);
        aVar.afY().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.afy().a(new al("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ac(VideoPlayActivityConfig.OBJ_ID, bVar.dCx.getUserId()).r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.axn()).ac("tid", bVar.cRB.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void hZ(String str) {
        this.bwO = str;
    }
}
