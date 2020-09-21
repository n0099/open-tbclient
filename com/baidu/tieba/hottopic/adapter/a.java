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
/* loaded from: classes20.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, C0700a> {
    private BdUniqueId eSq;
    private aa<com.baidu.tieba.card.data.m> hFx;
    private com.baidu.tieba.card.l jfJ;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hFx = new aa<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                if (mVar != null && mVar.bcY() != null && !StringUtils.isNull(mVar.bcY().getTid()) && !StringUtils.isNull(mVar.cfB()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eSq = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public C0700a c(ViewGroup viewGroup) {
        this.jfJ = new com.baidu.tieba.card.l(this.mPageContext);
        this.jfJ.nl(false);
        this.jfJ.o(this.eSq);
        this.jfJ.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0700a(this.jfJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, C0700a c0700a) {
        if (mVar != null) {
            mVar.vX(i + 1);
            mVar.sourceType = 1;
        }
        c0700a.jfL.a(mVar);
        c0700a.jfL.c(this.hFx);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(mVar);
        }
        return c0700a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0700a extends af.a implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.l jfL;

        public C0700a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.jfL = lVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.jfL == null) {
                return false;
            }
            return this.jfL.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.jfL == null) {
                return false;
            }
            return this.jfL.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.jfL != null) {
                this.jfL.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.jfL != null) {
                this.jfL.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.jfL == null) {
                return null;
            }
            return this.jfL.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.jfL == null) {
                return null;
            }
            return this.jfL.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.jfL == null) {
                return 0;
            }
            return this.jfL.getCurrentPosition();
        }
    }
}
