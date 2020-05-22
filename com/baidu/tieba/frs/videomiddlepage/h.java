package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private g.b hOQ;
    private VideoMiddleModel hOR;
    private VideoSerializeVideoThreadInfo hOS;
    private VideoMiddleModel.a hOT = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.hOQ != null) {
                h.this.hOQ.hideLoadingView();
                h.this.mHasMore = z;
                h.this.hOQ.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void qH(String str) {
            if (h.this.hOQ != null) {
                h.this.hOQ.hideLoadingView();
                h.this.hOQ.showMsg(str);
                h.this.hOQ.adb();
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
            this.hOQ = bVar;
            this.hOQ.a(this);
            this.hOR = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.hOT);
        }
    }

    public void ccR() {
        if (this.hOR != null) {
            this.hOR.setFrom(this.mFrom);
            this.hOR.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bqv() {
        if (this.hOR != null && this.mHasMore) {
            this.hOR.setFrom(this.mFrom);
            this.hOR.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hOR != null) {
            this.hOR.setId(this.mId);
        }
    }

    public void EI(String str) {
        this.st_type = str;
        if (this.hOR != null) {
            this.hOR.EI(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hOR != null) {
            this.hOR.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.hOS = videoSerializeVideoThreadInfo;
        if (this.hOR != null) {
            this.hOR.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo ccS() {
        return this.hOS;
    }

    public void bXE() {
        if (this.hOR != null) {
            this.hOR.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.hOR != null) {
            return this.hOR.getPageNum();
        }
        return 0;
    }
}
