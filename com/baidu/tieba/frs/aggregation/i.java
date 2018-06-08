package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private VideoAggregationModel.a dma = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void c(List<g> list, boolean z, boolean z2) {
            if (i.this.dmg != null) {
                i.this.dmg.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.dmg.b(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void mB(String str) {
            if (i.this.dmg != null) {
                i.this.dmg.hideLoadingView();
                i.this.dmg.showMsg(str);
                i.this.dmg.Io();
            }
        }
    };
    private d dmg;
    private VideoAggregationModel dmh;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.dmg = dVar;
        this.dmh = new VideoAggregationModel(tbPageContext, this.dma);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.dmh != null) {
            this.dmh.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.dmh != null) {
            this.dmh.setFrom(str);
        }
    }

    public void mA(String str) {
        this.st_type = str;
        if (this.dmh != null) {
            this.dmh.mA(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.dmh != null) {
            this.dmh.setLocation(str);
        }
    }

    public void avj() {
        if (this.dmh != null) {
            this.dmh.avj();
        }
    }

    public void avl() {
        if (this.dmh != null && this.mHasMore) {
            this.dmh.LoadData();
        }
    }

    public void avk() {
        if (this.dmh != null) {
            this.dmh.cancelLoadData();
        }
    }
}
