package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dbG = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<g> list, boolean z, boolean z2) {
            if (i.this.dbM != null) {
                i.this.dbM.Ou();
                i.this.mHasMore = z2;
                i.this.dbM.b(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void lR(String str) {
            if (i.this.dbM != null) {
                i.this.dbM.Ou();
                i.this.dbM.showMsg(str);
                i.this.dbM.EM();
            }
        }
    };
    private d dbM;
    private VideoAggregationModel dbN;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dbM = dVar;
        this.dbN = new VideoAggregationModel(tbPageContext, this.dbG);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dbN != null) {
            this.dbN.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dbN != null) {
            this.dbN.setFrom(str);
        }
    }

    public void lQ(String str) {
        this.st_type = str;
        if (this.dbN != null) {
            this.dbN.lQ(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dbN != null) {
            this.dbN.setLocation(str);
        }
    }

    public void arf() {
        if (this.dbN != null) {
            this.dbN.arf();
        }
    }

    public void arh() {
        if (this.dbN != null && this.mHasMore) {
            this.dbN.LoadData();
        }
    }

    public void arg() {
        if (this.dbN != null) {
            this.dbN.cancelLoadData();
        }
    }
}
