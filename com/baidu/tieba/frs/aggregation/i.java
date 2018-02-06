package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dIY = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<f> list, boolean z, boolean z2) {
            if (i.this.dJe != null) {
                i.this.dJe.VV();
                i.this.mHasMore = z2;
                i.this.dJe.a(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void lO(String str) {
            if (i.this.dJe != null) {
                i.this.dJe.VV();
                i.this.dJe.showMsg(str);
                i.this.dJe.Mj();
            }
        }
    };
    private c dJe;
    private VideoAggregationModel dJf;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.dJe = cVar;
        this.dJf = new VideoAggregationModel(tbPageContext, this.dIY);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dJf != null) {
            this.dJf.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dJf != null) {
            this.dJf.setFrom(str);
        }
    }

    public void lN(String str) {
        this.st_type = str;
        if (this.dJf != null) {
            this.dJf.lN(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dJf != null) {
            this.dJf.setLocation(str);
        }
    }

    public void awO() {
        if (this.dJf != null) {
            this.dJf.awO();
        }
    }

    public void awQ() {
        if (this.dJf != null && this.mHasMore) {
            this.dJf.LoadData();
        }
    }

    public void awP() {
        if (this.dJf != null) {
            this.dJf.cancelLoadData();
        }
    }
}
