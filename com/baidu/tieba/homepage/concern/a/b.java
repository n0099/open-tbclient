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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f>> implements com.baidu.tieba.a.f {
    public BdUniqueId aQJ;
    private String bER;
    private ab<com.baidu.tieba.homepage.concern.b.b> dNe;
    private com.baidu.tieba.homepage.concern.view.f dNg;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dod;
    private com.baidu.adp.lib.e.b<TbImageView> doe;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dod = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avY */
            public ConstrainImageLayout mo9if() {
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
        this.doe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AI */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0141d.common_color_10043));
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
        this.dNe = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.dNg != null) {
                    am amVar = new am("c12407");
                    amVar.f(ImageViewerConfig.FORUM_ID, bVar.daI.getFid());
                    amVar.ah("tid", bVar.daI.getTid());
                    amVar.r("obj_type", 1);
                    amVar.ah(VideoPlayActivityConfig.OBJ_ID, bVar.dND.getUserId());
                    if ((b.this.dNg.dNW == null || view.getId() != b.this.dNg.dNW.getId()) && (b.this.dNg.bFd.getHeaderImg() == null || view.getId() != b.this.dNg.bFd.getHeaderImg().getId())) {
                        if (b.this.dNg.dNU != null && view.getId() == b.this.dNg.dNU.getId()) {
                            amVar.r("obj_locate", 3);
                        } else {
                            amVar.r("obj_locate", 2);
                        }
                    } else {
                        amVar.r("obj_locate", 1);
                    }
                    amVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCg());
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
        this.dNg = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.dNg.setConstrainLayoutPool(this.dod);
        this.dNg.setConstrainImagePool(this.doe);
        if (this.aQJ != null) {
            this.dNg.j(this.aQJ);
        }
        this.dNg.b(this.dNe);
        this.dNg.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.dNg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.dND == null || aVar == null || StringUtils.isNull(bVar.dND.getName()) || StringUtils.isNull(bVar.dND.getUserId())) {
            return null;
        }
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        aVar.ajG().a(bVar);
        aVar.ajG().b(this.dNe);
        aVar.ajG().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.ajh().a(new am("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ah(VideoPlayActivityConfig.OBJ_ID, bVar.dND.getUserId()).r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCg()).ah("tid", bVar.daI.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
