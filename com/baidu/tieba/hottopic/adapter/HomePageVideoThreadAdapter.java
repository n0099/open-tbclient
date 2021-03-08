package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes7.dex */
public class HomePageVideoThreadAdapter extends com.baidu.adp.widget.ListView.a<l, HomePageVideoThreadViewHolder> {
    private BdUniqueId fIy;
    private ab<l> iNL;
    private com.baidu.tieba.card.l kuy;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageVideoThreadAdapter(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iNL = new ab<l>() { // from class: com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                if (lVar != null && lVar.blp() != null && !StringUtils.isNull(lVar.blp().getTid()) && !StringUtils.isNull(lVar.csW()) && HomePageVideoThreadAdapter.this.mPageContext != null && (HomePageVideoThreadAdapter.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) HomePageVideoThreadAdapter.this.mPageContext.getOrignalPage()).t(lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fIy = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bY */
    public HomePageVideoThreadViewHolder e(ViewGroup viewGroup) {
        this.kuy = new com.baidu.tieba.card.l(this.mPageContext);
        this.kuy.pu(false);
        this.kuy.o(this.fIy);
        this.kuy.setFrom("hottopic");
        return new HomePageVideoThreadViewHolder(this.kuy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        if (lVar != null) {
            lVar.xe(i + 1);
            lVar.sourceType = 1;
        }
        homePageVideoThreadViewHolder.kuA.a(lVar);
        homePageVideoThreadViewHolder.kuA.c(this.iNL);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return homePageVideoThreadViewHolder.getView();
    }

    /* loaded from: classes7.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.l kuA;

        public HomePageVideoThreadViewHolder(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.kuA = lVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.kuA == null) {
                return false;
            }
            return this.kuA.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.kuA == null) {
                return false;
            }
            return this.kuA.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.kuA != null) {
                this.kuA.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.kuA != null) {
                this.kuA.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.kuA == null) {
                return null;
            }
            return this.kuA.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.kuA == null) {
                return null;
            }
            return this.kuA.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.kuA == null) {
                return 0;
            }
            return this.kuA.getCurrentPosition();
        }
    }
}
