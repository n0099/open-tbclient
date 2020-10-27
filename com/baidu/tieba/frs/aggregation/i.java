package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes22.dex */
public class i {
    private VideoAggregationModel iJA;
    private VideoAggregationModel.a iJt = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.iJz != null) {
                i.this.iJz.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.iJz.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void vC(String str) {
            if (i.this.iJz != null) {
                i.this.iJz.hideLoadingView();
                i.this.iJz.showMsg(str);
                i.this.iJz.arV();
            }
        }
    };
    private d iJz;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.iJz = dVar;
        this.iJA = new VideoAggregationModel(tbPageContext, this.iJt);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.iJA != null) {
            this.iJA.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.iJA != null) {
            this.iJA.setFrom(str);
        }
    }

    public void Kg(String str) {
        this.st_type = str;
        if (this.iJA != null) {
            this.iJA.Kg(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.iJA != null) {
            this.iJA.setLocation(str);
        }
    }

    public void cyL() {
        if (this.iJA != null) {
            this.iJA.cyL();
        }
    }

    public void cyN() {
        if (this.iJA != null && this.mHasMore) {
            this.iJA.LoadData();
        }
    }

    public void cyM() {
        if (this.iJA != null) {
            this.iJA.cancelLoadData();
        }
    }
}
