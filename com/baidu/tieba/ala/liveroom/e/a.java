package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b hvS;
    private boolean hvT;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hvT = false;
        this.mTbPageContext = tbPageContext;
        this.hvS = new b(this.mTbPageContext);
    }

    public void a(ab abVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (abVar == null || abVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.hvS == null || this.hvS.getView() == null || abVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hvT = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hvT = false;
        } else {
            this.hvS.d(alaLastLiveroomInfo);
            this.hvS.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hvS.ccI();
                }
            });
            this.hvS.show();
            this.hvT = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.hvT) {
            this.hvS.aH(viewGroup);
        }
    }

    public void cs(int i) {
        if (this.hvS != null && this.hvT) {
            this.hvS.ccL();
            if (i == 1) {
                this.hvS.show();
            } else if (i == 2) {
                this.hvS.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Au() {
        if (this.hvS != null) {
            this.hvS.ccK();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hvS != null) {
            this.hvS.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.hvS != null && this.hvS.getView() != null) {
            this.hvS.getView().setId(i);
        }
    }
}
