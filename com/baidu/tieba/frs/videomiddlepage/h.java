package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes16.dex */
public class h implements g.a {
    private g.b iiR;
    private VideoMiddleModel iiS;
    private VideoSerializeVideoThreadInfo iiT;
    private VideoMiddleModel.a iiU = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.iiR != null) {
                h.this.iiR.hideLoadingView();
                h.this.mHasMore = z;
                h.this.iiR.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void rL(String str) {
            if (h.this.iiR != null) {
                h.this.iiR.hideLoadingView();
                h.this.iiR.showMsg(str);
                h.this.iiR.afy();
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
            this.iiR = bVar;
            this.iiR.a(this);
            this.iiS = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.iiU);
        }
    }

    public void cjS() {
        if (this.iiS != null) {
            this.iiS.setFrom(this.mFrom);
            this.iiS.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bwE() {
        if (this.iiS != null && this.mHasMore) {
            this.iiS.setFrom(this.mFrom);
            this.iiS.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iiS != null) {
            this.iiS.setId(this.mId);
        }
    }

    public void FU(String str) {
        this.st_type = str;
        if (this.iiS != null) {
            this.iiS.FU(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iiS != null) {
            this.iiS.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.iiT = videoSerializeVideoThreadInfo;
        if (this.iiS != null) {
            this.iiS.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cjT() {
        return this.iiT;
    }

    public void ceq() {
        if (this.iiS != null) {
            this.iiS.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.iiS != null) {
            return this.iiS.getPageNum();
        }
        return 0;
    }
}
