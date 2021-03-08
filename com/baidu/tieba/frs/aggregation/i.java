package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private VideoAggregationModel.a jqg = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.jqm != null) {
                i.this.jqm.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.jqm.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vG(String str) {
            if (i.this.jqm != null) {
                i.this.jqm.hideLoadingView();
                i.this.jqm.showMsg(str);
                i.this.jqm.onLoadFail();
            }
        }
    };
    private d jqm;
    private VideoAggregationModel jqn;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.jqm = dVar;
        this.jqn = new VideoAggregationModel(tbPageContext, this.jqg);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jqn != null) {
            this.jqn.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jqn != null) {
            this.jqn.setFrom(str);
        }
    }

    public void Ky(String str) {
        this.st_type = str;
        if (this.jqn != null) {
            this.jqn.Ky(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jqn != null) {
            this.jqn.setLocation(str);
        }
    }

    public void cFJ() {
        if (this.jqn != null) {
            this.jqn.cFJ();
        }
    }

    public void cFL() {
        if (this.jqn != null && this.mHasMore) {
            this.jqn.LoadData();
        }
    }

    public void cFK() {
        if (this.jqn != null) {
            this.jqn.cancelLoadData();
        }
    }
}
