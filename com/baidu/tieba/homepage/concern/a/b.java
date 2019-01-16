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
    public BdUniqueId bes;
    private String cbk;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dQa;
    private com.baidu.adp.lib.e.b<TbImageView> dQb;
    private ad<com.baidu.tieba.homepage.concern.b.b> eub;
    private com.baidu.tieba.homepage.concern.view.f eud;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dQa = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDZ */
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
        this.dQb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: FH */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1));
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
        this.eub = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.eud != null) {
                    am amVar = new am("c12407");
                    amVar.i(ImageViewerConfig.FORUM_ID, bVar.dAv.getFid());
                    amVar.aB("tid", bVar.dAv.getTid());
                    amVar.y("obj_type", 1);
                    amVar.aB(VideoPlayActivityConfig.OBJ_ID, bVar.euC.getUserId());
                    if ((b.this.eud.euU == null || view.getId() != b.this.eud.euU.getId()) && (b.this.eud.cbw.getHeaderImg() == null || view.getId() != b.this.eud.cbw.getHeaderImg().getId())) {
                        if (b.this.eud.euS != null && view.getId() == b.this.eud.euS.getId()) {
                            amVar.y("obj_locate", 3);
                        } else {
                            amVar.y("obj_locate", 2);
                        }
                    } else {
                        amVar.y("obj_locate", 1);
                    }
                    amVar.y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aLw());
                    TiebaStatic.log(amVar);
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
        this.eud = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.eud.setConstrainLayoutPool(this.dQa);
        this.eud.setConstrainImagePool(this.dQb);
        if (this.bes != null) {
            this.eud.j(this.bes);
        }
        this.eud.b(this.eub);
        this.eud.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.eud);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.euC == null || aVar == null || StringUtils.isNull(bVar.euC.getName()) || StringUtils.isNull(bVar.euC.getUserId())) {
            return null;
        }
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbk);
        }
        aVar.arr().a(bVar);
        aVar.arr().b(this.eub);
        aVar.arr().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aqP().a(new am("c12353").i("uid", TbadkCoreApplication.getCurrentAccountId()).aB(VideoPlayActivityConfig.OBJ_ID, bVar.euC.getUserId()).y("obj_type", 1).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aLw()).aB("tid", bVar.dAv.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }
}
