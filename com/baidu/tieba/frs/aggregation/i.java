package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a hGN = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.hGT != null) {
                i.this.hGT.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.hGT.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void qP(String str) {
            if (i.this.hGT != null) {
                i.this.hGT.hideLoadingView();
                i.this.hGT.showMsg(str);
                i.this.hGT.aeh();
            }
        }
    };
    private d hGT;
    private VideoAggregationModel hGU;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.hGT = dVar;
        this.hGU = new VideoAggregationModel(tbPageContext, this.hGN);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hGU != null) {
            this.hGU.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.hGU != null) {
            this.hGU.setFrom(str);
        }
    }

    public void Fj(String str) {
        this.st_type = str;
        if (this.hGU != null) {
            this.hGU.Fj(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hGU != null) {
            this.hGU.setLocation(str);
        }
    }

    public void caR() {
        if (this.hGU != null) {
            this.hGU.caR();
        }
    }

    public void caT() {
        if (this.hGU != null && this.mHasMore) {
            this.hGU.LoadData();
        }
    }

    public void caS() {
        if (this.hGU != null) {
            this.hGU.cancelLoadData();
        }
    }
}
