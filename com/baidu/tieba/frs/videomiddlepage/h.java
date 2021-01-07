package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements g.a {
    private VideoMiddleModel.a jMA = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void o(List<BaseCardInfo> list, boolean z) {
            if (h.this.jMx != null) {
                h.this.jMx.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jMx.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void wr(String str) {
            if (h.this.jMx != null) {
                h.this.jMx.hideLoadingView();
                h.this.jMx.showMsg(str);
                h.this.jMx.onLoadFail();
            }
        }
    };
    private g.b jMx;
    private VideoMiddleModel jMy;
    private VideoSerializeVideoThreadInfo jMz;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public h(g.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.jMx = bVar;
            this.jMx.a(this);
            this.jMy = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jMA);
        }
    }

    public void cOU() {
        if (this.jMy != null) {
            this.jMy.setFrom(this.mFrom);
            this.jMy.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bUq() {
        if (this.jMy != null && this.mHasMore) {
            this.jMy.setFrom(this.mFrom);
            this.jMy.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jMy != null) {
            this.jMy.setId(this.mId);
        }
    }

    public void KN(String str) {
        this.st_type = str;
        if (this.jMy != null) {
            this.jMy.KN(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jMy != null) {
            this.jMy.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jMz = videoSerializeVideoThreadInfo;
        if (this.jMy != null) {
            this.jMy.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cOV() {
        return this.jMz;
    }

    public void cIc() {
        if (this.jMy != null) {
            this.jMy.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jMy != null) {
            return this.jMy.getPageNum();
        }
        return 0;
    }
}
