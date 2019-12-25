package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class h implements g.a {
    private g.b gJq;
    private VideoMiddleModel gJr;
    private VideoSerializeVideoThreadInfo gJs;
    private VideoMiddleModel.a gJt = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.gJq != null) {
                h.this.gJq.hideLoadingView();
                h.this.mHasMore = z;
                h.this.gJq.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nD(String str) {
            if (h.this.gJq != null) {
                h.this.gJq.hideLoadingView();
                h.this.gJq.showMsg(str);
                h.this.gJq.Py();
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
            this.gJq = bVar;
            this.gJq.a(this);
            this.gJr = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.gJt);
        }
    }

    public void bIT() {
        if (this.gJr != null) {
            this.gJr.setFrom(this.mFrom);
            this.gJr.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aZs() {
        if (this.gJr != null && this.mHasMore) {
            this.gJr.setFrom(this.mFrom);
            this.gJr.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gJr != null) {
            this.gJr.setId(this.mId);
        }
    }

    public void AK(String str) {
        this.st_type = str;
        if (this.gJr != null) {
            this.gJr.AK(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gJr != null) {
            this.gJr.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.gJs = videoSerializeVideoThreadInfo;
        if (this.gJr != null) {
            this.gJr.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo bIU() {
        return this.gJs;
    }

    public void bDP() {
        if (this.gJr != null) {
            this.gJr.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.gJr != null) {
            return this.gJr.getPageNum();
        }
        return 0;
    }
}
