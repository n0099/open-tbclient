package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a drD = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<g> list, boolean z, boolean z2) {
            if (i.this.drJ != null) {
                i.this.drJ.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.drJ.b(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void mC(String str) {
            if (i.this.drJ != null) {
                i.this.drJ.hideLoadingView();
                i.this.drJ.showMsg(str);
                i.this.drJ.IB();
            }
        }
    };
    private d drJ;
    private VideoAggregationModel drK;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.drJ = dVar;
        this.drK = new VideoAggregationModel(tbPageContext, this.drD);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.drK != null) {
            this.drK.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.drK != null) {
            this.drK.setFrom(str);
        }
    }

    public void mB(String str) {
        this.st_type = str;
        if (this.drK != null) {
            this.drK.mB(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.drK != null) {
            this.drK.setLocation(str);
        }
    }

    public void awq() {
        if (this.drK != null) {
            this.drK.awq();
        }
    }

    public void aws() {
        if (this.drK != null && this.mHasMore) {
            this.drK.LoadData();
        }
    }

    public void awr() {
        if (this.drK != null) {
            this.drK.cancelLoadData();
        }
    }
}
