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
/* loaded from: classes15.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, C0703a> {
    private BdUniqueId ePz;
    private aa<com.baidu.tieba.card.data.m> hyv;
    private com.baidu.tieba.card.l iXd;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hyv = new aa<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                if (mVar != null && mVar.bce() != null && !StringUtils.isNull(mVar.bce().getTid()) && !StringUtils.isNull(mVar.ccm()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ePz = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public C0703a b(ViewGroup viewGroup) {
        this.iXd = new com.baidu.tieba.card.l(this.mPageContext);
        this.iXd.nf(false);
        this.iXd.p(this.ePz);
        this.iXd.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0703a(this.iXd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, C0703a c0703a) {
        if (mVar != null) {
            mVar.vy(i + 1);
            mVar.sourceType = 1;
        }
        c0703a.iXf.a(mVar);
        c0703a.iXf.c(this.hyv);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(mVar);
        }
        return c0703a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0703a extends af.a implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.l iXf;

        public C0703a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.iXf = lVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.iXf == null) {
                return false;
            }
            return this.iXf.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.iXf == null) {
                return false;
            }
            return this.iXf.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.iXf != null) {
                this.iXf.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.iXf != null) {
                this.iXf.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.iXf == null) {
                return null;
            }
            return this.iXf.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.iXf == null) {
                return null;
            }
            return this.iXf.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.iXf == null) {
                return 0;
            }
            return this.iXf.getCurrentPosition();
        }
    }
}
