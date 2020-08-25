package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes16.dex */
public class h implements g.a {
    private g.b iwX;
    private VideoMiddleModel iwY;
    private VideoSerializeVideoThreadInfo iwZ;
    private VideoMiddleModel.a ixa = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.iwX != null) {
                h.this.iwX.hideLoadingView();
                h.this.mHasMore = z;
                h.this.iwX.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void ud(String str) {
            if (h.this.iwX != null) {
                h.this.iwX.hideLoadingView();
                h.this.iwX.showMsg(str);
                h.this.iwX.amF();
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
            this.iwX = bVar;
            this.iwX.a(this);
            this.iwY = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.ixa);
        }
    }

    public void cuw() {
        if (this.iwY != null) {
            this.iwY.setFrom(this.mFrom);
            this.iwY.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bFD() {
        if (this.iwY != null && this.mHasMore) {
            this.iwY.setFrom(this.mFrom);
            this.iwY.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iwY != null) {
            this.iwY.setId(this.mId);
        }
    }

    public void Iw(String str) {
        this.st_type = str;
        if (this.iwY != null) {
            this.iwY.Iw(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iwY != null) {
            this.iwY.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.iwZ = videoSerializeVideoThreadInfo;
        if (this.iwY != null) {
            this.iwY.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cux() {
        return this.iwZ;
    }

    public void coU() {
        if (this.iwY != null) {
            this.iwY.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.iwY != null) {
            return this.iwY.getPageNum();
        }
        return 0;
    }
}
