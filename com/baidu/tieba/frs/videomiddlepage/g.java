package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b eiJ;
    private VideoMiddleModel eiK;
    private VideoSerializeVideoThreadInfo eiL;
    private VideoMiddleModel.a eiM = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.eiJ != null) {
                g.this.eiJ.hideLoadingView();
                g.this.mHasMore = z;
                g.this.eiJ.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void oC(String str) {
            if (g.this.eiJ != null) {
                g.this.eiJ.hideLoadingView();
                g.this.eiJ.showMsg(str);
                g.this.eiJ.Nx();
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
            this.eiJ = bVar;
            this.eiJ.a(this);
            this.eiK = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.eiM);
        }
    }

    public void aIX() {
        if (this.eiK != null) {
            this.eiK.setFrom(this.mFrom);
            this.eiK.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aaA() {
        if (this.eiK != null && this.mHasMore) {
            this.eiK.setFrom(this.mFrom);
            this.eiK.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.eiK != null) {
            this.eiK.setId(this.mId);
        }
    }

    public void oB(String str) {
        this.st_type = str;
        if (this.eiK != null) {
            this.eiK.oB(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.eiK != null) {
            this.eiK.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.eiL = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aIY() {
        return this.eiL;
    }

    public void aEp() {
        if (this.eiK != null) {
            this.eiK.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.eiK != null) {
            return this.eiK.getPageNum();
        }
        return 0;
    }
}
