package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dsd;
    private VideoMiddleModel dse;
    private VideoSerializeVideoThreadInfo dsf;
    private VideoMiddleModel.a dsg = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void g(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dsd != null) {
                g.this.dsd.Ou();
                g.this.mHasMore = z;
                g.this.dsd.b(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void lR(String str) {
            if (g.this.dsd != null) {
                g.this.dsd.Ou();
                g.this.dsd.showMsg(str);
                g.this.dsd.EM();
            }
        }
    };
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.dsd = bVar;
            this.dsd.a(this);
            this.dse = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dsg);
        }
    }

    public void avF() {
        if (this.dse != null) {
            this.dse.LoadData();
        }
    }

    public void Po() {
        if (this.dse != null && this.mHasMore) {
            this.dse.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dse != null) {
            this.dse.setId(this.mId);
        }
    }

    public void lQ(String str) {
        this.st_type = str;
        if (this.dse != null) {
            this.dse.lQ(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dse != null) {
            this.dse.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dsf = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo avG() {
        return this.dsf;
    }

    public void arg() {
        if (this.dse != null) {
            this.dse.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dse != null) {
            return this.dse.getPageNum();
        }
        return 0;
    }
}
