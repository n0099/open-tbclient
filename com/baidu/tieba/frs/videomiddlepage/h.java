package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes21.dex */
public class h implements g.a {
    private VideoMiddleModel iEA;
    private VideoSerializeVideoThreadInfo iEB;
    private VideoMiddleModel.a iEC = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.iEz != null) {
                h.this.iEz.hideLoadingView();
                h.this.mHasMore = z;
                h.this.iEz.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void ux(String str) {
            if (h.this.iEz != null) {
                h.this.iEz.hideLoadingView();
                h.this.iEz.showMsg(str);
                h.this.iEz.anp();
            }
        }
    };
    private g.b iEz;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public h(g.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.iEz = bVar;
            this.iEz.a(this);
            this.iEA = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.iEC);
        }
    }

    public void cxQ() {
        if (this.iEA != null) {
            this.iEA.setFrom(this.mFrom);
            this.iEA.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bGU() {
        if (this.iEA != null && this.mHasMore) {
            this.iEA.setFrom(this.mFrom);
            this.iEA.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iEA != null) {
            this.iEA.setId(this.mId);
        }
    }

    public void IU(String str) {
        this.st_type = str;
        if (this.iEA != null) {
            this.iEA.IU(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iEA != null) {
            this.iEA.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.iEB = videoSerializeVideoThreadInfo;
        if (this.iEA != null) {
            this.iEA.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cxR() {
        return this.iEB;
    }

    public void csi() {
        if (this.iEA != null) {
            this.iEA.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.iEA != null) {
            return this.iEA.getPageNum();
        }
        return 0;
    }
}
