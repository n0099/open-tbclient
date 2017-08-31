package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f>> {
    public BdUniqueId aOx;
    private x<com.baidu.tieba.homepage.concern.b.b> cYE;
    private com.baidu.tieba.homepage.concern.view.f cYG;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cvd;
    private com.baidu.adp.lib.e.b<TbImageView> cve;
    private TbPageContext<?> mF;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cvd = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aiX */
            public com.baidu.tbadk.widget.layout.b fJ() {
                return new com.baidu.tbadk.widget.layout.b(b.this.mF.getPageActivity());
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
        this.cve = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xo */
            public TbImageView fJ() {
                TbImageView tbImageView = new TbImageView(b.this.mF.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.e.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
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
        this.cYE = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && b.this.cYG != null) {
                    ak akVar = new ak("c12407");
                    akVar.f("fid", bVar.bdq.getFid());
                    akVar.ad("tid", bVar.bdq.getTid());
                    akVar.r("obj_type", 1);
                    akVar.ad("obj_id", bVar.cYY.getUserId());
                    if ((b.this.cYG.cZp == null || view.getId() != b.this.cYG.cZp.getId()) && (b.this.cYG.cRB == null || view.getId() != b.this.cYG.cRB.getId())) {
                        if (b.this.cYG.cZn != null && view.getId() == b.this.cYG.cZn.getId()) {
                            akVar.r("obj_locate", 3);
                        } else {
                            akVar.r("obj_locate", 2);
                        }
                    } else {
                        akVar.r("obj_locate", 1);
                    }
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cYG = new com.baidu.tieba.homepage.concern.view.f(this.mF);
        this.cYG.setConstrainLayoutPool(this.cvd);
        this.cYG.setConstrainImagePool(this.cve);
        if (this.aOx != null) {
            this.cYG.l(this.aOx);
        }
        this.cYG.b(this.cYE);
        this.cYG.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a(this.cYG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.f> aVar) {
        if (bVar.cYY == null || aVar == null || StringUtils.isNull(bVar.cYY.getName()) || StringUtils.isNull(bVar.cYY.getUserId())) {
            return null;
        }
        aVar.Yy().a(bVar);
        aVar.Yy().b(this.cYE);
        aVar.Yy().d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        u.XY().a(new ak("c12353").f(SapiAccountManager.SESSION_UID, bVar.cYY.getId()));
        return aVar.getView();
    }
}
