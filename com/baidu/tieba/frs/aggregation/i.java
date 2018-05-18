package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dcL = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<g> list, boolean z, boolean z2) {
            if (i.this.dcR != null) {
                i.this.dcR.Os();
                i.this.mHasMore = z2;
                i.this.dcR.b(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void lU(String str) {
            if (i.this.dcR != null) {
                i.this.dcR.Os();
                i.this.dcR.showMsg(str);
                i.this.dcR.EK();
            }
        }
    };
    private d dcR;
    private VideoAggregationModel dcS;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dcR = dVar;
        this.dcS = new VideoAggregationModel(tbPageContext, this.dcL);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dcS != null) {
            this.dcS.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dcS != null) {
            this.dcS.setFrom(str);
        }
    }

    public void lT(String str) {
        this.st_type = str;
        if (this.dcS != null) {
            this.dcS.lT(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dcS != null) {
            this.dcS.setLocation(str);
        }
    }

    public void are() {
        if (this.dcS != null) {
            this.dcS.are();
        }
    }

    public void arg() {
        if (this.dcS != null && this.mHasMore) {
            this.dcS.LoadData();
        }
    }

    public void arf() {
        if (this.dcS != null) {
            this.dcS.cancelLoadData();
        }
    }
}
