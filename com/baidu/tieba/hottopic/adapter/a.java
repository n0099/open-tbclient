package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes21.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, C0767a> {
    private BdUniqueId fzO;
    private ab<com.baidu.tieba.card.data.l> iyz;
    private com.baidu.tieba.card.m kbu;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iyz = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (lVar != null && lVar.bmn() != null && !StringUtils.isNull(lVar.bmn().getTid()) && !StringUtils.isNull(lVar.csv()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fzO = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bK */
    public C0767a c(ViewGroup viewGroup) {
        this.kbu = new com.baidu.tieba.card.m(this.mPageContext);
        this.kbu.oQ(false);
        this.kbu.o(this.fzO);
        this.kbu.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0767a(this.kbu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, C0767a c0767a) {
        if (lVar != null) {
            lVar.ym(i + 1);
            lVar.sourceType = 1;
        }
        c0767a.kbw.a(lVar);
        c0767a.kbw.c(this.iyz);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return c0767a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0767a extends af.a implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.m kbw;

        public C0767a(com.baidu.tieba.card.m mVar) {
            super(mVar.getView());
            this.kbw = mVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.kbw == null) {
                return false;
            }
            return this.kbw.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.kbw == null) {
                return false;
            }
            return this.kbw.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.kbw != null) {
                this.kbw.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.kbw != null) {
                this.kbw.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.kbw == null) {
                return null;
            }
            return this.kbw.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.kbw == null) {
                return null;
            }
            return this.kbw.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.kbw == null) {
                return 0;
            }
            return this.kbw.getCurrentPosition();
        }
    }
}
