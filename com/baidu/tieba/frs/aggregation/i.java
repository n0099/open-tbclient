package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a gvd = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.gvj != null) {
                i.this.gvj.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.gvj.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nV(String str) {
            if (i.this.gvj != null) {
                i.this.gvj.hideLoadingView();
                i.this.gvj.showMsg(str);
                i.this.gvj.Sk();
            }
        }
    };
    private d gvj;
    private VideoAggregationModel gvk;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.gvj = dVar;
        this.gvk = new VideoAggregationModel(tbPageContext, this.gvd);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.gvk != null) {
            this.gvk.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.gvk != null) {
            this.gvk.setFrom(str);
        }
    }

    public void Bl(String str) {
        this.st_type = str;
        if (this.gvk != null) {
            this.gvk.Bl(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.gvk != null) {
            this.gvk.setLocation(str);
        }
    }

    public void bGv() {
        if (this.gvk != null) {
            this.gvk.bGv();
        }
    }

    public void bGx() {
        if (this.gvk != null && this.mHasMore) {
            this.gvk.LoadData();
        }
    }

    public void bGw() {
        if (this.gvk != null) {
            this.gvk.cancelLoadData();
        }
    }
}
