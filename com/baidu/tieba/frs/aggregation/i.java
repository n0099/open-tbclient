package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a ffj = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.ffp != null) {
                i.this.ffp.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.ffp.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vf(String str) {
            if (i.this.ffp != null) {
                i.this.ffp.hideLoadingView();
                i.this.ffp.showMsg(str);
                i.this.ffp.anb();
            }
        }
    };
    private d ffp;
    private VideoAggregationModel ffq;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.ffp = dVar;
        this.ffq = new VideoAggregationModel(tbPageContext, this.ffj);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.ffq != null) {
            this.ffq.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ffq != null) {
            this.ffq.setFrom(str);
        }
    }

    public void ve(String str) {
        this.st_type = str;
        if (this.ffq != null) {
            this.ffq.ve(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.ffq != null) {
            this.ffq.setLocation(str);
        }
    }

    public void beX() {
        if (this.ffq != null) {
            this.ffq.beX();
        }
    }

    public void beZ() {
        if (this.ffq != null && this.mHasMore) {
            this.ffq.LoadData();
        }
    }

    public void beY() {
        if (this.ffq != null) {
            this.ffq.cancelLoadData();
        }
    }
}
