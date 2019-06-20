package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a fvl = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.fvr != null) {
                i.this.fvr.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.fvr.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void wx(String str) {
            if (i.this.fvr != null) {
                i.this.fvr.hideLoadingView();
                i.this.fvr.showMsg(str);
                i.this.fvr.asb();
            }
        }
    };
    private d fvr;
    private VideoAggregationModel fvs;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fvr = dVar;
        this.fvs = new VideoAggregationModel(tbPageContext, this.fvl);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fvs != null) {
            this.fvs.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.fvs != null) {
            this.fvs.setFrom(str);
        }
    }

    public void ww(String str) {
        this.st_type = str;
        if (this.fvs != null) {
            this.fvs.ww(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fvs != null) {
            this.fvs.setLocation(str);
        }
    }

    public void bmq() {
        if (this.fvs != null) {
            this.fvs.bmq();
        }
    }

    public void bms() {
        if (this.fvs != null && this.mHasMore) {
            this.fvs.LoadData();
        }
    }

    public void bmr() {
        if (this.fvs != null) {
            this.fvs.cancelLoadData();
        }
    }
}
