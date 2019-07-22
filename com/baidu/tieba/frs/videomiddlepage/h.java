package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements g.a {
    private g.b fTF;
    private VideoMiddleModel fTG;
    private VideoSerializeVideoThreadInfo fTH;
    private VideoMiddleModel.a fTI = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.fTF != null) {
                h.this.fTF.hideLoadingView();
                h.this.mHasMore = z;
                h.this.fTF.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void xc(String str) {
            if (h.this.fTF != null) {
                h.this.fTF.hideLoadingView();
                h.this.fTF.showMsg(str);
                h.this.fTF.ati();
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
            this.fTF = bVar;
            this.fTF.a(this);
            this.fTG = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.fTI);
        }
    }

    public void btq() {
        if (this.fTG != null) {
            this.fTG.setFrom(this.mFrom);
            this.fTG.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aIQ() {
        if (this.fTG != null && this.mHasMore) {
            this.fTG.setFrom(this.mFrom);
            this.fTG.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fTG != null) {
            this.fTG.setId(this.mId);
        }
    }

    public void xb(String str) {
        this.st_type = str;
        if (this.fTG != null) {
            this.fTG.xb(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fTG != null) {
            this.fTG.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.fTH = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo btr() {
        return this.fTH;
    }

    public void bos() {
        if (this.fTG != null) {
            this.fTG.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.fTG != null) {
            return this.fTG.getPageNum();
        }
        return 0;
    }
}
