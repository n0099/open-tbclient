package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    private VideoAggregationModel.a gsO = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.gsU != null) {
                i.this.gsU.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.gsU.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nG(String str) {
            if (i.this.gsU != null) {
                i.this.gsU.hideLoadingView();
                i.this.gsU.showMsg(str);
                i.this.gsU.PU();
            }
        }
    };
    private d gsU;
    private VideoAggregationModel gsV;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.gsU = dVar;
        this.gsV = new VideoAggregationModel(tbPageContext, this.gsO);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gsV != null) {
            this.gsV.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.gsV != null) {
            this.gsV.setFrom(str);
        }
    }

    public void AU(String str) {
        this.st_type = str;
        if (this.gsV != null) {
            this.gsV.AU(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gsV != null) {
            this.gsV.setLocation(str);
        }
    }

    public void bEQ() {
        if (this.gsV != null) {
            this.gsV.bEQ();
        }
    }

    public void bES() {
        if (this.gsV != null && this.mHasMore) {
            this.gsV.LoadData();
        }
    }

    public void bER() {
        if (this.gsV != null) {
            this.gsV.cancelLoadData();
        }
    }
}
