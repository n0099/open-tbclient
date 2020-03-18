package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a gvH = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.gvN != null) {
                i.this.gvN.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.gvN.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nU(String str) {
            if (i.this.gvN != null) {
                i.this.gvN.hideLoadingView();
                i.this.gvN.showMsg(str);
                i.this.gvN.Sn();
            }
        }
    };
    private d gvN;
    private VideoAggregationModel gvO;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.gvN = dVar;
        this.gvO = new VideoAggregationModel(tbPageContext, this.gvH);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gvO != null) {
            this.gvO.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.gvO != null) {
            this.gvO.setFrom(str);
        }
    }

    public void Bl(String str) {
        this.st_type = str;
        if (this.gvO != null) {
            this.gvO.Bl(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gvO != null) {
            this.gvO.setLocation(str);
        }
    }

    public void bGH() {
        if (this.gvO != null) {
            this.gvO.bGH();
        }
    }

    public void bGJ() {
        if (this.gvO != null && this.mHasMore) {
            this.gvO.LoadData();
        }
    }

    public void bGI() {
        if (this.gvO != null) {
            this.gvO.cancelLoadData();
        }
    }
}
