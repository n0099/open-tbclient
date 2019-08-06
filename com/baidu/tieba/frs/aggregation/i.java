package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a fAV = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.fBb != null) {
                i.this.fBb.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.fBb.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void xd(String str) {
            if (i.this.fBb != null) {
                i.this.fBb.hideLoadingView();
                i.this.fBb.showMsg(str);
                i.this.fBb.atk();
            }
        }
    };
    private d fBb;
    private VideoAggregationModel fBc;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fBb = dVar;
        this.fBc = new VideoAggregationModel(tbPageContext, this.fAV);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fBc != null) {
            this.fBc.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.fBc != null) {
            this.fBc.setFrom(str);
        }
    }

    public void xc(String str) {
        this.st_type = str;
        if (this.fBc != null) {
            this.fBc.xc(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fBc != null) {
            this.fBc.setLocation(str);
        }
    }

    public void boE() {
        if (this.fBc != null) {
            this.fBc.boE();
        }
    }

    public void boG() {
        if (this.fBc != null && this.mHasMore) {
            this.fBc.LoadData();
        }
    }

    public void boF() {
        if (this.fBc != null) {
            this.fBc.cancelLoadData();
        }
    }
}
