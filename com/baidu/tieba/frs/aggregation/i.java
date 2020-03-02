package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a guR = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.guX != null) {
                i.this.guX.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.guX.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nV(String str) {
            if (i.this.guX != null) {
                i.this.guX.hideLoadingView();
                i.this.guX.showMsg(str);
                i.this.guX.Sk();
            }
        }
    };
    private d guX;
    private VideoAggregationModel guY;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.guX = dVar;
        this.guY = new VideoAggregationModel(tbPageContext, this.guR);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.guY != null) {
            this.guY.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.guY != null) {
            this.guY.setFrom(str);
        }
    }

    public void Bk(String str) {
        this.st_type = str;
        if (this.guY != null) {
            this.guY.Bk(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.guY != null) {
            this.guY.setLocation(str);
        }
    }

    public void bGu() {
        if (this.guY != null) {
            this.guY.bGu();
        }
    }

    public void bGw() {
        if (this.guY != null && this.mHasMore) {
            this.guY.LoadData();
        }
    }

    public void bGv() {
        if (this.guY != null) {
            this.guY.cancelLoadData();
        }
    }
}
