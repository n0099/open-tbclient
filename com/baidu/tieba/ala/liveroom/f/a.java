package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b hpK;
    private boolean hpL;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hpL = false;
        this.mTbPageContext = tbPageContext;
        this.hpK = new b(this.mTbPageContext);
    }

    public void a(x xVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (xVar == null || xVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.hpK == null || this.hpK.getView() == null || xVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hpL = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hpL = false;
        } else {
            this.hpK.d(alaLastLiveroomInfo);
            this.hpK.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hpK.cbA();
                }
            });
            this.hpK.show();
            this.hpL = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.hpL) {
            this.hpK.aH(viewGroup);
        }
    }

    public void co(int i) {
        if (this.hpK != null && this.hpL) {
            this.hpK.cbD();
            if (i == 1) {
                this.hpK.show();
            } else if (i == 2) {
                this.hpK.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void zH() {
        if (this.hpK != null) {
            this.hpK.cbC();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hpK != null) {
            this.hpK.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.hpK != null && this.hpK.getView() != null) {
            this.hpK.getView().setId(i);
        }
    }
}
