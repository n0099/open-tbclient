package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.e;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements e.a {
    private e.b dWT;
    private VideoMiddleModel dWU;
    private VideoSerializeVideoThreadInfo dWV;
    private VideoMiddleModel.a dWW = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
            if (g.this.dWT != null) {
                g.this.dWT.VU();
                g.this.mHasMore = z;
                g.this.dWT.setData(list, z);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void lO(String str) {
            if (g.this.dWT != null) {
                g.this.dWT.VU();
                g.this.dWT.showMsg(str);
                g.this.dWT.Mi();
            }
        }
    };
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(e.b bVar) {
        if (bVar instanceof f) {
            this.dWT = bVar;
            this.dWT.a(this);
            this.dWU = new VideoMiddleModel(((f) bVar).getPageContext(), this.dWW);
        }
    }

    public void aAH() {
        if (this.dWU != null) {
            this.dWU.LoadData();
        }
    }

    public void WN() {
        if (this.dWU != null && this.mHasMore) {
            this.dWU.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dWU != null) {
            this.dWU.setId(this.mId);
        }
    }

    public void lN(String str) {
        this.st_type = str;
        if (this.dWU != null) {
            this.dWU.lN(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dWU != null) {
            this.dWU.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dWV = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aAI() {
        return this.dWV;
    }

    public void awO() {
        if (this.dWU != null) {
            this.dWU.cancelLoadData();
        }
    }
}
