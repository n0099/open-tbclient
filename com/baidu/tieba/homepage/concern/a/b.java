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
    public BdUniqueId cnX;
    private ab<com.baidu.tieba.homepage.concern.b.b> eEv;
    private com.baidu.tieba.homepage.concern.view.f fGA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdW;
    private com.baidu.adp.lib.e.b<TbImageView> fdX;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.fdW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beI */
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
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
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
        this.eEv = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.fGA != null) {
                    am amVar = new am("c12407");
                    amVar.k(ImageViewerConfig.FORUM_ID, bVar.eNM.getFid());
                    amVar.bJ("tid", bVar.eNM.getTid());
                    amVar.T("obj_type", 1);
                    amVar.bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fHa.getUserId());
                    if ((b.this.fGA.fHr == null || view.getId() != b.this.fGA.fHr.getId()) && (b.this.fGA.dqu.getHeaderImg() == null || view.getId() != b.this.fGA.dqu.getHeaderImg().getId())) {
                        if (b.this.fGA.fHq != null && view.getId() == b.this.fGA.fHq.getId()) {
                            amVar.T("obj_locate", 3);
                        } else {
                            amVar.T("obj_locate", 2);
                        }
                    } else {
                        amVar.T("obj_locate", 1);
                    }
                    amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.bly());
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
        this.fGA = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.fGA.setConstrainLayoutPool(this.fdW);
        this.fGA.setConstrainImagePool(this.fdX);
        if (this.cnX != null) {
            this.fGA.k(this.cnX);
        }
        this.fGA.d(this.eEv);
        this.fGA.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.fGA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.fHa == null || aVar == null || StringUtils.isNull(bVar.fHa.getName()) || StringUtils.isNull(bVar.fHa.getUserId())) {
            return null;
        }
        if (aVar.aRi() instanceof com.baidu.tieba.a.e) {
            aVar.aRi().setPage(this.YA);
        }
        aVar.aRi().a(bVar);
        aVar.aRi().d(this.eEv);
        aVar.aRi().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        t.aQF().b(new am("c12353").k("uid", TbadkCoreApplication.getCurrentAccountId()).bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fHa.getUserId()).T("obj_type", 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.bly()).bJ("tid", bVar.eNM.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qL(String str) {
        this.YA = str;
    }
}
