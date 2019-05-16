package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fOF;
    private VideoMiddleModel fOG;
    private VideoSerializeVideoThreadInfo fOH;
    private VideoMiddleModel.a fOI = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void j(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fOF != null) {
                h.this.fOF.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fOF.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void wy(String str) {
            if (h.this.fOF != null) {
                h.this.fOF.hideLoadingView();
                h.this.fOF.showMsg(str);
                h.this.fOF.asb();
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
            this.fOF = bVar;
            this.fOF.a(this);
            this.fOG = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fOI);
        }
    }

    public void brk() {
        if (this.fOG != null) {
            this.fOG.setFrom(this.mFrom);
            this.fOG.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aHq() {
        if (this.fOG != null && this.mHasMore) {
            this.fOG.setFrom(this.mFrom);
            this.fOG.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fOG != null) {
            this.fOG.setId(this.mId);
        }
    }

    public void wx(String str) {
        this.st_type = str;
        if (this.fOG != null) {
            this.fOG.wx(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fOG != null) {
            this.fOG.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fOH = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo brl() {
        return this.fOH;
    }

    public void bmo() {
        if (this.fOG != null) {
            this.fOG.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fOG != null) {
            return this.fOG.getPageNum();
        }
        return 0;
    }
}
