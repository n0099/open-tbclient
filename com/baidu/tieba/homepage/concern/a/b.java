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
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f>> {
    public BdUniqueId aSy;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNG;
    private com.baidu.adp.lib.e.b<TbImageView> cNH;
    private v<com.baidu.tieba.homepage.concern.b.b> dof;
    private com.baidu.tieba.homepage.concern.view.f doh;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cNG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anL */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(b.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cNH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0096d.common_color_10043));
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
        this.dof = new v<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.doh != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.cBz.getFid());
                    akVar.ac("tid", bVar.cBz.getTid());
                    akVar.r("obj_type", 1);
                    akVar.ac("obj_id", bVar.doG.getUserId());
                    if ((b.this.doh.doX == null || view.getId() != b.this.doh.doX.getId()) && (b.this.doh.bvE.getHeaderImg() == null || view.getId() != b.this.doh.bvE.getHeaderImg().getId())) {
                        if (b.this.doh.doU != null && view.getId() == b.this.doh.doU.getId()) {
                            akVar.r("obj_locate", 3);
                        } else {
                            akVar.r("obj_locate", 2);
                        }
                    } else {
                        akVar.r("obj_locate", 1);
                    }
                    akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.atM());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.doh = new com.baidu.tieba.homepage.concern.view.f(this.mPageContext);
        this.doh.setConstrainLayoutPool(this.cNG);
        this.doh.setConstrainImagePool(this.cNH);
        if (this.aSy != null) {
            this.doh.k(this.aSy);
        }
        this.doh.b(this.dof);
        this.doh.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.doh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.doG == null || aVar == null || StringUtils.isNull(bVar.doG.getName()) || StringUtils.isNull(bVar.doG.getUserId())) {
            return null;
        }
        aVar.acB().a(bVar);
        aVar.acB().b(this.dof);
        aVar.acB().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        s.abW().a(new ak("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ac("obj_id", bVar.doG.getUserId()).r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.atM()).ac("tid", bVar.cBz.getTid()));
        return aVar.getView();
    }
}
