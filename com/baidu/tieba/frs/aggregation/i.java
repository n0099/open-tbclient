package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes16.dex */
public class i {
    private VideoAggregationModel.a hMK = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.hMQ != null) {
                i.this.hMQ.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.hMQ.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void rL(String str) {
            if (i.this.hMQ != null) {
                i.this.hMQ.hideLoadingView();
                i.this.hMQ.showMsg(str);
                i.this.hMQ.afy();
            }
        }
    };
    private d hMQ;
    private VideoAggregationModel hMR;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.hMQ = dVar;
        this.hMR = new VideoAggregationModel(tbPageContext, this.hMK);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hMR != null) {
            this.hMR.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.hMR != null) {
            this.hMR.setFrom(str);
        }
    }

    public void FU(String str) {
        this.st_type = str;
        if (this.hMR != null) {
            this.hMR.FU(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hMR != null) {
            this.hMR.setLocation(str);
        }
    }

    public void cep() {
        if (this.hMR != null) {
            this.hMR.cep();
        }
    }

    public void cer() {
        if (this.hMR != null && this.mHasMore) {
            this.hMR.LoadData();
        }
    }

    public void ceq() {
        if (this.hMR != null) {
            this.hMR.cancelLoadData();
        }
    }
}
