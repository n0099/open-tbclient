package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dHj = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.dHp != null) {
                i.this.dHp.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.dHp.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void nI(String str) {
            if (i.this.dHp != null) {
                i.this.dHp.hideLoadingView();
                i.this.dHp.showMsg(str);
                i.this.dHp.Mb();
            }
        }
    };
    private d dHp;
    private VideoAggregationModel dHq;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dHp = dVar;
        this.dHq = new VideoAggregationModel(tbPageContext, this.dHj);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dHq != null) {
            this.dHq.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dHq != null) {
            this.dHq.setFrom(str);
        }
    }

    public void nH(String str) {
        this.st_type = str;
        if (this.dHq != null) {
            this.dHq.nH(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dHq != null) {
            this.dHq.setLocation(str);
        }
    }

    public void aBs() {
        if (this.dHq != null) {
            this.dHq.aBs();
        }
    }

    public void aBu() {
        if (this.dHq != null && this.mHasMore) {
            this.dHq.LoadData();
        }
    }

    public void aBt() {
        if (this.dHq != null) {
            this.dHq.cancelLoadData();
        }
    }
}
