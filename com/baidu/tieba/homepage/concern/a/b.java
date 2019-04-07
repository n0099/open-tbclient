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
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f>> implements com.baidu.tieba.a.f {
    private String YA;
    public BdUniqueId cnZ;
    private ab<com.baidu.tieba.homepage.concern.b.b> eEg;
    private com.baidu.tieba.homepage.concern.view.f fGo;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdJ;
    private com.baidu.adp.lib.e.b<TbImageView> fdK;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.fdJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beG */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.mPageContext.getPageActivity());
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
        this.fdK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aeY */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0277d.common_color_10043));
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
        this.eEg = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.fGo != null) {
                    am amVar = new am("c12407");
                    amVar.k(ImageViewerConfig.FORUM_ID, bVar.eNy.getFid());
                    amVar.bJ("tid", bVar.eNy.getTid());
                    amVar.T("obj_type", 1);
                    amVar.bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fGO.getUserId());
                    if ((b.this.fGo.fHf == null || view.getId() != b.this.fGo.fHf.getId()) && (b.this.fGo.dqx.getHeaderImg() == null || view.getId() != b.this.fGo.dqx.getHeaderImg().getId())) {
                        if (b.this.fGo.fHe != null && view.getId() == b.this.fGo.fHe.getId()) {
                            amVar.T("obj_locate", 3);
                        } else {
                            amVar.T("obj_locate", 2);
                        }
                    } else {
                        amVar.T("obj_locate", 1);
                    }
                    amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.blv());
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.fGo = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.fGo.setConstrainLayoutPool(this.fdJ);
        this.fGo.setConstrainImagePool(this.fdK);
        if (this.cnZ != null) {
            this.fGo.k(this.cnZ);
        }
        this.fGo.d(this.eEg);
        this.fGo.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.fGo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.fGO == null || aVar == null || StringUtils.isNull(bVar.fGO.getName()) || StringUtils.isNull(bVar.fGO.getUserId())) {
            return null;
        }
        if (aVar.aRg() instanceof com.baidu.tieba.a.e) {
            aVar.aRg().setPage(this.YA);
        }
        aVar.aRg().a(bVar);
        aVar.aRg().d(this.eEg);
        aVar.aRg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        t.aQD().b(new am("c12353").k("uid", TbadkCoreApplication.getCurrentAccountId()).bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fGO.getUserId()).T("obj_type", 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.blv()).bJ("tid", bVar.eNy.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }
}
