package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private g.b icP;
    private VideoMiddleModel icQ;
    private VideoSerializeVideoThreadInfo icR;
    private VideoMiddleModel.a icS = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.icP != null) {
                h.this.icP.hideLoadingView();
                h.this.mHasMore = z;
                h.this.icP.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void qP(String str) {
            if (h.this.icP != null) {
                h.this.icP.hideLoadingView();
                h.this.icP.showMsg(str);
                h.this.icP.aeh();
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
            this.icP = bVar;
            this.icP.a(this);
            this.icQ = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.icS);
        }
    }

    public void cgs() {
        if (this.icQ != null) {
            this.icQ.setFrom(this.mFrom);
            this.icQ.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void btu() {
        if (this.icQ != null && this.mHasMore) {
            this.icQ.setFrom(this.mFrom);
            this.icQ.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.icQ != null) {
            this.icQ.setId(this.mId);
        }
    }

    public void Fj(String str) {
        this.st_type = str;
        if (this.icQ != null) {
            this.icQ.Fj(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.icQ != null) {
            this.icQ.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.icR = videoSerializeVideoThreadInfo;
        if (this.icQ != null) {
            this.icQ.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cgt() {
        return this.icR;
    }

    public void caR() {
        if (this.icQ != null) {
            this.icQ.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.icQ != null) {
            return this.icQ.getPageNum();
        }
        return 0;
    }
}
