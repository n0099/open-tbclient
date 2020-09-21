package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b gsN;
    private boolean gsO;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gsO = false;
        this.mTbPageContext = tbPageContext;
        this.gsN = new b(this.mTbPageContext);
    }

    public void a(u uVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (uVar == null || uVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.gsN == null || this.gsN.getView() == null || uVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gsO = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gsO = false;
        } else {
            this.gsN.d(alaLastLiveroomInfo);
            this.gsN.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gsN.bQs();
                }
            });
            this.gsN.show();
            this.gsO = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        if (this.gsO) {
            this.gsN.av(viewGroup);
        }
    }

    public void dD(int i) {
        if (this.gsN != null && this.gsO) {
            this.gsN.bQv();
            if (i == 1) {
                this.gsN.show();
            } else if (i == 2) {
                this.gsN.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BQ() {
        if (this.gsN != null) {
            this.gsN.bQu();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gsN != null) {
            this.gsN.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.gsN != null && this.gsN.getView() != null) {
            this.gsN.getView().setId(i);
        }
    }
}
