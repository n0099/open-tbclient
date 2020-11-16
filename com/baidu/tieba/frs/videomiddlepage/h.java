package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes21.dex */
public class h implements g.a {
    private g.b jmu;
    private VideoMiddleModel jmv;
    private VideoSerializeVideoThreadInfo jmw;
    private VideoMiddleModel.a jmx = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void n(List<BaseCardInfo> list, boolean z) {
            if (h.this.jmu != null) {
                h.this.jmu.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jmu.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vL(String str) {
            if (h.this.jmu != null) {
                h.this.jmu.hideLoadingView();
                h.this.jmu.showMsg(str);
                h.this.jmu.atO();
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
            this.jmu = bVar;
            this.jmu.a(this);
            this.jmv = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jmx);
        }
    }

    public void cGA() {
        if (this.jmv != null) {
            this.jmv.setFrom(this.mFrom);
            this.jmv.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bOb() {
        if (this.jmv != null && this.mHasMore) {
            this.jmv.setFrom(this.mFrom);
            this.jmv.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jmv != null) {
            this.jmv.setId(this.mId);
        }
    }

    public void JY(String str) {
        this.st_type = str;
        if (this.jmv != null) {
            this.jmv.JY(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jmv != null) {
            this.jmv.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jmw = videoSerializeVideoThreadInfo;
        if (this.jmv != null) {
            this.jmv.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cGB() {
        return this.jmw;
    }

    public void cAQ() {
        if (this.jmv != null) {
            this.jmv.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jmv != null) {
            return this.jmv.getPageNum();
        }
        return 0;
    }
}
