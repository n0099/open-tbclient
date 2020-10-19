package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b gHi;
    private boolean gHj;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHj = false;
        this.mTbPageContext = tbPageContext;
        this.gHi = new b(this.mTbPageContext);
    }

    public void a(u uVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (uVar == null || uVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.gHi == null || this.gHi.getView() == null || uVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gHj = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gHj = false;
        } else {
            this.gHi.d(alaLastLiveroomInfo);
            this.gHi.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gHi.bTL();
                }
            });
            this.gHi.show();
            this.gHj = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void av(ViewGroup viewGroup) {
        if (this.gHj) {
            this.gHi.ax(viewGroup);
        }
    }

    public void dI(int i) {
        if (this.gHi != null && this.gHj) {
            this.gHi.bTO();
            if (i == 1) {
                this.gHi.show();
            } else if (i == 2) {
                this.gHi.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CN() {
        if (this.gHi != null) {
            this.gHi.bTN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gHi != null) {
            this.gHi.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.gHi != null && this.gHi.getView() != null) {
            this.gHi.getView().setId(i);
        }
    }
}
