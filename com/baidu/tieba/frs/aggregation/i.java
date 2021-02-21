package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private d joD;
    private VideoAggregationModel joE;
    private VideoAggregationModel.a jox = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.joD != null) {
                i.this.joD.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.joD.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vz(String str) {
            if (i.this.joD != null) {
                i.this.joD.hideLoadingView();
                i.this.joD.showMsg(str);
                i.this.joD.onLoadFail();
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
        this.joD = dVar;
        this.joE = new VideoAggregationModel(tbPageContext, this.jox);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.joE != null) {
            this.joE.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.joE != null) {
            this.joE.setFrom(str);
        }
    }

    public void Kp(String str) {
        this.st_type = str;
        if (this.joE != null) {
            this.joE.Kp(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.joE != null) {
            this.joE.setLocation(str);
        }
    }

    public void cFD() {
        if (this.joE != null) {
            this.joE.cFD();
        }
    }

    public void cFF() {
        if (this.joE != null && this.mHasMore) {
            this.joE.LoadData();
        }
    }

    public void cFE() {
        if (this.joE != null) {
            this.joE.cancelLoadData();
        }
    }
}
