package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a heY = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.hfe != null) {
                i.this.hfe.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.hfe.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void pj(String str) {
            if (i.this.hfe != null) {
                i.this.hfe.hideLoadingView();
                i.this.hfe.showMsg(str);
                i.this.hfe.aab();
            }
        }
    };
    private d hfe;
    private VideoAggregationModel hff;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.hfe = dVar;
        this.hff = new VideoAggregationModel(tbPageContext, this.heY);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hff != null) {
            this.hff.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.hff != null) {
            this.hff.setFrom(str);
        }
    }

    public void CZ(String str) {
        this.st_type = str;
        if (this.hff != null) {
            this.hff.CZ(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hff != null) {
            this.hff.setLocation(str);
        }
    }

    public void bRh() {
        if (this.hff != null) {
            this.hff.bRh();
        }
    }

    public void bRj() {
        if (this.hff != null && this.mHasMore) {
            this.hff.LoadData();
        }
    }

    public void bRi() {
        if (this.hff != null) {
            this.hff.cancelLoadData();
        }
    }
}
