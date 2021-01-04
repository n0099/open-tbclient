package com.baidu.tieba.frs.aggregation;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private VideoAggregationModel.a jnj = new VideoAggregationModel.a() { // from class: com.baidu.tieba.frs.aggregation.i.1
        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void e(List<g> list, boolean z, boolean z2) {
            if (i.this.jnp != null) {
                i.this.jnp.hideLoadingView();
                i.this.mHasMore = z2;
                i.this.jnp.d(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.a
        public void wr(String str) {
            if (i.this.jnp != null) {
                i.this.jnp.hideLoadingView();
                i.this.jnp.showMsg(str);
                i.this.jnp.onLoadFail();
            }
        }
    };
    private d jnp;
    private VideoAggregationModel jnq;
    private String mFrom;
    private boolean mHasMore;
    private String mId;
    private TbPageContext mPageContext;
    private String st_type;
    private String yuelaou_locate;

    public i(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.jnp = dVar;
        this.jnq = new VideoAggregationModel(tbPageContext, this.jnj);
    }

    public void setId(String str) {
        this.mId = str;
        if (this.jnq != null) {
            this.jnq.setId(this.mId);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jnq != null) {
            this.jnq.setFrom(str);
        }
    }

    public void KO(String str) {
        this.st_type = str;
        if (this.jnq != null) {
            this.jnq.KO(str);
        }
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
        if (this.jnq != null) {
            this.jnq.setLocation(str);
        }
    }

    public void cIa() {
        if (this.jnq != null) {
            this.jnq.cIa();
        }
    }

    public void cIc() {
        if (this.jnq != null && this.mHasMore) {
            this.jnq.LoadData();
        }
    }

    public void cIb() {
        if (this.jnq != null) {
            this.jnq.cancelLoadData();
        }
    }
}
