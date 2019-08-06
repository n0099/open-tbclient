package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fUv;
    private VideoMiddleModel fUw;
    private VideoSerializeVideoThreadInfo fUx;
    private VideoMiddleModel.a fUy = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fUv != null) {
                h.this.fUv.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fUv.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void xd(String str) {
            if (h.this.fUv != null) {
                h.this.fUv.hideLoadingView();
                h.this.fUv.showMsg(str);
                h.this.fUv.atk();
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
            this.fUv = bVar;
            this.fUv.a(this);
            this.fUw = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fUy);
        }
    }

    public void btD() {
        if (this.fUw != null) {
            this.fUw.setFrom(this.mFrom);
            this.fUw.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aIS() {
        if (this.fUw != null && this.mHasMore) {
            this.fUw.setFrom(this.mFrom);
            this.fUw.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fUw != null) {
            this.fUw.setId(this.mId);
        }
    }

    public void xc(String str) {
        this.st_type = str;
        if (this.fUw != null) {
            this.fUw.xc(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fUw != null) {
            this.fUw.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fUx = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo btE() {
        return this.fUx;
    }

    public void boF() {
        if (this.fUw != null) {
            this.fUw.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fUw != null) {
            return this.fUw.getPageNum();
        }
        return 0;
    }
}
