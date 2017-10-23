package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b>> {
    public BdUniqueId aPk;
    private x cVH;
    private com.baidu.tieba.homepage.concern.view.b cVS;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwr;
    private com.baidu.adp.lib.e.b<TbImageView> cws;
    private TbPageContext<?> mH;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cwr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajh */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(e.this.mH.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cws = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wF */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(e.this.mH.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.e.common_color_10264));
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
        this.cVH = new x<l>() { // from class: com.baidu.tieba.homepage.concern.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, l lVar) {
                if (view != null && e.this.cVS != null && e.this.cVS.getView() != null && lVar != null && lVar.Nd() != null && !StringUtils.isNull(lVar.Nd().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((e.this.cVS.getHeaderImg() != null && view.getId() == e.this.cVS.getHeaderImg().getId()) || (e.this.cVS.Xq() != null && view.getId() == e.this.cVS.Xq().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.ac("obj_type", lVar.XT());
                    akVar.ac("tid", lVar.threadData.getTid());
                    akVar.f("fid", lVar.threadData.getFid());
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> onCreateViewHolder(ViewGroup viewGroup) {
        this.cVS = new com.baidu.tieba.homepage.concern.view.b(this.mH);
        this.cVS.setConstrainLayoutPool(this.cwr);
        this.cVS.setConstrainImagePool(this.cws);
        if (this.aPk != null) {
            this.cVS.k(this.aPk);
        }
        return new com.baidu.tieba.card.a.a<>(this.cVS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> aVar) {
        if (lVar == null || aVar == null || aVar.Yn() == null) {
            return null;
        }
        lVar.hQ(i + 1);
        u.XN().a(lVar.jt("c12351"));
        aVar.Yn().a(lVar);
        aVar.Yn().b(this.cVH);
        return aVar.getView();
    }
}
