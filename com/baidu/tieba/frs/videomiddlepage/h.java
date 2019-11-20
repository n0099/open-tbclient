package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fUQ;
    private VideoMiddleModel fUR;
    private VideoSerializeVideoThreadInfo fUS;
    private VideoMiddleModel.a fUT = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fUQ != null) {
                h.this.fUQ.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fUQ.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vU(String str) {
            if (h.this.fUQ != null) {
                h.this.fUQ.hideLoadingView();
                h.this.fUQ.showMsg(str);
                h.this.fUQ.ave();
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
            this.fUQ = bVar;
            this.fUQ.a(this);
            this.fUR = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fUT);
        }
    }

    public void brr() {
        if (this.fUR != null) {
            this.fUR.setFrom(this.mFrom);
            this.fUR.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aIU() {
        if (this.fUR != null && this.mHasMore) {
            this.fUR.setFrom(this.mFrom);
            this.fUR.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fUR != null) {
            this.fUR.setId(this.mId);
        }
    }

    public void vT(String str) {
        this.st_type = str;
        if (this.fUR != null) {
            this.fUR.vT(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fUR != null) {
            this.fUR.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fUS = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo brs() {
        return this.fUS;
    }

    public void bmt() {
        if (this.fUR != null) {
            this.fUR.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fUR != null) {
            return this.fUR.getPageNum();
        }
        return 0;
    }
}
