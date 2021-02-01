package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private VideoAggregationModel.a joj = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.jop != null) {
                i.this.jop.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.jop.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vz(String str) {
            if (i.this.jop != null) {
                i.this.jop.hideLoadingView();
                i.this.jop.showMsg(str);
                i.this.jop.onLoadFail();
            }
        }
    };
    private d jop;
    private VideoAggregationModel joq;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.jop = dVar;
        this.joq = new VideoAggregationModel(tbPageContext, this.joj);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.joq != null) {
            this.joq.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.joq != null) {
            this.joq.setFrom(str);
        }
    }

    public void Ko(String str) {
        this.st_type = str;
        if (this.joq != null) {
            this.joq.Ko(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.joq != null) {
            this.joq.setLocation(str);
        }
    }

    public void cFw() {
        if (this.joq != null) {
            this.joq.cFw();
        }
    }

    public void cFy() {
        if (this.joq != null && this.mHasMore) {
            this.joq.LoadData();
        }
    }

    public void cFx() {
        if (this.joq != null) {
            this.joq.cancelLoadData();
        }
    }
}
