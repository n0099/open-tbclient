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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.j;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b>> {
    public BdUniqueId bIy;
    public int cardShowType;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKG;
    private com.baidu.adp.lib.e.b<TbImageView> dKH;
    private v egm;
    private com.baidu.tieba.homepage.concern.view.b egv;
    private v<k> egw;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cardShowType = 0;
        this.dKG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axx */
            public com.baidu.tbadk.widget.layout.b nl() {
                return new com.baidu.tbadk.widget.layout.b(e.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b at(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b au(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.dKH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ey */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(e.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0141d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView at(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView au(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.egm = new v<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, k kVar) {
                if (view != null && e.this.egv != null && e.this.egv.getView() != null && kVar != null && kVar.WE() != null && !StringUtils.isNull(kVar.WE().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((e.this.egv.getHeaderImg() != null && view.getId() == e.this.egv.getHeaderImg().getId()) || (e.this.egv.akS() != null && view.getId() == e.this.egv.akS().getId())) {
                        akVar.s("obj_locate", 1);
                    } else {
                        akVar.s("obj_locate", 2);
                    }
                    akVar.ab("obj_type", kVar.alE());
                    akVar.ab("tid", kVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.egw = new v<k>() { // from class: com.baidu.tieba.homepage.concern.a.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, k kVar) {
                if (kVar != null && kVar.WE() != null) {
                    j.kr(kVar.WE().getTid());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> onCreateViewHolder(ViewGroup viewGroup) {
        this.egv = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        this.egv.setSingleImageRatio(0.75d);
        this.egv.setConstrainLayoutPool(this.dKG);
        this.egv.setConstrainImagePool(this.dKH);
        this.egv.b(this.egw);
        if (this.bIy != null) {
            this.egv.j(this.bIy);
        }
        return new com.baidu.tieba.card.a.a<>(this.egv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> aVar) {
        if (kVar == null || aVar == null || aVar.alY() == null) {
            return null;
        }
        kVar.lD(i + 1);
        r.alt().a(kVar.kz("c12351"));
        if (kVar.threadData != null) {
            kVar.threadData.aQp = this.cardShowType;
        }
        aVar.alY().a(kVar);
        aVar.alY().b(this.egm);
        return aVar.getView();
    }
}
