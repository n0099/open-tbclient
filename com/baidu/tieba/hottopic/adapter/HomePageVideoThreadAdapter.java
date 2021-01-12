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
/* loaded from: classes7.dex */
public class HomePageVideoThreadAdapter extends com.baidu.adp.widget.ListView.a<l, HomePageVideoThreadViewHolder> {
    private BdUniqueId fEN;
    private aa<l> iGf;
    private com.baidu.tieba.card.l kkb;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageVideoThreadAdapter(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iGf = new aa<l>() { // from class: com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
                if (lVar != null && lVar.bkV() != null && !StringUtils.isNull(lVar.bkV().getTid()) && !StringUtils.isNull(lVar.crx()) && HomePageVideoThreadAdapter.this.mPageContext != null && (HomePageVideoThreadAdapter.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) HomePageVideoThreadAdapter.this.mPageContext.getOrignalPage()).t(lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fEN = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bZ */
    public HomePageVideoThreadViewHolder e(ViewGroup viewGroup) {
        this.kkb = new com.baidu.tieba.card.l(this.mPageContext);
        this.kkb.pk(false);
        this.kkb.o(this.fEN);
        this.kkb.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new HomePageVideoThreadViewHolder(this.kkb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        if (lVar != null) {
            lVar.wT(i + 1);
            lVar.sourceType = 1;
        }
        homePageVideoThreadViewHolder.kkd.a(lVar);
        homePageVideoThreadViewHolder.kkd.c(this.iGf);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return homePageVideoThreadViewHolder.getView();
    }

    /* loaded from: classes7.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.l kkd;

        public HomePageVideoThreadViewHolder(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.kkd = lVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.kkd == null) {
                return false;
            }
            return this.kkd.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.kkd == null) {
                return false;
            }
            return this.kkd.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.kkd != null) {
                this.kkd.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.kkd != null) {
                this.kkd.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.kkd == null) {
                return null;
            }
            return this.kkd.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.kkd == null) {
                return null;
            }
            return this.kkd.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.kkd == null) {
                return 0;
            }
            return this.kkd.getCurrentPosition();
        }
    }
}
