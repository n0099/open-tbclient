package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a fBi = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.fBo != null) {
                i.this.fBo.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.fBo.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vU(String str) {
            if (i.this.fBo != null) {
                i.this.fBo.hideLoadingView();
                i.this.fBo.showMsg(str);
                i.this.fBo.ave();
            }
        }
    };
    private d fBo;
    private VideoAggregationModel fBp;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fBo = dVar;
        this.fBp = new VideoAggregationModel(tbPageContext, this.fBi);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fBp != null) {
            this.fBp.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.fBp != null) {
            this.fBp.setFrom(str);
        }
    }

    public void vT(String str) {
        this.st_type = str;
        if (this.fBp != null) {
            this.fBp.vT(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fBp != null) {
            this.fBp.setLocation(str);
        }
    }

    public void bms() {
        if (this.fBp != null) {
            this.fBp.bms();
        }
    }

    public void bmu() {
        if (this.fBp != null && this.mHasMore) {
            this.fBp.LoadData();
        }
    }

    public void bmt() {
        if (this.fBp != null) {
            this.fBp.cancelLoadData();
        }
    }
}
