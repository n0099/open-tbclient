package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fWm;
    private VideoMiddleModel fWn;
    private VideoSerializeVideoThreadInfo fWo;
    private VideoMiddleModel.a fWp = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fWm != null) {
                h.this.fWm.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fWm.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void xC(String str) {
            if (h.this.fWm != null) {
                h.this.fWm.hideLoadingView();
                h.this.fWm.showMsg(str);
                h.this.fWm.atw();
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
            this.fWm = bVar;
            this.fWm.a(this);
            this.fWn = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fWp);
        }
    }

    public void bur() {
        if (this.fWn != null) {
            this.fWn.setFrom(this.mFrom);
            this.fWn.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aJw() {
        if (this.fWn != null && this.mHasMore) {
            this.fWn.setFrom(this.mFrom);
            this.fWn.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fWn != null) {
            this.fWn.setId(this.mId);
        }
    }

    public void xB(String str) {
        this.st_type = str;
        if (this.fWn != null) {
            this.fWn.xB(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fWn != null) {
            this.fWn.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fWo = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo bus() {
        return this.fWo;
    }

    public void bpq() {
        if (this.fWn != null) {
            this.fWn.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fWn != null) {
            return this.fWn.getPageNum();
        }
        return 0;
    }
}
