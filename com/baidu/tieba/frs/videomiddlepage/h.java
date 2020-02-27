package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private g.b gOD;
    private VideoMiddleModel gOE;
    private VideoSerializeVideoThreadInfo gOF;
    private VideoMiddleModel.a gOG = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.gOD != null) {
                h.this.gOD.hideLoadingView();
                h.this.mHasMore = z;
                h.this.gOD.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nV(String str) {
            if (h.this.gOD != null) {
                h.this.gOD.hideLoadingView();
                h.this.gOD.showMsg(str);
                h.this.gOD.Si();
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
            this.gOD = bVar;
            this.gOD.a(this);
            this.gOE = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.gOG);
        }
    }

    public void bLx() {
        if (this.gOE != null) {
            this.gOE.setFrom(this.mFrom);
            this.gOE.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bcd() {
        if (this.gOE != null && this.mHasMore) {
            this.gOE.setFrom(this.mFrom);
            this.gOE.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gOE != null) {
            this.gOE.setId(this.mId);
        }
    }

    public void Bk(String str) {
        this.st_type = str;
        if (this.gOE != null) {
            this.gOE.Bk(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gOE != null) {
            this.gOE.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.gOF = videoSerializeVideoThreadInfo;
        if (this.gOE != null) {
            this.gOE.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo bLy() {
        return this.gOF;
    }

    public void bGt() {
        if (this.gOE != null) {
            this.gOE.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.gOE != null) {
            return this.gOE.getPageNum();
        }
        return 0;
    }
}
