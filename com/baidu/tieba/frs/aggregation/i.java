package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private VideoAggregationModel.a htX = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void f(List<g> list, boolean z, boolean z2) {
            if (i.this.hud != null) {
                i.this.hud.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.hud.e(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void qH(String str) {
            if (i.this.hud != null) {
                i.this.hud.hideLoadingView();
                i.this.hud.showMsg(str);
                i.this.hud.adb();
            }
        }
    };
    private d hud;
    private VideoAggregationModel hue;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.hud = dVar;
        this.hue = new VideoAggregationModel(tbPageContext, this.htX);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.hue != null) {
            this.hue.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.hue != null) {
            this.hue.setFrom(str);
        }
    }

    public void EI(String str) {
        this.st_type = str;
        if (this.hue != null) {
            this.hue.EI(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.hue != null) {
            this.hue.setLocation(str);
        }
    }

    public void bXF() {
        if (this.hue != null) {
            this.hue.bXF();
        }
    }

    public void bXH() {
        if (this.hue != null && this.mHasMore) {
            this.hue.LoadData();
        }
    }

    public void bXG() {
        if (this.hue != null) {
            this.hue.cancelLoadData();
        }
    }
}
