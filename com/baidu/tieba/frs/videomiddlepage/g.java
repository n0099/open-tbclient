package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b eid;
    private VideoMiddleModel eie;
    private VideoSerializeVideoThreadInfo eif;
    private VideoMiddleModel.a eig = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void i(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.eid != null) {
                g.this.eid.hideLoadingView();
                g.this.mHasMore = z;
                g.this.eid.c(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void ol(String str) {
            if (g.this.eid != null) {
                g.this.eid.hideLoadingView();
                g.this.eid.showMsg(str);
                g.this.eid.Ng();
            }
        }
    };
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.eid = bVar;
            this.eid.a(this);
            this.eie = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.eig);
        }
    }

    public void aIz() {
        if (this.eie != null) {
            this.eie.setFrom(this.mFrom);
            this.eie.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aad() {
        if (this.eie != null && this.mHasMore) {
            this.eie.setFrom(this.mFrom);
            this.eie.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.eie != null) {
            this.eie.setId(this.mId);
        }
    }

    public void ok(String str) {
        this.st_type = str;
        if (this.eie != null) {
            this.eie.ok(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.eie != null) {
            this.eie.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.eif = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aIA() {
        return this.eif;
    }

    public void aDS() {
        if (this.eie != null) {
            this.eie.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.eie != null) {
            return this.eie.getPageNum();
        }
        return 0;
    }
}
