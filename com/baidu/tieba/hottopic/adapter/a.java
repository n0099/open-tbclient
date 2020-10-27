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
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, C0734a> {
    private BdUniqueId fmX;
    private ab<com.baidu.tieba.card.data.m> igS;
    private com.baidu.tieba.card.m jHh;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.igS = new ab<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                if (mVar != null && mVar.bhz() != null && !StringUtils.isNull(mVar.bhz().getTid()) && !StringUtils.isNull(mVar.cme()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fmX = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public C0734a c(ViewGroup viewGroup) {
        this.jHh = new com.baidu.tieba.card.m(this.mPageContext);
        this.jHh.oi(false);
        this.jHh.o(this.fmX);
        this.jHh.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0734a(this.jHh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, C0734a c0734a) {
        if (mVar != null) {
            mVar.wW(i + 1);
            mVar.sourceType = 1;
        }
        c0734a.jHj.a(mVar);
        c0734a.jHj.c(this.igS);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(mVar);
        }
        return c0734a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0734a extends af.a implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.m jHj;

        public C0734a(com.baidu.tieba.card.m mVar) {
            super(mVar.getView());
            this.jHj = mVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.jHj == null) {
                return false;
            }
            return this.jHj.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.jHj == null) {
                return false;
            }
            return this.jHj.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.jHj != null) {
                this.jHj.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.jHj != null) {
                this.jHj.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.jHj == null) {
                return null;
            }
            return this.jHj.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.jHj == null) {
                return null;
            }
            return this.jHj.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.jHj == null) {
                return 0;
            }
            return this.jHj.getCurrentPosition();
        }
    }
}
