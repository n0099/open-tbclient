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
/* loaded from: classes15.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, C0652a> {
    private BdUniqueId eEU;
    private aa<com.baidu.tieba.card.data.l> hly;
    private com.baidu.tieba.card.l iHZ;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hly = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.hottopic.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (lVar != null && lVar.aTN() != null && !StringUtils.isNull(lVar.aTN().getTid()) && !StringUtils.isNull(lVar.bRZ()) && a.this.mPageContext != null && (a.this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
                    ((HotTopicActivity) a.this.mPageContext.getOrignalPage()).t(lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eEU = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public C0652a b(ViewGroup viewGroup) {
        this.iHZ = new com.baidu.tieba.card.l(this.mPageContext);
        this.iHZ.mA(false);
        this.iHZ.p(this.eEU);
        this.iHZ.setFrom(VideoMiddlePageActivityConfig.FROM_HOTTOPIC);
        return new C0652a(this.iHZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, C0652a c0652a) {
        if (lVar != null) {
            lVar.tj(i + 1);
            lVar.sourceType = 1;
        }
        c0652a.iIb.a(lVar);
        c0652a.iIb.c(this.hly);
        if (this.mPageContext != null && (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.hottopic.controller.a)) {
            this.mPageContext.getOrignalPage().s(lVar);
        }
        return c0652a.getView();
    }

    /* renamed from: com.baidu.tieba.hottopic.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0652a extends ad.a implements com.baidu.tieba.play.e {
        public com.baidu.tieba.card.l iIb;

        public C0652a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.iIb = lVar;
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlayStarted() {
            if (this.iIb == null) {
                return false;
            }
            return this.iIb.isPlayStarted();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isPlaying() {
            if (this.iIb == null) {
                return false;
            }
            return this.iIb.isPlaying();
        }

        @Override // com.baidu.tieba.play.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.baidu.tieba.play.e
        public void startPlay() {
            if (this.iIb != null) {
                this.iIb.startPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public void stopPlay() {
            if (this.iIb != null) {
                this.iIb.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.e
        public View getVideoContainer() {
            if (this.iIb == null) {
                return null;
            }
            return this.iIb.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.e
        public String getPlayUrl() {
            if (this.iIb == null) {
                return null;
            }
            return this.iIb.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.e
        public int getCurrentPosition() {
            if (this.iIb == null) {
                return 0;
            }
            return this.iIb.getCurrentPosition();
        }
    }
}
