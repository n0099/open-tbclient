package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements g.a {
    private g.b gOR;
    private VideoMiddleModel gOS;
    private VideoSerializeVideoThreadInfo gOT;
    private VideoMiddleModel.a gOU = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (h.this.gOR != null) {
                h.this.gOR.hideLoadingView();
                h.this.mHasMore = z;
                h.this.gOR.e(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nV(String str) {
            if (h.this.gOR != null) {
                h.this.gOR.hideLoadingView();
                h.this.gOR.showMsg(str);
                h.this.gOR.Sk();
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
            this.gOR = bVar;
            this.gOR.a(this);
            this.gOS = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.gOU);
        }
    }

    public void bLA() {
        if (this.gOS != null) {
            this.gOS.setFrom(this.mFrom);
            this.gOS.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bcg() {
        if (this.gOS != null && this.mHasMore) {
            this.gOS.setFrom(this.mFrom);
            this.gOS.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gOS != null) {
            this.gOS.setId(this.mId);
        }
    }

    public void Bl(String str) {
        this.st_type = str;
        if (this.gOS != null) {
            this.gOS.Bl(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gOS != null) {
            this.gOS.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.gOT = videoSerializeVideoThreadInfo;
        if (this.gOS != null) {
            this.gOS.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo bLB() {
        return this.gOT;
    }

    public void bGw() {
        if (this.gOS != null) {
            this.gOS.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.gOS != null) {
            return this.gOS.getPageNum();
        }
        return 0;
    }
}
