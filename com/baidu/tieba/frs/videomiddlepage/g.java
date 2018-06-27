package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements f.a {
    private f.b dFI;
    private VideoMiddleModel dFJ;
    private VideoSerializeVideoThreadInfo dFK;
    private VideoMiddleModel.a dFL = new VideoMiddleModel.a() { // from class: com.baidu.tieba.frs.videomiddlepage.g.1
        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void g(List<com.baidu.tieba.card.data.b> list, boolean z) {
            if (g.this.dFI != null) {
                g.this.dFI.hideLoadingView();
                g.this.mHasMore = z;
                g.this.dFI.b(list, z, false);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void mB(String str) {
            if (g.this.dFI != null) {
                g.this.dFI.hideLoadingView();
                g.this.dFI.showMsg(str);
                g.this.dFI.IG();
            }
        }
    };
    private boolean mHasMore;
    private String mId;
    private String st_type;
    private String yuelaou_locate;

    public g(f.b bVar) {
        if (bVar instanceof VideoMiddlePageFragment) {
            this.dFI = bVar;
            this.dFI.a(this);
            this.dFJ = new VideoMiddleModel(((VideoMiddlePageFragment) bVar).getPageContext(), this.dFL);
        }
    }

    public void aAu() {
        if (this.dFJ != null) {
            this.dFJ.LoadData();
        }
    }

    public void Tf() {
        if (this.dFJ != null && this.mHasMore) {
            this.dFJ.LoadData();
        }
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dFJ != null) {
            this.dFJ.setId(this.mId);
        }
    }

    public void mA(String str) {
        this.st_type = str;
        if (this.dFJ != null) {
            this.dFJ.mA(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dFJ != null) {
            this.dFJ.setLocation(str);
        }
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.dFK = videoSerializeVideoThreadInfo;
    }

    public VideoSerializeVideoThreadInfo aAv() {
        return this.dFK;
    }

    public void avN() {
        if (this.dFJ != null) {
            this.dFJ.cancelLoadData();
        }
    }

    public int getPageNum() {
        if (this.dFJ != null) {
            return this.dFJ.getPageNum();
        }
        return 0;
    }
}
