package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes21.dex */
public class i {
    private VideoAggregationModel.a iia = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.iig != null) {
                i.this.iig.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.iig.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void ux(String str) {
            if (i.this.iig != null) {
                i.this.iig.hideLoadingView();
                i.this.iig.showMsg(str);
                i.this.iig.anp();
            }
        }
    };
    private d iig;
    private VideoAggregationModel iih;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.iig = dVar;
        this.iih = new VideoAggregationModel(tbPageContext, this.iia);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iih != null) {
            this.iih.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.iih != null) {
            this.iih.setFrom(str);
        }
    }

    public void IU(String str) {
        this.st_type = str;
        if (this.iih != null) {
            this.iih.IU(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iih != null) {
            this.iih.setLocation(str);
        }
    }

    public void csh() {
        if (this.iih != null) {
            this.iih.csh();
        }
    }

    public void csj() {
        if (this.iih != null && this.mHasMore) {
            this.iih.LoadData();
        }
    }

    public void csi() {
        if (this.iih != null) {
            this.iih.cancelLoadData();
        }
    }
}
