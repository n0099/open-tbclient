package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements g.a {
    private g.b jHR;
    private VideoMiddleModel jHS;
    private VideoSerializeVideoThreadInfo jHT;
    private VideoMiddleModel.a jHU = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void o(List<BaseCardInfo> list, boolean z) {
            if (h.this.jHR != null) {
                h.this.jHR.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jHR.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vg(String str) {
            if (h.this.jHR != null) {
                h.this.jHR.hideLoadingView();
                h.this.jHR.showMsg(str);
                h.this.jHR.onLoadFail();
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
            this.jHR = bVar;
            this.jHR.a(this);
            this.jHS = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jHU);
        }
    }

    public void cLc() {
        if (this.jHS != null) {
            this.jHS.setFrom(this.mFrom);
            this.jHS.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bQy() {
        if (this.jHS != null && this.mHasMore) {
            this.jHS.setFrom(this.mFrom);
            this.jHS.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jHS != null) {
            this.jHS.setId(this.mId);
        }
    }

    public void JD(String str) {
        this.st_type = str;
        if (this.jHS != null) {
            this.jHS.JD(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jHS != null) {
            this.jHS.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jHT = videoSerializeVideoThreadInfo;
        if (this.jHS != null) {
            this.jHS.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cLd() {
        return this.jHT;
    }

    public void cEk() {
        if (this.jHS != null) {
            this.jHS.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jHS != null) {
            return this.jHS.getPageNum();
        }
        return 0;
    }
}
