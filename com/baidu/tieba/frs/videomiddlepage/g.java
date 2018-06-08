package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dCv;
    private VideoMiddleModel dCw;
    private VideoSerializeVideoThreadInfo dCx;
    private VideoMiddleModel.a dCy = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void g(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dCv != null) {
                g.this.dCv.hideLoadingView();
                g.this.mHasMore = z;
                g.this.dCv.b(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void mB(String str) {
            if (g.this.dCv != null) {
                g.this.dCv.hideLoadingView();
                g.this.dCv.showMsg(str);
                g.this.dCv.Io();
            }
        }
    };
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.dCv = bVar;
            this.dCv.a(this);
            this.dCw = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dCy);
        }
    }

    public void azN() {
        if (this.dCw != null) {
            this.dCw.LoadData();
        }
    }

    public void SJ() {
        if (this.dCw != null && this.mHasMore) {
            this.dCw.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dCw != null) {
            this.dCw.setId(this.mId);
        }
    }

    public void mA(String str) {
        this.st_type = str;
        if (this.dCw != null) {
            this.dCw.mA(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dCw != null) {
            this.dCw.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dCx = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo azO() {
        return this.dCx;
    }

    public void avk() {
        if (this.dCw != null) {
            this.dCw.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dCw != null) {
            return this.dCw.getPageNum();
        }
        return 0;
    }
}
