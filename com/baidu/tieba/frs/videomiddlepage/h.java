package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private g.b hAd;
    private VideoMiddleModel hAe;
    private VideoSerializeVideoThreadInfo hAf;
    private VideoMiddleModel.a hAg = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.hAd != null) {
                h.this.hAd.hideLoadingView();
                h.this.mHasMore = z;
                h.this.hAd.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void pj(String str) {
            if (h.this.hAd != null) {
                h.this.hAd.hideLoadingView();
                h.this.hAd.showMsg(str);
                h.this.hAd.aab();
            }
        }
    };
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public h(g.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.hAd = bVar;
            this.hAd.a(this);
            this.hAe = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.hAg);
        }
    }

    public void bWs() {
        if (this.hAe != null) {
            this.hAe.setFrom(this.mFrom);
            this.hAe.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bkZ() {
        if (this.hAe != null && this.mHasMore) {
            this.hAe.setFrom(this.mFrom);
            this.hAe.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hAe != null) {
            this.hAe.setId(this.mId);
        }
    }

    public void CZ(String str) {
        this.st_type = str;
        if (this.hAe != null) {
            this.hAe.CZ(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hAe != null) {
            this.hAe.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.hAf = videoSerializeVideoThreadInfo;
        if (this.hAe != null) {
            this.hAe.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo bWt() {
        return this.hAf;
    }

    public void bRh() {
        if (this.hAe != null) {
            this.hAe.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.hAe != null) {
            return this.hAe.getPageNum();
        }
        return 0;
    }
}
