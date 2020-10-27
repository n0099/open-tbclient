package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b gSX;
    private boolean gSY;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gSY = false;
        this.mTbPageContext = tbPageContext;
        this.gSX = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.gSX == null || this.gSX.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gSY = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gSY = false;
        } else {
            this.gSX.d(alaLastLiveroomInfo);
            this.gSX.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gSX.bWK();
                }
            });
            this.gSX.show();
            this.gSY = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void av(ViewGroup viewGroup) {
        if (this.gSY) {
            this.gSX.ax(viewGroup);
        }
    }

    public void dI(int i) {
        if (this.gSX != null && this.gSY) {
            this.gSX.bWN();
            if (i == 1) {
                this.gSX.show();
            } else if (i == 2) {
                this.gSX.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CT() {
        if (this.gSX != null) {
            this.gSX.bWM();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gSX != null) {
            this.gSX.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.gSX != null && this.gSX.getView() != null) {
            this.gSX.getView().setId(i);
        }
    }
}
