package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b eiK;
    private VideoMiddleModel eiL;
    private VideoSerializeVideoThreadInfo eiM;
    private VideoMiddleModel.a eiN = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.eiK != null) {
                g.this.eiK.hideLoadingView();
                g.this.mHasMore = z;
                g.this.eiK.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void oC(String str) {
            if (g.this.eiK != null) {
                g.this.eiK.hideLoadingView();
                g.this.eiK.showMsg(str);
                g.this.eiK.Nx();
            }
        }
    };
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.eiK = bVar;
            this.eiK.a(this);
            this.eiL = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.eiN);
        }
    }

    public void aIX() {
        if (this.eiL != null) {
            this.eiL.setFrom(this.mFrom);
            this.eiL.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aaA() {
        if (this.eiL != null && this.mHasMore) {
            this.eiL.setFrom(this.mFrom);
            this.eiL.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.eiL != null) {
            this.eiL.setId(this.mId);
        }
    }

    public void oB(String str) {
        this.st_type = str;
        if (this.eiL != null) {
            this.eiL.oB(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.eiL != null) {
            this.eiL.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.eiM = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aIY() {
        return this.eiM;
    }

    public void aEp() {
        if (this.eiL != null) {
            this.eiL.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.eiL != null) {
            return this.eiL.getPageNum();
        }
        return 0;
    }
}
