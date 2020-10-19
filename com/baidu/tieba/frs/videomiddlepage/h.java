package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes22.dex */
public class h implements g.a {
    private g.b iTp;
    private VideoMiddleModel iTq;
    private VideoSerializeVideoThreadInfo iTr;
    private VideoMiddleModel.a iTs = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void m(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.iTp != null) {
                h.this.iTp.hideLoadingView();
                h.this.mHasMore = z;
                h.this.iTp.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vj(String str) {
            if (h.this.iTp != null) {
                h.this.iTp.hideLoadingView();
                h.this.iTp.showMsg(str);
                h.this.iTp.aqb();
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
            this.iTp = bVar;
            this.iTp.a(this);
            this.iTq = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.iTs);
        }
    }

    public void cBn() {
        if (this.iTq != null) {
            this.iTq.setFrom(this.mFrom);
            this.iTq.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bJG() {
        if (this.iTq != null && this.mHasMore) {
            this.iTq.setFrom(this.mFrom);
            this.iTq.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iTq != null) {
            this.iTq.setId(this.mId);
        }
    }

    public void JH(String str) {
        this.st_type = str;
        if (this.iTq != null) {
            this.iTq.JH(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iTq != null) {
            this.iTq.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.iTr = videoSerializeVideoThreadInfo;
        if (this.iTq != null) {
            this.iTq.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cBo() {
        return this.iTr;
    }

    public void cvF() {
        if (this.iTq != null) {
            this.iTq.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.iTq != null) {
            return this.iTq.getPageNum();
        }
        return 0;
    }
}
