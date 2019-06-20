package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fOI;
    private VideoMiddleModel fOJ;
    private VideoSerializeVideoThreadInfo fOK;
    private VideoMiddleModel.a fOL = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void j(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fOI != null) {
                h.this.fOI.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fOI.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void wx(String str) {
            if (h.this.fOI != null) {
                h.this.fOI.hideLoadingView();
                h.this.fOI.showMsg(str);
                h.this.fOI.asb();
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
            this.fOI = bVar;
            this.fOI.a(this);
            this.fOJ = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fOL);
        }
    }

    public void brp() {
        if (this.fOJ != null) {
            this.fOJ.setFrom(this.mFrom);
            this.fOJ.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aHt() {
        if (this.fOJ != null && this.mHasMore) {
            this.fOJ.setFrom(this.mFrom);
            this.fOJ.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fOJ != null) {
            this.fOJ.setId(this.mId);
        }
    }

    public void ww(String str) {
        this.st_type = str;
        if (this.fOJ != null) {
            this.fOJ.ww(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fOJ != null) {
            this.fOJ.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fOK = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo brq() {
        return this.fOK;
    }

    public void bmr() {
        if (this.fOJ != null) {
            this.fOJ.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fOJ != null) {
            return this.fOJ.getPageNum();
        }
        return 0;
    }
}
