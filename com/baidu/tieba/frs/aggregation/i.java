package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a drG = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<g> list, boolean z, boolean z2) {
            if (i.this.drM != null) {
                i.this.drM.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.drM.b(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void mA(String str) {
            if (i.this.drM != null) {
                i.this.drM.hideLoadingView();
                i.this.drM.showMsg(str);
                i.this.drM.IB();
            }
        }
    };
    private d drM;
    private VideoAggregationModel drN;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.drM = dVar;
        this.drN = new VideoAggregationModel(tbPageContext, this.drG);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.drN != null) {
            this.drN.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.drN != null) {
            this.drN.setFrom(str);
        }
    }

    public void mz(String str) {
        this.st_type = str;
        if (this.drN != null) {
            this.drN.mz(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.drN != null) {
            this.drN.setLocation(str);
        }
    }

    public void awr() {
        if (this.drN != null) {
            this.drN.awr();
        }
    }

    public void awt() {
        if (this.drN != null && this.mHasMore) {
            this.drN.LoadData();
        }
    }

    public void aws() {
        if (this.drN != null) {
            this.drN.cancelLoadData();
        }
    }
}
