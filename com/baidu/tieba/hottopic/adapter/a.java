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
/* loaded from: classes20.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, C0751a> {
    private BdUniqueId fsa;
    private ab<com.baidu.tieba.card.data.l> inF;
    private com.baidu.tieba.card.m jNP;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.inF = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (lVar != null && lVar.bjd() != null && !StringUtils.isNull(lVar.bjd().getTid()) && !StringUtils.isNull(lVar.coh()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fsa = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public C0751a c(ViewGroup viewGroup) {
        this.jNP = new com.baidu.tieba.card.m(this.mPageContext);
        this.jNP.ou(false);
        this.jNP.o(this.fsa);
        this.jNP.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0751a(this.jNP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, C0751a c0751a) {
        if (lVar != null) {
            lVar.xH(i + 1);
            lVar.sourceType = 1;
        }
        c0751a.jNR.a(lVar);
        c0751a.jNR.c(this.inF);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return c0751a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0751a extends af.a implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.m jNR;

        public C0751a(com.baidu.tieba.card.m mVar) {
            super(mVar.getView());
            this.jNR = mVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.jNR == null) {
                return false;
            }
            return this.jNR.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.jNR == null) {
                return false;
            }
            return this.jNR.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.jNR != null) {
                this.jNR.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.jNR != null) {
                this.jNR.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.jNR == null) {
                return null;
            }
            return this.jNR.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.jNR == null) {
                return null;
            }
            return this.jNR.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.jNR == null) {
                return 0;
            }
            return this.jNR.getCurrentPosition();
        }
    }
}
