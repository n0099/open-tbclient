package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private g.b gPY;
    private VideoMiddleModel gPZ;
    private VideoSerializeVideoThreadInfo gQa;
    private VideoMiddleModel.a gQb = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.gPY != null) {
                h.this.gPY.hideLoadingView();
                h.this.mHasMore = z;
                h.this.gPY.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nU(String str) {
            if (h.this.gPY != null) {
                h.this.gPY.hideLoadingView();
                h.this.gPY.showMsg(str);
                h.this.gPY.Sn();
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
            this.gPY = bVar;
            this.gPY.a(this);
            this.gPZ = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.gQb);
        }
    }

    public void bLO() {
        if (this.gPZ != null) {
            this.gPZ.setFrom(this.mFrom);
            this.gPZ.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bck() {
        if (this.gPZ != null && this.mHasMore) {
            this.gPZ.setFrom(this.mFrom);
            this.gPZ.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gPZ != null) {
            this.gPZ.setId(this.mId);
        }
    }

    public void Bl(String str) {
        this.st_type = str;
        if (this.gPZ != null) {
            this.gPZ.Bl(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gPZ != null) {
            this.gPZ.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.gQa = videoSerializeVideoThreadInfo;
        if (this.gPZ != null) {
            this.gPZ.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo bLP() {
        return this.gQa;
    }

    public void bGI() {
        if (this.gPZ != null) {
            this.gPZ.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.gPZ != null) {
            return this.gPZ.getPageNum();
        }
        return 0;
    }
}
