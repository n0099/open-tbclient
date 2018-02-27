package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dIM = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<f> list, boolean z, boolean z2) {
            if (i.this.dIS != null) {
                i.this.dIS.VU();
                i.this.mHasMore = z2;
                i.this.dIS.a(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void lO(String str) {
            if (i.this.dIS != null) {
                i.this.dIS.VU();
                i.this.dIS.showMsg(str);
                i.this.dIS.Mi();
            }
        }
    };
    private c dIS;
    private VideoAggregationModel dIT;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.dIS = cVar;
        this.dIT = new VideoAggregationModel(tbPageContext, this.dIM);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dIT != null) {
            this.dIT.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dIT != null) {
            this.dIT.setFrom(str);
        }
    }

    public void lN(String str) {
        this.st_type = str;
        if (this.dIT != null) {
            this.dIT.lN(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dIT != null) {
            this.dIT.setLocation(str);
        }
    }

    public void awN() {
        if (this.dIT != null) {
            this.dIT.awN();
        }
    }

    public void awP() {
        if (this.dIT != null && this.mHasMore) {
            this.dIT.LoadData();
        }
    }

    public void awO() {
        if (this.dIT != null) {
            this.dIT.cancelLoadData();
        }
    }
}
