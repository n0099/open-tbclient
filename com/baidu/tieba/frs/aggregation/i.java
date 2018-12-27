package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private d dQC;
    private VideoAggregationModel dQD;
    private VideoAggregationModel.a dQw = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.dQC != null) {
                i.this.dQC.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.dQC.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void ol(String str) {
            if (i.this.dQC != null) {
                i.this.dQC.hideLoadingView();
                i.this.dQC.showMsg(str);
                i.this.dQC.Ng();
            }
        }
    };
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dQC = dVar;
        this.dQD = new VideoAggregationModel(tbPageContext, this.dQw);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dQD != null) {
            this.dQD.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dQD != null) {
            this.dQD.setFrom(str);
        }
    }

    public void ok(String str) {
        this.st_type = str;
        if (this.dQD != null) {
            this.dQD.ok(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dQD != null) {
            this.dQD.setLocation(str);
        }
    }

    public void aDR() {
        if (this.dQD != null) {
            this.dQD.aDR();
        }
    }

    public void aDT() {
        if (this.dQD != null && this.mHasMore) {
            this.dQD.LoadData();
        }
    }

    public void aDS() {
        if (this.dQD != null) {
            this.dQD.cancelLoadData();
        }
    }
}
