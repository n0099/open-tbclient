package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.e;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements e.a {
    private e.b dXf;
    private VideoMiddleModel dXg;
    private VideoSerializeVideoThreadInfo dXh;
    private VideoMiddleModel.a dXi = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
            if (g.this.dXf != null) {
                g.this.dXf.VV();
                g.this.mHasMore = z;
                g.this.dXf.setData(list, z);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void lO(String str) {
            if (g.this.dXf != null) {
                g.this.dXf.VV();
                g.this.dXf.showMsg(str);
                g.this.dXf.Mj();
            }
        }
    };
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(e.b bVar) {
        if (bVar instanceof f) {
            this.dXf = bVar;
            this.dXf.a(this);
            this.dXg = new VideoMiddleModel(((f) bVar).getPageContext(), this.dXi);
        }
    }

    public void aAI() {
        if (this.dXg != null) {
            this.dXg.LoadData();
        }
    }

    public void WO() {
        if (this.dXg != null && this.mHasMore) {
            this.dXg.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dXg != null) {
            this.dXg.setId(this.mId);
        }
    }

    public void lN(String str) {
        this.st_type = str;
        if (this.dXg != null) {
            this.dXg.lN(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dXg != null) {
            this.dXg.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dXh = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aAJ() {
        return this.dXh;
    }

    public void awP() {
        if (this.dXg != null) {
            this.dXg.cancelLoadData();
        }
    }
}
