package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private g.b hPD;
    private VideoMiddleModel hPE;
    private VideoSerializeVideoThreadInfo hPF;
    private VideoMiddleModel.a hPG = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.hPD != null) {
                h.this.hPD.hideLoadingView();
                h.this.mHasMore = z;
                h.this.hPD.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void qH(String str) {
            if (h.this.hPD != null) {
                h.this.hPD.hideLoadingView();
                h.this.hPD.showMsg(str);
                h.this.hPD.adb();
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
            this.hPD = bVar;
            this.hPD.a(this);
            this.hPE = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.hPG);
        }
    }

    public void ccZ() {
        if (this.hPE != null) {
            this.hPE.setFrom(this.mFrom);
            this.hPE.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bqx() {
        if (this.hPE != null && this.mHasMore) {
            this.hPE.setFrom(this.mFrom);
            this.hPE.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hPE != null) {
            this.hPE.setId(this.mId);
        }
    }

    public void EI(String str) {
        this.st_type = str;
        if (this.hPE != null) {
            this.hPE.EI(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hPE != null) {
            this.hPE.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.hPF = videoSerializeVideoThreadInfo;
        if (this.hPE != null) {
            this.hPE.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cda() {
        return this.hPF;
    }

    public void bXG() {
        if (this.hPE != null) {
            this.hPE.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.hPE != null) {
            return this.hPE.getPageNum();
        }
        return 0;
    }
}
