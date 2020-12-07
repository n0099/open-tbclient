package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b his;
    private boolean hit;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hit = false;
        this.mTbPageContext = tbPageContext;
        this.his = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.his == null || this.his.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hit = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hit = false;
        } else {
            this.his.d(alaLastLiveroomInfo);
            this.his.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.his.ccA();
                }
            });
            this.his.show();
            this.hit = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        if (this.hit) {
            this.his.av(viewGroup);
        }
    }

    public void dX(int i) {
        if (this.his != null && this.hit) {
            this.his.ccD();
            if (i == 1) {
                this.his.show();
            } else if (i == 2) {
                this.his.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        if (this.his != null) {
            this.his.ccC();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.his != null) {
            this.his.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.his != null && this.his.getView() != null) {
            this.his.getView().setId(i);
        }
    }
}
