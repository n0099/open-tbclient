package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dsa;
    private VideoMiddleModel dsb;
    private VideoSerializeVideoThreadInfo dsc;
    private VideoMiddleModel.a dsd = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void g(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dsa != null) {
                g.this.dsa.Ou();
                g.this.mHasMore = z;
                g.this.dsa.b(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void lR(String str) {
            if (g.this.dsa != null) {
                g.this.dsa.Ou();
                g.this.dsa.showMsg(str);
                g.this.dsa.EM();
            }
        }
    };
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.dsa = bVar;
            this.dsa.a(this);
            this.dsb = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dsd);
        }
    }

    public void avF() {
        if (this.dsb != null) {
            this.dsb.LoadData();
        }
    }

    public void Po() {
        if (this.dsb != null && this.mHasMore) {
            this.dsb.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dsb != null) {
            this.dsb.setId(this.mId);
        }
    }

    public void lQ(String str) {
        this.st_type = str;
        if (this.dsb != null) {
            this.dsb.lQ(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dsb != null) {
            this.dsb.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dsc = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo avG() {
        return this.dsc;
    }

    public void arg() {
        if (this.dsb != null) {
            this.dsb.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dsb != null) {
            return this.dsb.getPageNum();
        }
        return 0;
    }
}
