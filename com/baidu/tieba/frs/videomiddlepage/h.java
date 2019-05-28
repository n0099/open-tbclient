package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fOG;
    private VideoMiddleModel fOH;
    private VideoSerializeVideoThreadInfo fOI;
    private VideoMiddleModel.a fOJ = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void j(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fOG != null) {
                h.this.fOG.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fOG.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void wy(String str) {
            if (h.this.fOG != null) {
                h.this.fOG.hideLoadingView();
                h.this.fOG.showMsg(str);
                h.this.fOG.asb();
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
            this.fOG = bVar;
            this.fOG.a(this);
            this.fOH = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fOJ);
        }
    }

    public void brn() {
        if (this.fOH != null) {
            this.fOH.setFrom(this.mFrom);
            this.fOH.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aHt() {
        if (this.fOH != null && this.mHasMore) {
            this.fOH.setFrom(this.mFrom);
            this.fOH.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fOH != null) {
            this.fOH.setId(this.mId);
        }
    }

    public void wx(String str) {
        this.st_type = str;
        if (this.fOH != null) {
            this.fOH.wx(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fOH != null) {
            this.fOH.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fOI = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo bro() {
        return this.fOI;
    }

    public void bmr() {
        if (this.fOH != null) {
            this.fOH.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fOH != null) {
            return this.fOH.getPageNum();
        }
        return 0;
    }
}
