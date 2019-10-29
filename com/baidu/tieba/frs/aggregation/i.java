package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a fBZ = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.fCf != null) {
                i.this.fCf.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.fCf.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vU(String str) {
            if (i.this.fCf != null) {
                i.this.fCf.hideLoadingView();
                i.this.fCf.showMsg(str);
                i.this.fCf.avg();
            }
        }
    };
    private d fCf;
    private VideoAggregationModel fCg;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fCf = dVar;
        this.fCg = new VideoAggregationModel(tbPageContext, this.fBZ);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fCg != null) {
            this.fCg.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.fCg != null) {
            this.fCg.setFrom(str);
        }
    }

    public void vT(String str) {
        this.st_type = str;
        if (this.fCg != null) {
            this.fCg.vT(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fCg != null) {
            this.fCg.setLocation(str);
        }
    }

    public void bmu() {
        if (this.fCg != null) {
            this.fCg.bmu();
        }
    }

    public void bmw() {
        if (this.fCg != null && this.mHasMore) {
            this.fCg.LoadData();
        }
    }

    public void bmv() {
        if (this.fCg != null) {
            this.fCg.cancelLoadData();
        }
    }
}
