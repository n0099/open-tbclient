package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private VideoMiddleModel.a hAa = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.hzX != null) {
                h.this.hzX.hideLoadingView();
                h.this.mHasMore = z;
                h.this.hzX.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void pj(String str) {
            if (h.this.hzX != null) {
                h.this.hzX.hideLoadingView();
                h.this.hzX.showMsg(str);
                h.this.hzX.aac();
            }
        }
    };
    private g.b hzX;
    private VideoMiddleModel hzY;
    private VideoSerializeVideoThreadInfo hzZ;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public h(g.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.hzX = bVar;
            this.hzX.a(this);
            this.hzY = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.hAa);
        }
    }

    public void bWu() {
        if (this.hzY != null) {
            this.hzY.setFrom(this.mFrom);
            this.hzY.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void blb() {
        if (this.hzY != null && this.mHasMore) {
            this.hzY.setFrom(this.mFrom);
            this.hzY.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hzY != null) {
            this.hzY.setId(this.mId);
        }
    }

    public void CW(String str) {
        this.st_type = str;
        if (this.hzY != null) {
            this.hzY.CW(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hzY != null) {
            this.hzY.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.hzZ = videoSerializeVideoThreadInfo;
        if (this.hzY != null) {
            this.hzY.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo bWv() {
        return this.hzZ;
    }

    public void bRj() {
        if (this.hzY != null) {
            this.hzY.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.hzY != null) {
            return this.hzY.getPageNum();
        }
        return 0;
    }
}
