package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes22.dex */
public class h implements g.a {
    private g.b jfL;
    private VideoMiddleModel jfM;
    private VideoSerializeVideoThreadInfo jfN;
    private VideoMiddleModel.a jfO = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.jfL != null) {
                h.this.jfL.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jfL.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vC(String str) {
            if (h.this.jfL != null) {
                h.this.jfL.hideLoadingView();
                h.this.jfL.showMsg(str);
                h.this.jfL.arV();
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
            this.jfL = bVar;
            this.jfL.a(this);
            this.jfM = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jfO);
        }
    }

    public void cEu() {
        if (this.jfM != null) {
            this.jfM.setFrom(this.mFrom);
            this.jfM.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bMi() {
        if (this.jfM != null && this.mHasMore) {
            this.jfM.setFrom(this.mFrom);
            this.jfM.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jfM != null) {
            this.jfM.setId(this.mId);
        }
    }

    public void Kg(String str) {
        this.st_type = str;
        if (this.jfM != null) {
            this.jfM.Kg(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jfM != null) {
            this.jfM.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jfN = videoSerializeVideoThreadInfo;
        if (this.jfM != null) {
            this.jfM.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cEv() {
        return this.jfN;
    }

    public void cyM() {
        if (this.jfM != null) {
            this.jfM.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jfM != null) {
            return this.jfM.getPageNum();
        }
        return 0;
    }
}
