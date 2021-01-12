package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.n;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    private boolean akY;
    private BdUniqueId fEN;
    private aa<com.baidu.tieba.card.data.k> iGf;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jgX;
    private com.baidu.adp.lib.d.b<TbImageView> jgY;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akY = false;
        this.jgX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.hottopic.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cDT */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(f.this.mPageContext.getPageActivity());
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
        this.jgY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.hottopic.adapter.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bur */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ao.getColor(R.color.common_color_10043));
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
        this.iGf = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.hottopic.adapter.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (kVar != null && kVar.bkV() != null && !StringUtils.isNull(kVar.bkV().getTid()) && !StringUtils.isNull(kVar.crx())) {
                    String topicName = ((HotTopicActivity) f.this.mPageContext.getOrignalPage()).getTopicName();
                    String cQT = ((HotTopicActivity) f.this.mPageContext.getOrignalPage()).cQT();
                    bz bkV = kVar.bkV();
                    bkV.ng(5);
                    if ("c10814".equals(kVar.crx())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dW("tid", bkV.getId()).dW("obj_name", topicName).dW("topic_id", cQT));
                    } else if ("c10816".equals(kVar.crx())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dW("post_id", bkV.getTid()).dW("obj_name", topicName).dW("topic_id", cQT));
                    }
                    if (f.this.mPageContext != null && (f.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                        ((HotTopicActivity) f.this.mPageContext.getOrignalPage()).t(kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fEN = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
    public a e(ViewGroup viewGroup) {
        n nVar = new n(this.mPageContext);
        nVar.o(this.fEN);
        nVar.setConstrainImagePool(this.jgY);
        nVar.setConstrainLayoutPool(this.jgX);
        nVar.pn(false);
        nVar.setFromCDN(this.akY);
        nVar.currentPageType = 0;
        if (nVar.hiT != null) {
            nVar.hiT.fie = 0;
        }
        return new a(nVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        aVar.kkt.a(kVar);
        aVar.kkt.c(this.iGf);
        aVar.kkt.pm(!(getItem(i + 1) instanceof com.baidu.tieba.hottopic.data.n));
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(kVar);
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a extends TypeAdapter.ViewHolder {
        public n kkt;

        public a(n nVar) {
            super(nVar.getView());
            this.kkt = nVar;
        }
    }
}
