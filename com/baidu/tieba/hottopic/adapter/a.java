package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, C0642a> {
    private BdUniqueId eyE;
    private aa<com.baidu.tieba.card.data.l> hfO;
    private com.baidu.tieba.card.l iBT;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hfO = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (lVar != null && lVar.aPS() != null && !StringUtils.isNull(lVar.aPS().getTid()) && !StringUtils.isNull(lVar.bOO()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eyE = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public C0642a b(ViewGroup viewGroup) {
        this.iBT = new com.baidu.tieba.card.l(this.mPageContext);
        this.iBT.lV(false);
        this.iBT.o(this.eyE);
        this.iBT.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0642a(this.iBT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, C0642a c0642a) {
        if (lVar != null) {
            lVar.sR(i + 1);
            lVar.sourceType = 1;
        }
        c0642a.iBV.a(lVar);
        c0642a.iBV.c(this.hfO);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return c0642a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0642a extends ad.a implements com.baidu.tieba.play.f {
        public com.baidu.tieba.card.l iBV;

        public C0642a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.iBV = lVar;
        }

        @Override // com.baidu.tieba.play.f
        public boolean isPlayStarted() {
            if (this.iBV == null) {
                return false;
            }
            return this.iBV.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.f
        public boolean isPlaying() {
            if (this.iBV == null) {
                return false;
            }
            return this.iBV.isPlaying();
        }

        @Override // com.baidu.tieba.play.f
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.f
        public void startPlay() {
            if (this.iBV != null) {
                this.iBV.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.f
        public void stopPlay() {
            if (this.iBV != null) {
                this.iBV.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.f
        public View getVideoContainer() {
            if (this.iBV == null) {
                return null;
            }
            return this.iBV.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.f
        public String getPlayUrl() {
            if (this.iBV == null) {
                return null;
            }
            return this.iBV.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.f
        public int getCurrentPosition() {
            if (this.iBV == null) {
                return 0;
            }
            return this.iBV.getCurrentPosition();
        }
    }
}
