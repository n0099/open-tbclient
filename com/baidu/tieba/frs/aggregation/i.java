package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dNI = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.dNO != null) {
                i.this.dNO.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.dNO.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void oi(String str) {
            if (i.this.dNO != null) {
                i.this.dNO.hideLoadingView();
                i.this.dNO.showMsg(str);
                i.this.dNO.Nf();
            }
        }
    };
    private d dNO;
    private VideoAggregationModel dNP;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dNO = dVar;
        this.dNP = new VideoAggregationModel(tbPageContext, this.dNI);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dNP != null) {
            this.dNP.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dNP != null) {
            this.dNP.setFrom(str);
        }
    }

    public void oh(String str) {
        this.st_type = str;
        if (this.dNP != null) {
            this.dNP.oh(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dNP != null) {
            this.dNP.setLocation(str);
        }
    }

    public void aDc() {
        if (this.dNP != null) {
            this.dNP.aDc();
        }
    }

    public void aDe() {
        if (this.dNP != null && this.mHasMore) {
            this.dNP.LoadData();
        }
    }

    public void aDd() {
        if (this.dNP != null) {
            this.dNP.cancelLoadData();
        }
    }
}
