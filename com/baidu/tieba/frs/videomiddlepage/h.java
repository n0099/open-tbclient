package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fVH;
    private VideoMiddleModel fVI;
    private VideoSerializeVideoThreadInfo fVJ;
    private VideoMiddleModel.a fVK = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fVH != null) {
                h.this.fVH.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fVH.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vU(String str) {
            if (h.this.fVH != null) {
                h.this.fVH.hideLoadingView();
                h.this.fVH.showMsg(str);
                h.this.fVH.avg();
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
            this.fVH = bVar;
            this.fVH.a(this);
            this.fVI = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fVK);
        }
    }

    public void brt() {
        if (this.fVI != null) {
            this.fVI.setFrom(this.mFrom);
            this.fVI.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aIW() {
        if (this.fVI != null && this.mHasMore) {
            this.fVI.setFrom(this.mFrom);
            this.fVI.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fVI != null) {
            this.fVI.setId(this.mId);
        }
    }

    public void vT(String str) {
        this.st_type = str;
        if (this.fVI != null) {
            this.fVI.vT(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fVI != null) {
            this.fVI.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fVJ = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo bru() {
        return this.fVJ;
    }

    public void bmv() {
        if (this.fVI != null) {
            this.fVI.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fVI != null) {
            return this.fVI.getPageNum();
        }
        return 0;
    }
}
