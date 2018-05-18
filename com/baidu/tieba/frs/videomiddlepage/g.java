package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dti;
    private VideoMiddleModel dtj;
    private VideoSerializeVideoThreadInfo dtk;
    private VideoMiddleModel.a dtl = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void g(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dti != null) {
                g.this.dti.Os();
                g.this.mHasMore = z;
                g.this.dti.b(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void lU(String str) {
            if (g.this.dti != null) {
                g.this.dti.Os();
                g.this.dti.showMsg(str);
                g.this.dti.EK();
            }
        }
    };
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.dti = bVar;
            this.dti.a(this);
            this.dtj = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dtl);
        }
    }

    public void avE() {
        if (this.dtj != null) {
            this.dtj.LoadData();
        }
    }

    public void Pl() {
        if (this.dtj != null && this.mHasMore) {
            this.dtj.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dtj != null) {
            this.dtj.setId(this.mId);
        }
    }

    public void lT(String str) {
        this.st_type = str;
        if (this.dtj != null) {
            this.dtj.lT(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dtj != null) {
            this.dtj.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dtk = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo avF() {
        return this.dtk;
    }

    public void arf() {
        if (this.dtj != null) {
            this.dtj.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dtj != null) {
            return this.dtj.getPageNum();
        }
        return 0;
    }
}
