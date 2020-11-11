package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes22.dex */
public class i {
    private VideoAggregationModel.a iPq = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.iPw != null) {
                i.this.iPw.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.iPw.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vQ(String str) {
            if (i.this.iPw != null) {
                i.this.iPw.hideLoadingView();
                i.this.iPw.showMsg(str);
                i.this.iPw.auw();
            }
        }
    };
    private d iPw;
    private VideoAggregationModel iPx;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.iPw = dVar;
        this.iPx = new VideoAggregationModel(tbPageContext, this.iPq);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iPx != null) {
            this.iPx.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.iPx != null) {
            this.iPx.setFrom(str);
        }
    }

    public void Kx(String str) {
        this.st_type = str;
        if (this.iPx != null) {
            this.iPx.Kx(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iPx != null) {
            this.iPx.setLocation(str);
        }
    }

    public void cBm() {
        if (this.iPx != null) {
            this.iPx.cBm();
        }
    }

    public void cBo() {
        if (this.iPx != null && this.mHasMore) {
            this.iPx.LoadData();
        }
    }

    public void cBn() {
        if (this.iPx != null) {
            this.iPx.cancelLoadData();
        }
    }
}
