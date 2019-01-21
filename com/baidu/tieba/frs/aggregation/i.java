package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dRg = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.dRm != null) {
                i.this.dRm.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.dRm.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void oC(String str) {
            if (i.this.dRm != null) {
                i.this.dRm.hideLoadingView();
                i.this.dRm.showMsg(str);
                i.this.dRm.Nx();
            }
        }
    };
    private d dRm;
    private VideoAggregationModel dRn;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dRm = dVar;
        this.dRn = new VideoAggregationModel(tbPageContext, this.dRg);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dRn != null) {
            this.dRn.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dRn != null) {
            this.dRn.setFrom(str);
        }
    }

    public void oB(String str) {
        this.st_type = str;
        if (this.dRn != null) {
            this.dRn.oB(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dRn != null) {
            this.dRn.setLocation(str);
        }
    }

    public void aEo() {
        if (this.dRn != null) {
            this.dRn.aEo();
        }
    }

    public void aEq() {
        if (this.dRn != null && this.mHasMore) {
            this.dRn.LoadData();
        }
    }

    public void aEp() {
        if (this.dRn != null) {
            this.dRn.cancelLoadData();
        }
    }
}
