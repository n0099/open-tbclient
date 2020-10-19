package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes21.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, C0718a> {
    private BdUniqueId fey;
    private aa<com.baidu.tieba.card.data.m> hUs;
    private com.baidu.tieba.card.l juI;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hUs = new aa<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                if (mVar != null && mVar.bfG() != null && !StringUtils.isNull(mVar.bfG().getTid()) && !StringUtils.isNull(mVar.ciX()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fey = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public C0718a c(ViewGroup viewGroup) {
        this.juI = new com.baidu.tieba.card.l(this.mPageContext);
        this.juI.nQ(false);
        this.juI.o(this.fey);
        this.juI.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0718a(this.juI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, C0718a c0718a) {
        if (mVar != null) {
            mVar.wD(i + 1);
            mVar.sourceType = 1;
        }
        c0718a.juK.a(mVar);
        c0718a.juK.c(this.hUs);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(mVar);
        }
        return c0718a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0718a extends af.a implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.l juK;

        public C0718a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.juK = lVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.juK == null) {
                return false;
            }
            return this.juK.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.juK == null) {
                return false;
            }
            return this.juK.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.juK != null) {
                this.juK.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.juK != null) {
                this.juK.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.juK == null) {
                return null;
            }
            return this.juK.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.juK == null) {
                return null;
            }
            return this.juK.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.juK == null) {
                return 0;
            }
            return this.juK.getCurrentPosition();
        }
    }
}
