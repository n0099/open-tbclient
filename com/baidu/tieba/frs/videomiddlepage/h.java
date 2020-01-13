package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes7.dex */
public class h implements g.a {
    private g.b gMD;
    private VideoMiddleModel gME;
    private VideoSerializeVideoThreadInfo gMF;
    private VideoMiddleModel.a gMG = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.gMD != null) {
                h.this.gMD.hideLoadingView();
                h.this.mHasMore = z;
                h.this.gMD.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nG(String str) {
            if (h.this.gMD != null) {
                h.this.gMD.hideLoadingView();
                h.this.gMD.showMsg(str);
                h.this.gMD.PU();
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
            this.gMD = bVar;
            this.gMD.a(this);
            this.gME = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.gMG);
        }
    }

    public void bJV() {
        if (this.gME != null) {
            this.gME.setFrom(this.mFrom);
            this.gME.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aZN() {
        if (this.gME != null && this.mHasMore) {
            this.gME.setFrom(this.mFrom);
            this.gME.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gME != null) {
            this.gME.setId(this.mId);
        }
    }

    public void AU(String str) {
        this.st_type = str;
        if (this.gME != null) {
            this.gME.AU(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gME != null) {
            this.gME.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.gMF = videoSerializeVideoThreadInfo;
        if (this.gME != null) {
            this.gME.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo bJW() {
        return this.gMF;
    }

    public void bER() {
        if (this.gME != null) {
            this.gME.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.gME != null) {
            return this.gME.getPageNum();
        }
        return 0;
    }
}
