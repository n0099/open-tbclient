package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dXv;
    private VideoMiddleModel dXw;
    private VideoSerializeVideoThreadInfo dXx;
    private VideoMiddleModel.a dXy = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dXv != null) {
                g.this.dXv.hideLoadingView();
                g.this.mHasMore = z;
                g.this.dXv.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nH(String str) {
            if (g.this.dXv != null) {
                g.this.dXv.hideLoadingView();
                g.this.dXv.showMsg(str);
                g.this.dXv.LP();
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
            this.dXv = bVar;
            this.dXv.a(this);
            this.dXw = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dXy);
        }
    }

    public void aGA() {
        if (this.dXw != null) {
            this.dXw.setFrom(this.mFrom);
            this.dXw.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void YL() {
        if (this.dXw != null && this.mHasMore) {
            this.dXw.setFrom(this.mFrom);
            this.dXw.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dXw != null) {
            this.dXw.setId(this.mId);
        }
    }

    public void nG(String str) {
        this.st_type = str;
        if (this.dXw != null) {
            this.dXw.nG(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dXw != null) {
            this.dXw.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dXx = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aGB() {
        return this.dXx;
    }

    public void aBW() {
        if (this.dXw != null) {
            this.dXw.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dXw != null) {
            return this.dXw.getPageNum();
        }
        return 0;
    }
}
