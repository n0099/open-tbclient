package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.w;
import com.baidu.tieba.card.y;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<y>> {
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dMD;
    private com.baidu.adp.lib.e.b<TbImageView> dME;
    private ad dQk;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQk = new ad() { // from class: com.baidu.tieba.homepage.personalize.a.d.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if ((bVar instanceof bb) && (obj instanceof w)) {
                    TiebaStatic.log(d.this.a("c13024", (bb) bVar, (w) obj));
                }
            }
        };
        this.dMD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aCN */
            public ConstrainImageLayout jz() {
                return new ConstrainImageLayout(d.this.mPageContext.getPageActivity());
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
        this.dME = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ft */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(d.this.mPageContext.getPageActivity());
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
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<y> onCreateViewHolder(ViewGroup viewGroup) {
        y yVar = new y(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<y> aVar = new com.baidu.tieba.card.a.a<>(yVar);
        yVar.setConstrainImagePool(this.dME);
        yVar.setConstrainLayoutPool(this.dMD);
        yVar.b(this.dQk);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<y> aVar) {
        if (aVar == null || aVar.aqe() == null) {
            return null;
        }
        if (kVar != null && kVar.ZR() != null) {
            w wVar = new w();
            wVar.bMR = i + 1;
            wVar.source = kVar.getSource();
            wVar.weight = kVar.getWeight();
            wVar.cWE = kVar.apP();
            v.apD().a(a("c13023", kVar.ZR(), wVar));
            aVar.aqe().a(wVar);
            aVar.aqe().b(this.dQk);
            aVar.aqe().a(kVar.ZR());
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public am a(String str, bb bbVar, w wVar) {
        if (StringUtils.isNull(str) || bbVar == null || wVar == null) {
            return null;
        }
        am aA = new am(str).aA(ImageViewerConfig.FORUM_ID, String.valueOf(bbVar.getFid())).aA("tid", String.valueOf(bbVar.getTid())).x("obj_locate", wVar.bMR).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, wVar.source).aA("obj_param1", wVar.weight).aA("ab_tag", wVar.cWE).aA("obj_param3", o.apu());
        if (bbVar.zG() != null) {
            aA.aA("obj_name", bbVar.zG().getName_show());
            return aA;
        }
        return aA;
    }
}
