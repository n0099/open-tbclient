package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes16.dex */
public class i {
    private VideoAggregationModel.a hMI = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.hMO != null) {
                i.this.hMO.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.hMO.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void rL(String str) {
            if (i.this.hMO != null) {
                i.this.hMO.hideLoadingView();
                i.this.hMO.showMsg(str);
                i.this.hMO.afy();
            }
        }
    };
    private d hMO;
    private VideoAggregationModel hMP;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.hMO = dVar;
        this.hMP = new VideoAggregationModel(tbPageContext, this.hMI);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hMP != null) {
            this.hMP.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.hMP != null) {
            this.hMP.setFrom(str);
        }
    }

    public void FU(String str) {
        this.st_type = str;
        if (this.hMP != null) {
            this.hMP.FU(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hMP != null) {
            this.hMP.setLocation(str);
        }
    }

    public void cep() {
        if (this.hMP != null) {
            this.hMP.cep();
        }
    }

    public void cer() {
        if (this.hMP != null && this.mHasMore) {
            this.hMP.LoadData();
        }
    }

    public void ceq() {
        if (this.hMP != null) {
            this.hMP.cancelLoadData();
        }
    }
}
