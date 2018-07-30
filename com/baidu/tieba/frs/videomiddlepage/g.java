package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private VideoMiddleModel.a dIA = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void g(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dIx != null) {
                g.this.dIx.hideLoadingView();
                g.this.mHasMore = z;
                g.this.dIx.b(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void mA(String str) {
            if (g.this.dIx != null) {
                g.this.dIx.hideLoadingView();
                g.this.dIx.showMsg(str);
                g.this.dIx.IB();
            }
        }
    };
    private f.b dIx;
    private VideoMiddleModel dIy;
    private VideoSerializeVideoThreadInfo dIz;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.dIx = bVar;
            this.dIx.a(this);
            this.dIy = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dIA);
        }
    }

    public void aBd() {
        if (this.dIy != null) {
            this.dIy.setFrom(this.mFrom);
            this.dIy.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Tn() {
        if (this.dIy != null && this.mHasMore) {
            this.dIy.setFrom(this.mFrom);
            this.dIy.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dIy != null) {
            this.dIy.setId(this.mId);
        }
    }

    public void mz(String str) {
        this.st_type = str;
        if (this.dIy != null) {
            this.dIy.mz(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dIy != null) {
            this.dIy.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dIz = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aBe() {
        return this.dIz;
    }

    public void aws() {
        if (this.dIy != null) {
            this.dIy.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dIy != null) {
            return this.dIy.getPageNum();
        }
        return 0;
    }
}
