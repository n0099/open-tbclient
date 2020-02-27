package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a guP = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.guV != null) {
                i.this.guV.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.guV.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nV(String str) {
            if (i.this.guV != null) {
                i.this.guV.hideLoadingView();
                i.this.guV.showMsg(str);
                i.this.guV.Si();
            }
        }
    };
    private d guV;
    private VideoAggregationModel guW;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.guV = dVar;
        this.guW = new VideoAggregationModel(tbPageContext, this.guP);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.guW != null) {
            this.guW.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.guW != null) {
            this.guW.setFrom(str);
        }
    }

    public void Bk(String str) {
        this.st_type = str;
        if (this.guW != null) {
            this.guW.Bk(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.guW != null) {
            this.guW.setLocation(str);
        }
    }

    public void bGs() {
        if (this.guW != null) {
            this.guW.bGs();
        }
    }

    public void bGu() {
        if (this.guW != null && this.mHasMore) {
            this.guW.LoadData();
        }
    }

    public void bGt() {
        if (this.guW != null) {
            this.guW.cancelLoadData();
        }
    }
}
