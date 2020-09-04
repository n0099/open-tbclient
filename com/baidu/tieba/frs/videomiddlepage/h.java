package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes16.dex */
public class h implements g.a {
    private g.b ixd;
    private VideoMiddleModel ixe;
    private VideoSerializeVideoThreadInfo ixf;
    private VideoMiddleModel.a ixg = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.ixd != null) {
                h.this.ixd.hideLoadingView();
                h.this.mHasMore = z;
                h.this.ixd.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void ue(String str) {
            if (h.this.ixd != null) {
                h.this.ixd.hideLoadingView();
                h.this.ixd.showMsg(str);
                h.this.ixd.amF();
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
            this.ixd = bVar;
            this.ixd.a(this);
            this.ixe = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.ixg);
        }
    }

    public void cux() {
        if (this.ixe != null) {
            this.ixe.setFrom(this.mFrom);
            this.ixe.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bFE() {
        if (this.ixe != null && this.mHasMore) {
            this.ixe.setFrom(this.mFrom);
            this.ixe.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.ixe != null) {
            this.ixe.setId(this.mId);
        }
    }

    public void Ix(String str) {
        this.st_type = str;
        if (this.ixe != null) {
            this.ixe.Ix(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.ixe != null) {
            this.ixe.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.ixf = videoSerializeVideoThreadInfo;
        if (this.ixe != null) {
            this.ixe.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cuy() {
        return this.ixf;
    }

    public void coV() {
        if (this.ixe != null) {
            this.ixe.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.ixe != null) {
            return this.ixe.getPageNum();
        }
        return 0;
    }
}
