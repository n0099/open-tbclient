package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.n;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes8.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    private boolean aik;
    private BdUniqueId eyE;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hFi;
    private com.baidu.adp.lib.d.b<TbImageView> hFj;
    private aa<com.baidu.tieba.card.data.k> hfO;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = false;
        this.hFi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.hottopic.adapter.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cay */
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
        this.hFj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.hottopic.adapter.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aYG */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(g.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(an.getColor(R.color.common_color_10043));
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
        this.hfO = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.hottopic.adapter.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (kVar != null && kVar.aPS() != null && !StringUtils.isNull(kVar.aPS().getTid()) && !StringUtils.isNull(kVar.bON())) {
                    String topicName = ((HotTopicActivity) g.this.mPageContext.getOrignalPage()).getTopicName();
                    String clp = ((HotTopicActivity) g.this.mPageContext.getOrignalPage()).clp();
                    bu aPS = kVar.aPS();
                    aPS.kF(5);
                    if ("c10814".equals(kVar.bON())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ao("c10814").dk("tid", aPS.getId()).dk("obj_name", topicName).dk("topic_id", clp));
                    } else if ("c10816".equals(kVar.bON())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ao("c10816").dk("post_id", aPS.getTid()).dk("obj_name", topicName).dk("topic_id", clp));
                    }
                    if (g.this.mPageContext != null && (g.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                        ((HotTopicActivity) g.this.mPageContext.getOrignalPage()).t(kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eyE = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public a b(ViewGroup viewGroup) {
        n nVar = new n(this.mPageContext);
        nVar.o(this.eyE);
        nVar.setConstrainImagePool(this.hFj);
        nVar.setConstrainLayoutPool(this.hFi);
        nVar.lY(false);
        nVar.setFromCDN(this.aik);
        nVar.currentPageType = 0;
        if (nVar.fRI != null) {
            nVar.fRI.edR = 0;
        }
        return new a(nVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        aVar.iCl.a(kVar);
        aVar.iCl.c(this.hfO);
        aVar.iCl.lX(!(getItem(i + 1) instanceof com.baidu.tieba.hottopic.data.n));
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(kVar);
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends ad.a {
        public n iCl;

        public a(n nVar) {
            super(nVar.getView());
            this.iCl = nVar;
        }
    }
}
