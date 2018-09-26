package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dxT = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<g> list, boolean z, boolean z2) {
            if (i.this.dxZ != null) {
                i.this.dxZ.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.dxZ.b(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nf(String str) {
            if (i.this.dxZ != null) {
                i.this.dxZ.hideLoadingView();
                i.this.dxZ.showMsg(str);
                i.this.dxZ.JR();
            }
        }
    };
    private d dxZ;
    private VideoAggregationModel dya;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dxZ = dVar;
        this.dya = new VideoAggregationModel(tbPageContext, this.dxT);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dya != null) {
            this.dya.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dya != null) {
            this.dya.setFrom(str);
        }
    }

    public void ne(String str) {
        this.st_type = str;
        if (this.dya != null) {
            this.dya.ne(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dya != null) {
            this.dya.setLocation(str);
        }
    }

    public void ayB() {
        if (this.dya != null) {
            this.dya.ayB();
        }
    }

    public void ayD() {
        if (this.dya != null && this.mHasMore) {
            this.dya.LoadData();
        }
    }

    public void ayC() {
        if (this.dya != null) {
            this.dya.cancelLoadData();
        }
    }
}
