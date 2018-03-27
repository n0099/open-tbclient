package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dIR = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<f> list, boolean z, boolean z2) {
            if (i.this.dIX != null) {
                i.this.dIX.VV();
                i.this.mHasMore = z2;
                i.this.dIX.a(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void lO(String str) {
            if (i.this.dIX != null) {
                i.this.dIX.VV();
                i.this.dIX.showMsg(str);
                i.this.dIX.Mj();
            }
        }
    };
    private c dIX;
    private VideoAggregationModel dIY;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.dIX = cVar;
        this.dIY = new VideoAggregationModel(tbPageContext, this.dIR);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dIY != null) {
            this.dIY.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dIY != null) {
            this.dIY.setFrom(str);
        }
    }

    public void lN(String str) {
        this.st_type = str;
        if (this.dIY != null) {
            this.dIY.lN(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dIY != null) {
            this.dIY.setLocation(str);
        }
    }

    public void awP() {
        if (this.dIY != null) {
            this.dIY.awP();
        }
    }

    public void awR() {
        if (this.dIY != null && this.mHasMore) {
            this.dIY.LoadData();
        }
    }

    public void awQ() {
        if (this.dIY != null) {
            this.dIY.cancelLoadData();
        }
    }
}
