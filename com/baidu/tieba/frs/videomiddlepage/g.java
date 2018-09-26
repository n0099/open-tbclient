package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private VideoMiddleModel dPA;
    private VideoSerializeVideoThreadInfo dPB;
    private VideoMiddleModel.a dPC = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void h(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dPz != null) {
                g.this.dPz.hideLoadingView();
                g.this.mHasMore = z;
                g.this.dPz.b(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void nf(String str) {
            if (g.this.dPz != null) {
                g.this.dPz.hideLoadingView();
                g.this.dPz.showMsg(str);
                g.this.dPz.JR();
            }
        }
    };
    private f.b dPz;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.dPz = bVar;
            this.dPz.a(this);
            this.dPA = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dPC);
        }
    }

    public void aDi() {
        if (this.dPA != null) {
            this.dPA.setFrom(this.mFrom);
            this.dPA.LoadData();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Vd() {
        if (this.dPA != null && this.mHasMore) {
            this.dPA.setFrom(this.mFrom);
            this.dPA.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dPA != null) {
            this.dPA.setId(this.mId);
        }
    }

    public void ne(String str) {
        this.st_type = str;
        if (this.dPA != null) {
            this.dPA.ne(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dPA != null) {
            this.dPA.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dPB = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aDj() {
        return this.dPB;
    }

    public void ayC() {
        if (this.dPA != null) {
            this.dPA.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dPA != null) {
            return this.dPA.getPageNum();
        }
        return 0;
    }
}
