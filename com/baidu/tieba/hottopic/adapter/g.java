package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.n;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes15.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, a> {
    private boolean ajr;
    private BdUniqueId ePv;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hZl;
    private com.baidu.adp.lib.d.b<TbImageView> hZm;
    private aa<com.baidu.tieba.card.data.l> hyp;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = false;
        this.hZl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.hottopic.adapter.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: coB */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(g.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.hZm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.hottopic.adapter.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(g.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.hyp = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.hottopic.adapter.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid()) && !StringUtils.isNull(lVar.ccl())) {
                    String topicName = ((HotTopicActivity) g.this.mPageContext.getOrignalPage()).getTopicName();
                    String czJ = ((HotTopicActivity) g.this.mPageContext.getOrignalPage()).czJ();
                    bw bce = lVar.bce();
                    bce.nf(5);
                    if ("c10814".equals(lVar.ccl())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dD("tid", bce.getId()).dD("obj_name", topicName).dD("topic_id", czJ));
                    } else if ("c10816".equals(lVar.ccl())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dD("post_id", bce.getTid()).dD("obj_name", topicName).dD("topic_id", czJ));
                    }
                    if (g.this.mPageContext != null && (g.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                        ((HotTopicActivity) g.this.mPageContext.getOrignalPage()).t(lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ePv = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public a b(ViewGroup viewGroup) {
        n nVar = new n(this.mPageContext);
        nVar.p(this.ePv);
        nVar.setConstrainImagePool(this.hZm);
        nVar.setConstrainLayoutPool(this.hZl);
        nVar.ng(false);
        nVar.setFromCDN(this.ajr);
        nVar.currentPageType = 0;
        if (nVar.gja != null) {
            nVar.gja.etW = 0;
        }
        return new a(nVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, a aVar) {
        aVar.iXp.a(lVar);
        aVar.iXp.c(this.hyp);
        aVar.iXp.nf(!(getItem(i + 1) instanceof com.baidu.tieba.hottopic.data.n));
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a extends af.a {
        public n iXp;

        public a(n nVar) {
            super(nVar.getView());
            this.iXp = nVar;
        }
    }
}
