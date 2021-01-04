package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b huq;
    private boolean hur;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hur = false;
        this.mTbPageContext = tbPageContext;
        this.huq = new b(this.mTbPageContext);
    }

    public void a(x xVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (xVar == null || xVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.huq == null || this.huq.getView() == null || xVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hur = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hur = false;
        } else {
            this.huq.d(alaLastLiveroomInfo);
            this.huq.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.huq.cfr();
                }
            });
            this.huq.show();
            this.hur = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.hur) {
            this.huq.aH(viewGroup);
        }
    }

    public void dU(int i) {
        if (this.huq != null && this.hur) {
            this.huq.cfu();
            if (i == 1) {
                this.huq.show();
            } else if (i == 2) {
                this.huq.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void DC() {
        if (this.huq != null) {
            this.huq.cft();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.huq != null) {
            this.huq.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.huq != null && this.huq.getView() != null) {
            this.huq.getView().setId(i);
        }
    }
}
