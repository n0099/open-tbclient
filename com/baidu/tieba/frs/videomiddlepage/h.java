package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private g.b gOF;
    private VideoMiddleModel gOG;
    private VideoSerializeVideoThreadInfo gOH;
    private VideoMiddleModel.a gOI = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.gOF != null) {
                h.this.gOF.hideLoadingView();
                h.this.mHasMore = z;
                h.this.gOF.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nV(String str) {
            if (h.this.gOF != null) {
                h.this.gOF.hideLoadingView();
                h.this.gOF.showMsg(str);
                h.this.gOF.Sk();
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
            this.gOF = bVar;
            this.gOF.a(this);
            this.gOG = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.gOI);
        }
    }

    public void bLz() {
        if (this.gOG != null) {
            this.gOG.setFrom(this.mFrom);
            this.gOG.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bcf() {
        if (this.gOG != null && this.mHasMore) {
            this.gOG.setFrom(this.mFrom);
            this.gOG.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gOG != null) {
            this.gOG.setId(this.mId);
        }
    }

    public void Bk(String str) {
        this.st_type = str;
        if (this.gOG != null) {
            this.gOG.Bk(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gOG != null) {
            this.gOG.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.gOH = videoSerializeVideoThreadInfo;
        if (this.gOG != null) {
            this.gOG.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo bLA() {
        return this.gOH;
    }

    public void bGv() {
        if (this.gOG != null) {
            this.gOG.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.gOG != null) {
            return this.gOG.getPageNum();
        }
        return 0;
    }
}
