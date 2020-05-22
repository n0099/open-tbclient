package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a htM = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.htS != null) {
                i.this.htS.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.htS.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void qH(String str) {
            if (i.this.htS != null) {
                i.this.htS.hideLoadingView();
                i.this.htS.showMsg(str);
                i.this.htS.adb();
            }
        }
    };
    private d htS;
    private VideoAggregationModel htT;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.htS = dVar;
        this.htT = new VideoAggregationModel(tbPageContext, this.htM);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.htT != null) {
            this.htT.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.htT != null) {
            this.htT.setFrom(str);
        }
    }

    public void EI(String str) {
        this.st_type = str;
        if (this.htT != null) {
            this.htT.EI(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.htT != null) {
            this.htT.setLocation(str);
        }
    }

    public void bXD() {
        if (this.htT != null) {
            this.htT.bXD();
        }
    }

    public void bXF() {
        if (this.htT != null && this.mHasMore) {
            this.htT.LoadData();
        }
    }

    public void bXE() {
        if (this.htT != null) {
            this.htT.cancelLoadData();
        }
    }
}
