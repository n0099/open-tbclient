package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes16.dex */
public class i {
    private VideoAggregationModel.a iaV = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.ibb != null) {
                i.this.ibb.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.ibb.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void ue(String str) {
            if (i.this.ibb != null) {
                i.this.ibb.hideLoadingView();
                i.this.ibb.showMsg(str);
                i.this.ibb.amF();
            }
        }
    };
    private d ibb;
    private VideoAggregationModel ibc;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.ibb = dVar;
        this.ibc = new VideoAggregationModel(tbPageContext, this.iaV);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.ibc != null) {
            this.ibc.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ibc != null) {
            this.ibc.setFrom(str);
        }
    }

    public void Ix(String str) {
        this.st_type = str;
        if (this.ibc != null) {
            this.ibc.Ix(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.ibc != null) {
            this.ibc.setLocation(str);
        }
    }

    public void coU() {
        if (this.ibc != null) {
            this.ibc.coU();
        }
    }

    public void coW() {
        if (this.ibc != null && this.mHasMore) {
            this.ibc.LoadData();
        }
    }

    public void coV() {
        if (this.ibc != null) {
            this.ibc.cancelLoadData();
        }
    }
}
