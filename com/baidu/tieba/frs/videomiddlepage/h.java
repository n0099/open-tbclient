package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes22.dex */
public class h implements g.a {
    private g.b jlJ;
    private VideoMiddleModel jlK;
    private VideoSerializeVideoThreadInfo jlL;
    private VideoMiddleModel.a jlM = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.jlJ != null) {
                h.this.jlJ.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jlJ.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vQ(String str) {
            if (h.this.jlJ != null) {
                h.this.jlJ.hideLoadingView();
                h.this.jlJ.showMsg(str);
                h.this.jlJ.auw();
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
            this.jlJ = bVar;
            this.jlJ.a(this);
            this.jlK = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jlM);
        }
    }

    public void cGV() {
        if (this.jlK != null) {
            this.jlK.setFrom(this.mFrom);
            this.jlK.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bOI() {
        if (this.jlK != null && this.mHasMore) {
            this.jlK.setFrom(this.mFrom);
            this.jlK.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jlK != null) {
            this.jlK.setId(this.mId);
        }
    }

    public void Kx(String str) {
        this.st_type = str;
        if (this.jlK != null) {
            this.jlK.Kx(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jlK != null) {
            this.jlK.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jlL = videoSerializeVideoThreadInfo;
        if (this.jlK != null) {
            this.jlK.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cGW() {
        return this.jlL;
    }

    public void cBn() {
        if (this.jlK != null) {
            this.jlK.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jlK != null) {
            return this.jlK.getPageNum();
        }
        return 0;
    }
}
