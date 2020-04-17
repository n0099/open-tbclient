package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a heS = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.heY != null) {
                i.this.heY.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.heY.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void pj(String str) {
            if (i.this.heY != null) {
                i.this.heY.hideLoadingView();
                i.this.heY.showMsg(str);
                i.this.heY.aac();
            }
        }
    };
    private d heY;
    private VideoAggregationModel heZ;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.heY = dVar;
        this.heZ = new VideoAggregationModel(tbPageContext, this.heS);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.heZ != null) {
            this.heZ.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.heZ != null) {
            this.heZ.setFrom(str);
        }
    }

    public void CW(String str) {
        this.st_type = str;
        if (this.heZ != null) {
            this.heZ.CW(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.heZ != null) {
            this.heZ.setLocation(str);
        }
    }

    public void bRi() {
        if (this.heZ != null) {
            this.heZ.bRi();
        }
    }

    public void bRk() {
        if (this.heZ != null && this.mHasMore) {
            this.heZ.LoadData();
        }
    }

    public void bRj() {
        if (this.heZ != null) {
            this.heZ.cancelLoadData();
        }
    }
}
