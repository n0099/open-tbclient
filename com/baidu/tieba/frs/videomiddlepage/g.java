package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dXu;
    private VideoMiddleModel dXv;
    private VideoSerializeVideoThreadInfo dXw;
    private VideoMiddleModel.a dXx = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dXu != null) {
                g.this.dXu.hideLoadingView();
                g.this.mHasMore = z;
                g.this.dXu.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nH(String str) {
            if (g.this.dXu != null) {
                g.this.dXu.hideLoadingView();
                g.this.dXu.showMsg(str);
                g.this.dXu.LP();
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
            this.dXu = bVar;
            this.dXu.a(this);
            this.dXv = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dXx);
        }
    }

    public void aGA() {
        if (this.dXv != null) {
            this.dXv.setFrom(this.mFrom);
            this.dXv.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void YK() {
        if (this.dXv != null && this.mHasMore) {
            this.dXv.setFrom(this.mFrom);
            this.dXv.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dXv != null) {
            this.dXv.setId(this.mId);
        }
    }

    public void nG(String str) {
        this.st_type = str;
        if (this.dXv != null) {
            this.dXv.nG(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dXv != null) {
            this.dXv.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dXw = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aGB() {
        return this.dXw;
    }

    public void aBV() {
        if (this.dXv != null) {
            this.dXv.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dXv != null) {
            return this.dXv.getPageNum();
        }
        return 0;
    }
}
