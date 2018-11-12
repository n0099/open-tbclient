package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dYJ;
    private VideoMiddleModel dYK;
    private VideoSerializeVideoThreadInfo dYL;
    private VideoMiddleModel.a dYM = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dYJ != null) {
                g.this.dYJ.hideLoadingView();
                g.this.mHasMore = z;
                g.this.dYJ.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nI(String str) {
            if (g.this.dYJ != null) {
                g.this.dYJ.hideLoadingView();
                g.this.dYJ.showMsg(str);
                g.this.dYJ.Mb();
            }
        }
    };
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.dYJ = bVar;
            this.dYJ.a(this);
            this.dYK = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dYM);
        }
    }

    public void aFY() {
        if (this.dYK != null) {
            this.dYK.setFrom(this.mFrom);
            this.dYK.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void YV() {
        if (this.dYK != null && this.mHasMore) {
            this.dYK.setFrom(this.mFrom);
            this.dYK.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dYK != null) {
            this.dYK.setId(this.mId);
        }
    }

    public void nH(String str) {
        this.st_type = str;
        if (this.dYK != null) {
            this.dYK.nH(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dYK != null) {
            this.dYK.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dYL = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aFZ() {
        return this.dYL;
    }

    public void aBt() {
        if (this.dYK != null) {
            this.dYK.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dYK != null) {
            return this.dYK.getPageNum();
        }
        return 0;
    }
}
