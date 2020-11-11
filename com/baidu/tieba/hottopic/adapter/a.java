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
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, C0748a> {
    private BdUniqueId fsQ;
    private ab<com.baidu.tieba.card.data.m> imQ;
    private com.baidu.tieba.card.m jNf;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.imQ = new ab<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                if (mVar != null && mVar.bjZ() != null && !StringUtils.isNull(mVar.bjZ().getTid()) && !StringUtils.isNull(mVar.coF()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fsQ = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public C0748a c(ViewGroup viewGroup) {
        this.jNf = new com.baidu.tieba.card.m(this.mPageContext);
        this.jNf.or(false);
        this.jNf.o(this.fsQ);
        this.jNf.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0748a(this.jNf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, C0748a c0748a) {
        if (mVar != null) {
            mVar.xj(i + 1);
            mVar.sourceType = 1;
        }
        c0748a.jNh.a(mVar);
        c0748a.jNh.c(this.imQ);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(mVar);
        }
        return c0748a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0748a extends af.a implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.m jNh;

        public C0748a(com.baidu.tieba.card.m mVar) {
            super(mVar.getView());
            this.jNh = mVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.jNh == null) {
                return false;
            }
            return this.jNh.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.jNh == null) {
                return false;
            }
            return this.jNh.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.jNh != null) {
                this.jNh.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.jNh != null) {
                this.jNh.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.jNh == null) {
                return null;
            }
            return this.jNh.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.jNh == null) {
                return null;
            }
            return this.jNh.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.jNh == null) {
                return 0;
            }
            return this.jNh.getCurrentPosition();
        }
    }
}
