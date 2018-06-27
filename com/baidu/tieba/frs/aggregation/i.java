package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a doM = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<g> list, boolean z, boolean z2) {
            if (i.this.doS != null) {
                i.this.doS.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.doS.b(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void mB(String str) {
            if (i.this.doS != null) {
                i.this.doS.hideLoadingView();
                i.this.doS.showMsg(str);
                i.this.doS.IG();
            }
        }
    };
    private d doS;
    private VideoAggregationModel doT;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.doS = dVar;
        this.doT = new VideoAggregationModel(tbPageContext, this.doM);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.doT != null) {
            this.doT.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.doT != null) {
            this.doT.setFrom(str);
        }
    }

    public void mA(String str) {
        this.st_type = str;
        if (this.doT != null) {
            this.doT.mA(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.doT != null) {
            this.doT.setLocation(str);
        }
    }

    public void avM() {
        if (this.doT != null) {
            this.doT.avM();
        }
    }

    public void avO() {
        if (this.doT != null && this.mHasMore) {
            this.doT.LoadData();
        }
    }

    public void avN() {
        if (this.doT != null) {
            this.doT.cancelLoadData();
        }
    }
}
