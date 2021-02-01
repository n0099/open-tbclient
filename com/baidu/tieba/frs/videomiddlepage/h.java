package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements g.a {
    private g.b jNv;
    private VideoMiddleModel jNw;
    private VideoSerializeVideoThreadInfo jNx;
    private VideoMiddleModel.a jNy = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void p(List<BaseCardInfo> list, boolean z) {
            if (h.this.jNv != null) {
                h.this.jNv.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jNv.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vz(String str) {
            if (h.this.jNv != null) {
                h.this.jNv.hideLoadingView();
                h.this.jNv.showMsg(str);
                h.this.jNv.onLoadFail();
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
            this.jNv = bVar;
            this.jNv.a(this);
            this.jNw = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jNy);
        }
    }

    public void cMq() {
        if (this.jNw != null) {
            this.jNw.setFrom(this.mFrom);
            this.jNw.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bRc() {
        if (this.jNw != null && this.mHasMore) {
            this.jNw.setFrom(this.mFrom);
            this.jNw.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jNw != null) {
            this.jNw.setId(this.mId);
        }
    }

    public void Ko(String str) {
        this.st_type = str;
        if (this.jNw != null) {
            this.jNw.Ko(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jNw != null) {
            this.jNw.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jNx = videoSerializeVideoThreadInfo;
        if (this.jNw != null) {
            this.jNw.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cMr() {
        return this.jNx;
    }

    public void cFx() {
        if (this.jNw != null) {
            this.jNw.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jNw != null) {
            return this.jNw.getPageNum();
        }
        return 0;
    }
}
