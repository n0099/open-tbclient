package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fxL;
    private VideoMiddleModel fxM;
    private VideoSerializeVideoThreadInfo fxN;
    private VideoMiddleModel.a fxO = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fxL != null) {
                h.this.fxL.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fxL.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void ve(String str) {
            if (h.this.fxL != null) {
                h.this.fxL.hideLoadingView();
                h.this.fxL.showMsg(str);
                h.this.fxL.amY();
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
            this.fxL = bVar;
            this.fxL.a(this);
            this.fxM = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fxO);
        }
    }

    public void bjS() {
        if (this.fxM != null) {
            this.fxM.setFrom(this.mFrom);
            this.fxM.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aAZ() {
        if (this.fxM != null && this.mHasMore) {
            this.fxM.setFrom(this.mFrom);
            this.fxM.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fxM != null) {
            this.fxM.setId(this.mId);
        }
    }

    public void vd(String str) {
        this.st_type = str;
        if (this.fxM != null) {
            this.fxM.vd(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fxM != null) {
            this.fxM.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fxN = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo bjT() {
        return this.fxN;
    }

    public void beW() {
        if (this.fxM != null) {
            this.fxM.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fxM != null) {
            return this.fxM.getPageNum();
        }
        return 0;
    }
}
