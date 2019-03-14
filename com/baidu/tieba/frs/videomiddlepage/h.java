package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fxX;
    private VideoMiddleModel fxY;
    private VideoSerializeVideoThreadInfo fxZ;
    private VideoMiddleModel.a fya = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fxX != null) {
                h.this.fxX.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fxX.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vf(String str) {
            if (h.this.fxX != null) {
                h.this.fxX.hideLoadingView();
                h.this.fxX.showMsg(str);
                h.this.fxX.anb();
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
            this.fxX = bVar;
            this.fxX.a(this);
            this.fxY = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fya);
        }
    }

    public void bjU() {
        if (this.fxY != null) {
            this.fxY.setFrom(this.mFrom);
            this.fxY.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aBc() {
        if (this.fxY != null && this.mHasMore) {
            this.fxY.setFrom(this.mFrom);
            this.fxY.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fxY != null) {
            this.fxY.setId(this.mId);
        }
    }

    public void ve(String str) {
        this.st_type = str;
        if (this.fxY != null) {
            this.fxY.ve(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fxY != null) {
            this.fxY.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fxZ = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo bjV() {
        return this.fxZ;
    }

    public void beY() {
        if (this.fxY != null) {
            this.fxY.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fxY != null) {
            return this.fxY.getPageNum();
        }
        return 0;
    }
}
