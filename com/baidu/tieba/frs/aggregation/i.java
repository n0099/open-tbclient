package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a feW = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void d(List<g> list, boolean z, boolean z2) {
            if (i.this.ffc != null) {
                i.this.ffc.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.ffc.c(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void ve(String str) {
            if (i.this.ffc != null) {
                i.this.ffc.hideLoadingView();
                i.this.ffc.showMsg(str);
                i.this.ffc.amY();
            }
        }
    };
    private d ffc;
    private VideoAggregationModel ffd;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.ffc = dVar;
        this.ffd = new VideoAggregationModel(tbPageContext, this.feW);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.ffd != null) {
            this.ffd.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ffd != null) {
            this.ffd.setFrom(str);
        }
    }

    public void vd(String str) {
        this.st_type = str;
        if (this.ffd != null) {
            this.ffd.vd(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.ffd != null) {
            this.ffd.setLocation(str);
        }
    }

    public void beV() {
        if (this.ffd != null) {
            this.ffd.beV();
        }
    }

    public void beX() {
        if (this.ffd != null && this.mHasMore) {
            this.ffd.LoadData();
        }
    }

    public void beW() {
        if (this.ffd != null) {
            this.ffd.cancelLoadData();
        }
    }
}
