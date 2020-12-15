package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes22.dex */
public class h implements g.a {
    private VideoSerializeVideoThreadInfo jAa;
    private VideoMiddleModel.a jAb = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void o(List<BaseCardInfo> list, boolean z) {
            if (h.this.jzY != null) {
                h.this.jzY.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jzY.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void ws(String str) {
            if (h.this.jzY != null) {
                h.this.jzY.hideLoadingView();
                h.this.jzY.showMsg(str);
                h.this.jzY.awW();
            }
        }
    };
    private g.b jzY;
    private VideoMiddleModel jzZ;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public h(g.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.jzY = bVar;
            this.jzY.a(this);
            this.jzZ = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jAb);
        }
    }

    public void cLQ() {
        if (this.jzZ != null) {
            this.jzZ.setFrom(this.mFrom);
            this.jzZ.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bRN() {
        if (this.jzZ != null && this.mHasMore) {
            this.jzZ.setFrom(this.mFrom);
            this.jzZ.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jzZ != null) {
            this.jzZ.setId(this.mId);
        }
    }

    public void KP(String str) {
        this.st_type = str;
        if (this.jzZ != null) {
            this.jzZ.KP(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jzZ != null) {
            this.jzZ.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jAa = videoSerializeVideoThreadInfo;
        if (this.jzZ != null) {
            this.jzZ.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cLR() {
        return this.jAa;
    }

    public void cFh() {
        if (this.jzZ != null) {
            this.jzZ.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jzZ != null) {
            return this.jzZ.getPageNum();
        }
        return 0;
    }
}
