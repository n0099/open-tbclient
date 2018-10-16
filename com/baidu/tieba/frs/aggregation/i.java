package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dFU = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.dGa != null) {
                i.this.dGa.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.dGa.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nH(String str) {
            if (i.this.dGa != null) {
                i.this.dGa.hideLoadingView();
                i.this.dGa.showMsg(str);
                i.this.dGa.LP();
            }
        }
    };
    private d dGa;
    private VideoAggregationModel dGb;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dGa = dVar;
        this.dGb = new VideoAggregationModel(tbPageContext, this.dFU);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dGb != null) {
            this.dGb.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dGb != null) {
            this.dGb.setFrom(str);
        }
    }

    public void nG(String str) {
        this.st_type = str;
        if (this.dGb != null) {
            this.dGb.nG(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dGb != null) {
            this.dGb.setLocation(str);
        }
    }

    public void aBU() {
        if (this.dGb != null) {
            this.dGb.aBU();
        }
    }

    public void aBW() {
        if (this.dGb != null && this.mHasMore) {
            this.dGb.LoadData();
        }
    }

    public void aBV() {
        if (this.dGb != null) {
            this.dGb.cancelLoadData();
        }
    }
}
