package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes16.dex */
public class h implements g.a {
    private g.b iiT;
    private VideoMiddleModel iiU;
    private VideoSerializeVideoThreadInfo iiV;
    private VideoMiddleModel.a iiW = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.iiT != null) {
                h.this.iiT.hideLoadingView();
                h.this.mHasMore = z;
                h.this.iiT.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void rL(String str) {
            if (h.this.iiT != null) {
                h.this.iiT.hideLoadingView();
                h.this.iiT.showMsg(str);
                h.this.iiT.afy();
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
            this.iiT = bVar;
            this.iiT.a(this);
            this.iiU = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.iiW);
        }
    }

    public void cjS() {
        if (this.iiU != null) {
            this.iiU.setFrom(this.mFrom);
            this.iiU.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bwE() {
        if (this.iiU != null && this.mHasMore) {
            this.iiU.setFrom(this.mFrom);
            this.iiU.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iiU != null) {
            this.iiU.setId(this.mId);
        }
    }

    public void FU(String str) {
        this.st_type = str;
        if (this.iiU != null) {
            this.iiU.FU(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iiU != null) {
            this.iiU.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.iiV = videoSerializeVideoThreadInfo;
        if (this.iiU != null) {
            this.iiU.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cjT() {
        return this.iiV;
    }

    public void ceq() {
        if (this.iiU != null) {
            this.iiU.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.iiU != null) {
            return this.iiU.getPageNum();
        }
        return 0;
    }
}
