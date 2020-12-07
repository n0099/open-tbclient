package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes22.dex */
public class h implements g.a {
    private g.b jzW;
    private VideoMiddleModel jzX;
    private VideoSerializeVideoThreadInfo jzY;
    private VideoMiddleModel.a jzZ = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.h.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void o(List<BaseCardInfo> list, boolean z) {
            if (h.this.jzW != null) {
                h.this.jzW.hideLoadingView();
                h.this.mHasMore = z;
                h.this.jzW.d(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void ws(String str) {
            if (h.this.jzW != null) {
                h.this.jzW.hideLoadingView();
                h.this.jzW.showMsg(str);
                h.this.jzW.awW();
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
            this.jzW = bVar;
            this.jzW.a(this);
            this.jzX = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.jzZ);
        }
    }

    public void cLP() {
        if (this.jzX != null) {
            this.jzX.setFrom(this.mFrom);
            this.jzX.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bRM() {
        if (this.jzX != null && this.mHasMore) {
            this.jzX.setFrom(this.mFrom);
            this.jzX.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jzX != null) {
            this.jzX.setId(this.mId);
        }
    }

    public void KP(String str) {
        this.st_type = str;
        if (this.jzX != null) {
            this.jzX.KP(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jzX != null) {
            this.jzX.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jzY = videoSerializeVideoThreadInfo;
        if (this.jzX != null) {
            this.jzX.a(videoSerializeVideoThreadInfo);
        }
    }

    public VideoSerializeVideoThreadInfo cLQ() {
        return this.jzY;
    }

    public void cFg() {
        if (this.jzX != null) {
            this.jzX.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.jzX != null) {
            return this.jzX.getPageNum();
        }
        return 0;
    }
}
