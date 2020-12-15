package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes22.dex */
public class i {
    private VideoAggregationModel.a jaW = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.jbc != null) {
                i.this.jbc.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.jbc.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void ws(String str) {
            if (i.this.jbc != null) {
                i.this.jbc.hideLoadingView();
                i.this.jbc.showMsg(str);
                i.this.jbc.awW();
            }
        }
    };
    private d jbc;
    private VideoAggregationModel jbd;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.jbc = dVar;
        this.jbd = new VideoAggregationModel(tbPageContext, this.jaW);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jbd != null) {
            this.jbd.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jbd != null) {
            this.jbd.setFrom(str);
        }
    }

    public void KP(String str) {
        this.st_type = str;
        if (this.jbd != null) {
            this.jbd.KP(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jbd != null) {
            this.jbd.setLocation(str);
        }
    }

    public void cFg() {
        if (this.jbd != null) {
            this.jbd.cFg();
        }
    }

    public void cFi() {
        if (this.jbd != null && this.mHasMore) {
            this.jbd.LoadData();
        }
    }

    public void cFh() {
        if (this.jbd != null) {
            this.jbd.cancelLoadData();
        }
    }
}
