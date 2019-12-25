package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes6.dex */
public class i {
    private VideoAggregationModel.a gpF = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.gpL != null) {
                i.this.gpL.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.gpL.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nD(String str) {
            if (i.this.gpL != null) {
                i.this.gpL.hideLoadingView();
                i.this.gpL.showMsg(str);
                i.this.gpL.Py();
            }
        }
    };
    private d gpL;
    private VideoAggregationModel gpM;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.gpL = dVar;
        this.gpM = new VideoAggregationModel(tbPageContext, this.gpF);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gpM != null) {
            this.gpM.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.gpM != null) {
            this.gpM.setFrom(str);
        }
    }

    public void AK(String str) {
        this.st_type = str;
        if (this.gpM != null) {
            this.gpM.AK(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gpM != null) {
            this.gpM.setLocation(str);
        }
    }

    public void bDO() {
        if (this.gpM != null) {
            this.gpM.bDO();
        }
    }

    public void bDQ() {
        if (this.gpM != null && this.mHasMore) {
            this.gpM.LoadData();
        }
    }

    public void bDP() {
        if (this.gpM != null) {
            this.gpM.cancelLoadData();
        }
    }
}
