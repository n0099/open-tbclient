package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes8.dex */
public class HomePageVideoThreadAdapter extends com.baidu.adp.widget.ListView.a<l, HomePageVideoThreadViewHolder> {
    private BdUniqueId fJu;
    private aa<l> iKM;
    private com.baidu.tieba.card.l koG;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageVideoThreadAdapter(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iKM = new aa<l>() { // from class: com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
                if (lVar != null && lVar.boP() != null && !StringUtils.isNull(lVar.boP().getTid()) && !StringUtils.isNull(lVar.cvp()) && HomePageVideoThreadAdapter.this.mPageContext != null && (HomePageVideoThreadAdapter.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) HomePageVideoThreadAdapter.this.mPageContext.getOrignalPage()).t(lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fJu = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bZ */
    public HomePageVideoThreadViewHolder e(ViewGroup viewGroup) {
        this.koG = new com.baidu.tieba.card.l(this.mPageContext);
        this.koG.po(false);
        this.koG.o(this.fJu);
        this.koG.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new HomePageVideoThreadViewHolder(this.koG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        if (lVar != null) {
            lVar.yA(i + 1);
            lVar.sourceType = 1;
        }
        homePageVideoThreadViewHolder.koI.a(lVar);
        homePageVideoThreadViewHolder.koI.c(this.iKM);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return homePageVideoThreadViewHolder.getView();
    }

    /* loaded from: classes8.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.l koI;

        public HomePageVideoThreadViewHolder(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.koI = lVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.koI == null) {
                return false;
            }
            return this.koI.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.koI == null) {
                return false;
            }
            return this.koI.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.koI != null) {
                this.koI.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.koI != null) {
                this.koI.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.koI == null) {
                return null;
            }
            return this.koI.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.koI == null) {
                return null;
            }
            return this.koI.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.koI == null) {
                return 0;
            }
            return this.koI.getCurrentPosition();
        }
    }
}
