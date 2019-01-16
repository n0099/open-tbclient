package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dRf = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.dRl != null) {
                i.this.dRl.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.dRl.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void oC(String str) {
            if (i.this.dRl != null) {
                i.this.dRl.hideLoadingView();
                i.this.dRl.showMsg(str);
                i.this.dRl.Nx();
            }
        }
    };
    private d dRl;
    private VideoAggregationModel dRm;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dRl = dVar;
        this.dRm = new VideoAggregationModel(tbPageContext, this.dRf);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dRm != null) {
            this.dRm.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dRm != null) {
            this.dRm.setFrom(str);
        }
    }

    public void oB(String str) {
        this.st_type = str;
        if (this.dRm != null) {
            this.dRm.oB(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dRm != null) {
            this.dRm.setLocation(str);
        }
    }

    public void aEo() {
        if (this.dRm != null) {
            this.dRm.aEo();
        }
    }

    public void aEq() {
        if (this.dRm != null && this.mHasMore) {
            this.dRm.LoadData();
        }
    }

    public void aEp() {
        if (this.dRm != null) {
            this.dRm.cancelLoadData();
        }
    }
}
