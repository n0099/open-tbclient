package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a fvk = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.fvq != null) {
                i.this.fvq.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.fvq.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void wy(String str) {
            if (i.this.fvq != null) {
                i.this.fvq.hideLoadingView();
                i.this.fvq.showMsg(str);
                i.this.fvq.asb();
            }
        }
    };
    private d fvq;
    private VideoAggregationModel fvr;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fvq = dVar;
        this.fvr = new VideoAggregationModel(tbPageContext, this.fvk);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fvr != null) {
            this.fvr.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.fvr != null) {
            this.fvr.setFrom(str);
        }
    }

    public void wx(String str) {
        this.st_type = str;
        if (this.fvr != null) {
            this.fvr.wx(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fvr != null) {
            this.fvr.setLocation(str);
        }
    }

    public void bmn() {
        if (this.fvr != null) {
            this.fvr.bmn();
        }
    }

    public void bmp() {
        if (this.fvr != null && this.mHasMore) {
            this.fvr.LoadData();
        }
    }

    public void bmo() {
        if (this.fvr != null) {
            this.fvr.cancelLoadData();
        }
    }
}
