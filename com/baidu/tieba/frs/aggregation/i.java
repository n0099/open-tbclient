package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a fCI = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.fCO != null) {
                i.this.fCO.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.fCO.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void xC(String str) {
            if (i.this.fCO != null) {
                i.this.fCO.hideLoadingView();
                i.this.fCO.showMsg(str);
                i.this.fCO.atw();
            }
        }
    };
    private d fCO;
    private VideoAggregationModel fCP;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fCO = dVar;
        this.fCP = new VideoAggregationModel(tbPageContext, this.fCI);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fCP != null) {
            this.fCP.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.fCP != null) {
            this.fCP.setFrom(str);
        }
    }

    public void xB(String str) {
        this.st_type = str;
        if (this.fCP != null) {
            this.fCP.xB(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fCP != null) {
            this.fCP.setLocation(str);
        }
    }

    public void bpp() {
        if (this.fCP != null) {
            this.fCP.bpp();
        }
    }

    public void bpr() {
        if (this.fCP != null && this.mHasMore) {
            this.fCP.LoadData();
        }
    }

    public void bpq() {
        if (this.fCP != null) {
            this.fCP.cancelLoadData();
        }
    }
}
