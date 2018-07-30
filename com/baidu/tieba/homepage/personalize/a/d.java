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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.w;
import com.baidu.tieba.card.y;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<y>> {
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqB;
    private com.baidu.adp.lib.e.b<TbImageView> dqC;
    private ad dua;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dua = new ad() { // from class: com.baidu.tieba.homepage.personalize.a.d.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if ((bVar instanceof bb) && (obj instanceof w)) {
                    TiebaStatic.log(d.this.a("c13024", (bb) bVar, (w) obj));
                }
            }
        };
        this.dqB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awa */
            public ConstrainImageLayout ig() {
                return new ConstrainImageLayout(d.this.mPageContext.getPageActivity());
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
        this.dqC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AR */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(d.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(d.C0140d.common_color_10043));
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
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<y> onCreateViewHolder(ViewGroup viewGroup) {
        y yVar = new y(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<y> aVar = new com.baidu.tieba.card.a.a<>(yVar);
        yVar.setConstrainImagePool(this.dqC);
        yVar.setConstrainLayoutPool(this.dqB);
        yVar.b(this.dua);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<y> aVar) {
        if (aVar == null || aVar.ajz() == null) {
            return null;
        }
        if (kVar != null && kVar.Td() != null) {
            w wVar = new w();
            wVar.btR = i + 1;
            wVar.source = kVar.getSource();
            wVar.weight = kVar.getWeight();
            wVar.cAI = kVar.ajk();
            v.aiY().a(a("c13023", kVar.Td(), wVar));
            aVar.ajz().a(wVar);
            aVar.ajz().b(this.dua);
            aVar.ajz().a(kVar.Td());
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public an a(String str, bb bbVar, w wVar) {
        if (StringUtils.isNull(str) || bbVar == null || wVar == null) {
            return null;
        }
        an af = new an(str).af(ImageViewerConfig.FORUM_ID, String.valueOf(bbVar.getFid())).af("tid", String.valueOf(bbVar.getTid())).r("obj_locate", wVar.btR).af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, wVar.source).af("obj_param1", wVar.weight).af("ab_tag", wVar.cAI).af("obj_param3", o.aiP());
        if (bbVar.vk() != null) {
            af.af("obj_name", bbVar.vk().getName_show());
            return af;
        }
        return af;
    }
}
