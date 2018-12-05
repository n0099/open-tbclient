package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b efm;
    private VideoMiddleModel efn;
    private VideoSerializeVideoThreadInfo efo;
    private VideoMiddleModel.a efp = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.efm != null) {
                g.this.efm.hideLoadingView();
                g.this.mHasMore = z;
                g.this.efm.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void oi(String str) {
            if (g.this.efm != null) {
                g.this.efm.hideLoadingView();
                g.this.efm.showMsg(str);
                g.this.efm.Nf();
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
            this.efm = bVar;
            this.efm.a(this);
            this.efn = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.efp);
        }
    }

    public void aHK() {
        if (this.efn != null) {
            this.efn.setFrom(this.mFrom);
            this.efn.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aab() {
        if (this.efn != null && this.mHasMore) {
            this.efn.setFrom(this.mFrom);
            this.efn.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.efn != null) {
            this.efn.setId(this.mId);
        }
    }

    public void oh(String str) {
        this.st_type = str;
        if (this.efn != null) {
            this.efn.oh(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.efn != null) {
            this.efn.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.efo = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aHL() {
        return this.efo;
    }

    public void aDd() {
        if (this.efn != null) {
            this.efn.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.efn != null) {
            return this.efn.getPageNum();
        }
        return 0;
    }
}
