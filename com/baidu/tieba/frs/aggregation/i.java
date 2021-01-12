package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private VideoAggregationModel.a jiC = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.jiI != null) {
                i.this.jiI.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.jiI.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vg(String str) {
            if (i.this.jiI != null) {
                i.this.jiI.hideLoadingView();
                i.this.jiI.showMsg(str);
                i.this.jiI.onLoadFail();
            }
        }
    };
    private d jiI;
    private VideoAggregationModel jiJ;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.jiI = dVar;
        this.jiJ = new VideoAggregationModel(tbPageContext, this.jiC);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jiJ != null) {
            this.jiJ.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jiJ != null) {
            this.jiJ.setFrom(str);
        }
    }

    public void JD(String str) {
        this.st_type = str;
        if (this.jiJ != null) {
            this.jiJ.JD(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jiJ != null) {
            this.jiJ.setLocation(str);
        }
    }

    public void cEj() {
        if (this.jiJ != null) {
            this.jiJ.cEj();
        }
    }

    public void cEl() {
        if (this.jiJ != null && this.mHasMore) {
            this.jiJ.LoadData();
        }
    }

    public void cEk() {
        if (this.jiJ != null) {
            this.jiJ.cancelLoadData();
        }
    }
}
