package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes22.dex */
public class i {
    private VideoAggregationModel.a jaU = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.jba != null) {
                i.this.jba.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.jba.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void ws(String str) {
            if (i.this.jba != null) {
                i.this.jba.hideLoadingView();
                i.this.jba.showMsg(str);
                i.this.jba.awW();
            }
        }
    };
    private d jba;
    private VideoAggregationModel jbb;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.jba = dVar;
        this.jbb = new VideoAggregationModel(tbPageContext, this.jaU);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jbb != null) {
            this.jbb.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jbb != null) {
            this.jbb.setFrom(str);
        }
    }

    public void KP(String str) {
        this.st_type = str;
        if (this.jbb != null) {
            this.jbb.KP(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jbb != null) {
            this.jbb.setLocation(str);
        }
    }

    public void cFf() {
        if (this.jbb != null) {
            this.jbb.cFf();
        }
    }

    public void cFh() {
        if (this.jbb != null && this.mHasMore) {
            this.jbb.LoadData();
        }
    }

    public void cFg() {
        if (this.jbb != null) {
            this.jbb.cancelLoadData();
        }
    }
}
