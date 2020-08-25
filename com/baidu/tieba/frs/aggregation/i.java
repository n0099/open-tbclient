package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes16.dex */
public class i {
    private VideoAggregationModel.a iaP = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.iaV != null) {
                i.this.iaV.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.iaV.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void ud(String str) {
            if (i.this.iaV != null) {
                i.this.iaV.hideLoadingView();
                i.this.iaV.showMsg(str);
                i.this.iaV.amF();
            }
        }
    };
    private d iaV;
    private VideoAggregationModel iaW;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.iaV = dVar;
        this.iaW = new VideoAggregationModel(tbPageContext, this.iaP);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iaW != null) {
            this.iaW.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.iaW != null) {
            this.iaW.setFrom(str);
        }
    }

    public void Iw(String str) {
        this.st_type = str;
        if (this.iaW != null) {
            this.iaW.Iw(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iaW != null) {
            this.iaW.setLocation(str);
        }
    }

    public void coT() {
        if (this.iaW != null) {
            this.iaW.coT();
        }
    }

    public void coV() {
        if (this.iaW != null && this.mHasMore) {
            this.iaW.LoadData();
        }
    }

    public void coU() {
        if (this.iaW != null) {
            this.iaW.cancelLoadData();
        }
    }
}
