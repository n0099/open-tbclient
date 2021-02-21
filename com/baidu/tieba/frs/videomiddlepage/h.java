package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements g.a {
    private g.b jNJ;
    private VideoMiddleModel jNK;
    private VideoSerializeVideoThreadInfo jNL;
    private VideoMiddleModel.a jNM = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void p(List<BaseCardInfo> list, boolean z) {
            if (h.this.jNJ != null) {
                h.this.jNJ.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jNJ.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vz(String str) {
            if (h.this.jNJ != null) {
                h.this.jNJ.hideLoadingView();
                h.this.jNJ.showMsg(str);
                h.this.jNJ.onLoadFail();
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
            this.jNJ = bVar;
            this.jNJ.a(this);
            this.jNK = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jNM);
        }
    }

    public void cMx() {
        if (this.jNK != null) {
            this.jNK.setFrom(this.mFrom);
            this.jNK.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bRj() {
        if (this.jNK != null && this.mHasMore) {
            this.jNK.setFrom(this.mFrom);
            this.jNK.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jNK != null) {
            this.jNK.setId(this.mId);
        }
    }

    public void Kp(String str) {
        this.st_type = str;
        if (this.jNK != null) {
            this.jNK.Kp(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jNK != null) {
            this.jNK.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jNL = videoSerializeVideoThreadInfo;
        if (this.jNK != null) {
            this.jNK.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cMy() {
        return this.jNL;
    }

    public void cFE() {
        if (this.jNK != null) {
            this.jNK.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jNK != null) {
            return this.jNK.getPageNum();
        }
        return 0;
    }
}
