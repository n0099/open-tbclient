package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements g.a {
    private g.b jPs;
    private VideoMiddleModel jPt;
    private VideoSerializeVideoThreadInfo jPu;
    private VideoMiddleModel.a jPv = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void p(List<BaseCardInfo> list, boolean z) {
            if (h.this.jPs != null) {
                h.this.jPs.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jPs.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vG(String str) {
            if (h.this.jPs != null) {
                h.this.jPs.hideLoadingView();
                h.this.jPs.showMsg(str);
                h.this.jPs.onLoadFail();
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
            this.jPs = bVar;
            this.jPs.a(this);
            this.jPt = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jPv);
        }
    }

    public void cMD() {
        if (this.jPt != null) {
            this.jPt.setFrom(this.mFrom);
            this.jPt.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bRp() {
        if (this.jPt != null && this.mHasMore) {
            this.jPt.setFrom(this.mFrom);
            this.jPt.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jPt != null) {
            this.jPt.setId(this.mId);
        }
    }

    public void Ky(String str) {
        this.st_type = str;
        if (this.jPt != null) {
            this.jPt.Ky(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jPt != null) {
            this.jPt.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jPu = videoSerializeVideoThreadInfo;
        if (this.jPt != null) {
            this.jPt.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cME() {
        return this.jPu;
    }

    public void cFK() {
        if (this.jPt != null) {
            this.jPt.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jPt != null) {
            return this.jPt.getPageNum();
        }
        return 0;
    }
}
