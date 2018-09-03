package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dIt;
    private VideoMiddleModel dIu;
    private VideoSerializeVideoThreadInfo dIv;
    private VideoMiddleModel.a dIw = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void g(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dIt != null) {
                g.this.dIt.hideLoadingView();
                g.this.mHasMore = z;
                g.this.dIt.b(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void mC(String str) {
            if (g.this.dIt != null) {
                g.this.dIt.hideLoadingView();
                g.this.dIt.showMsg(str);
                g.this.dIt.IB();
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
            this.dIt = bVar;
            this.dIt.a(this);
            this.dIu = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dIw);
        }
    }

    public void aBa() {
        if (this.dIu != null) {
            this.dIu.setFrom(this.mFrom);
            this.dIu.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Tq() {
        if (this.dIu != null && this.mHasMore) {
            this.dIu.setFrom(this.mFrom);
            this.dIu.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dIu != null) {
            this.dIu.setId(this.mId);
        }
    }

    public void mB(String str) {
        this.st_type = str;
        if (this.dIu != null) {
            this.dIu.mB(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dIu != null) {
            this.dIu.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dIv = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aBb() {
        return this.dIv;
    }

    public void awr() {
        if (this.dIu != null) {
            this.dIu.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dIu != null) {
            return this.dIu.getPageNum();
        }
        return 0;
    }
}
