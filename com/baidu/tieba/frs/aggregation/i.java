package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes21.dex */
public class i {
    private VideoAggregationModel.a iQd = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.iQj != null) {
                i.this.iQj.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.iQj.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vL(String str) {
            if (i.this.iQj != null) {
                i.this.iQj.hideLoadingView();
                i.this.iQj.showMsg(str);
                i.this.iQj.atO();
            }
        }
    };
    private d iQj;
    private VideoAggregationModel iQk;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.iQj = dVar;
        this.iQk = new VideoAggregationModel(tbPageContext, this.iQd);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iQk != null) {
            this.iQk.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.iQk != null) {
            this.iQk.setFrom(str);
        }
    }

    public void JY(String str) {
        this.st_type = str;
        if (this.iQk != null) {
            this.iQk.JY(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iQk != null) {
            this.iQk.setLocation(str);
        }
    }

    public void cAP() {
        if (this.iQk != null) {
            this.iQk.cAP();
        }
    }

    public void cAR() {
        if (this.iQk != null && this.mHasMore) {
            this.iQk.LoadData();
        }
    }

    public void cAQ() {
        if (this.iQk != null) {
            this.iQk.cancelLoadData();
        }
    }
}
