package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b htV;
    private boolean htW;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.htW = false;
        this.mTbPageContext = tbPageContext;
        this.htV = new b(this.mTbPageContext);
    }

    public void a(ab abVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (abVar == null || abVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.htV == null || this.htV.getView() == null || abVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.htW = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.htW = false;
        } else {
            this.htV.d(alaLastLiveroomInfo);
            this.htV.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.htV.ccv();
                }
            });
            this.htV.show();
            this.htW = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.htW) {
            this.htV.aH(viewGroup);
        }
    }

    public void cr(int i) {
        if (this.htV != null && this.htW) {
            this.htV.ccy();
            if (i == 1) {
                this.htV.show();
            } else if (i == 2) {
                this.htV.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Ar() {
        if (this.htV != null) {
            this.htV.ccx();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.htV != null) {
            this.htV.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.htV != null && this.htV.getView() != null) {
            this.htV.getView().setId(i);
        }
    }
}
