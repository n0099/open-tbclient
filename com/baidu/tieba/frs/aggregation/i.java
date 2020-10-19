package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes22.dex */
public class i {
    private VideoAggregationModel.a iwX = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.ixd != null) {
                i.this.ixd.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.ixd.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vj(String str) {
            if (i.this.ixd != null) {
                i.this.ixd.hideLoadingView();
                i.this.ixd.showMsg(str);
                i.this.ixd.aqb();
            }
        }
    };
    private d ixd;
    private VideoAggregationModel ixe;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.ixd = dVar;
        this.ixe = new VideoAggregationModel(tbPageContext, this.iwX);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.ixe != null) {
            this.ixe.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ixe != null) {
            this.ixe.setFrom(str);
        }
    }

    public void JH(String str) {
        this.st_type = str;
        if (this.ixe != null) {
            this.ixe.JH(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.ixe != null) {
            this.ixe.setLocation(str);
        }
    }

    public void cvE() {
        if (this.ixe != null) {
            this.ixe.cvE();
        }
    }

    public void cvG() {
        if (this.ixe != null && this.mHasMore) {
            this.ixe.LoadData();
        }
    }

    public void cvF() {
        if (this.ixe != null) {
            this.ixe.cancelLoadData();
        }
    }
}
