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
/* loaded from: classes8.dex */
public class HomePageVideoThreadAdapter extends com.baidu.adp.widget.ListView.a<l, HomePageVideoThreadViewHolder> {
    private BdUniqueId fGZ;
    private ab<l> iMc;
    private com.baidu.tieba.card.l ksw;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageVideoThreadAdapter(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iMc = new ab<l>() { // from class: com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                if (lVar != null && lVar.bln() != null && !StringUtils.isNull(lVar.bln().getTid()) && !StringUtils.isNull(lVar.csQ()) && HomePageVideoThreadAdapter.this.mPageContext != null && (HomePageVideoThreadAdapter.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) HomePageVideoThreadAdapter.this.mPageContext.getOrignalPage()).t(lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fGZ = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bZ */
    public HomePageVideoThreadViewHolder e(ViewGroup viewGroup) {
        this.ksw = new com.baidu.tieba.card.l(this.mPageContext);
        this.ksw.pu(false);
        this.ksw.o(this.fGZ);
        this.ksw.setFrom("hottopic");
        return new HomePageVideoThreadViewHolder(this.ksw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        if (lVar != null) {
            lVar.xd(i + 1);
            lVar.sourceType = 1;
        }
        homePageVideoThreadViewHolder.ksy.a(lVar);
        homePageVideoThreadViewHolder.ksy.c(this.iMc);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return homePageVideoThreadViewHolder.getView();
    }

    /* loaded from: classes8.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.l ksy;

        public HomePageVideoThreadViewHolder(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.ksy = lVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.ksy == null) {
                return false;
            }
            return this.ksy.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.ksy == null) {
                return false;
            }
            return this.ksy.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.ksy != null) {
                this.ksy.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.ksy != null) {
                this.ksy.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.ksy == null) {
                return null;
            }
            return this.ksy.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.ksy == null) {
                return null;
            }
            return this.ksy.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.ksy == null) {
                return 0;
            }
            return this.ksy.getCurrentPosition();
        }
    }
}
