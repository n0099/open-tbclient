package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private VideoAggregationModel.a fAh = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.fAn != null) {
                i.this.fAn.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.fAn.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void xc(String str) {
            if (i.this.fAn != null) {
                i.this.fAn.hideLoadingView();
                i.this.fAn.showMsg(str);
                i.this.fAn.ati();
            }
        }
    };
    private d fAn;
    private VideoAggregationModel fAo;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fAn = dVar;
        this.fAo = new VideoAggregationModel(tbPageContext, this.fAh);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.fAo != null) {
            this.fAo.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.fAo != null) {
            this.fAo.setFrom(str);
        }
    }

    public void xb(String str) {
        this.st_type = str;
        if (this.fAo != null) {
            this.fAo.xb(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.fAo != null) {
            this.fAo.setLocation(str);
        }
    }

    public void bor() {
        if (this.fAo != null) {
            this.fAo.bor();
        }
    }

    public void bot() {
        if (this.fAo != null && this.mHasMore) {
            this.fAo.LoadData();
        }
    }

    public void bos() {
        if (this.fAo != null) {
            this.fAo.cancelLoadData();
        }
    }
}
