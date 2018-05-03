package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dbD = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<g> list, boolean z, boolean z2) {
            if (i.this.dbJ != null) {
                i.this.dbJ.Ou();
                i.this.mHasMore = z2;
                i.this.dbJ.b(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void lR(String str) {
            if (i.this.dbJ != null) {
                i.this.dbJ.Ou();
                i.this.dbJ.showMsg(str);
                i.this.dbJ.EM();
            }
        }
    };
    private d dbJ;
    private VideoAggregationModel dbK;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dbJ = dVar;
        this.dbK = new VideoAggregationModel(tbPageContext, this.dbD);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dbK != null) {
            this.dbK.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dbK != null) {
            this.dbK.setFrom(str);
        }
    }

    public void lQ(String str) {
        this.st_type = str;
        if (this.dbK != null) {
            this.dbK.lQ(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dbK != null) {
            this.dbK.setLocation(str);
        }
    }

    public void arf() {
        if (this.dbK != null) {
            this.dbK.arf();
        }
    }

    public void arh() {
        if (this.dbK != null && this.mHasMore) {
            this.dbK.LoadData();
        }
    }

    public void arg() {
        if (this.dbK != null) {
            this.dbK.cancelLoadData();
        }
    }
}
