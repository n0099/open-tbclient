package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.e;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements e.a {
    private e.b dWZ;
    private VideoMiddleModel dXa;
    private VideoSerializeVideoThreadInfo dXb;
    private VideoMiddleModel.a dXc = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
            if (g.this.dWZ != null) {
                g.this.dWZ.VV();
                g.this.mHasMore = z;
                g.this.dWZ.setData(list, z);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void lO(String str) {
            if (g.this.dWZ != null) {
                g.this.dWZ.VV();
                g.this.dWZ.showMsg(str);
                g.this.dWZ.Mj();
            }
        }
    };
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(e.b bVar) {
        if (bVar instanceof f) {
            this.dWZ = bVar;
            this.dWZ.a(this);
            this.dXa = new VideoMiddleModel(((f) bVar).getPageContext(), this.dXc);
        }
    }

    public void aAJ() {
        if (this.dXa != null) {
            this.dXa.LoadData();
        }
    }

    public void WO() {
        if (this.dXa != null && this.mHasMore) {
            this.dXa.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dXa != null) {
            this.dXa.setId(this.mId);
        }
    }

    public void lN(String str) {
        this.st_type = str;
        if (this.dXa != null) {
            this.dXa.lN(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dXa != null) {
            this.dXa.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dXb = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aAK() {
        return this.dXb;
    }

    public void awQ() {
        if (this.dXa != null) {
            this.dXa.cancelLoadData();
        }
    }
}
