package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b gZc;
    private boolean gZd;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gZd = false;
        this.mTbPageContext = tbPageContext;
        this.gZc = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.gZc == null || this.gZc.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gZd = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gZd = false;
        } else {
            this.gZc.d(alaLastLiveroomInfo);
            this.gZc.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gZc.bZm();
                }
            });
            this.gZc.show();
            this.gZd = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        if (this.gZd) {
            this.gZc.az(viewGroup);
        }
    }

    public void dI(int i) {
        if (this.gZc != null && this.gZd) {
            this.gZc.bZp();
            if (i == 1) {
                this.gZc.show();
            } else if (i == 2) {
                this.gZc.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Dm() {
        if (this.gZc != null) {
            this.gZc.bZo();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gZc != null) {
            this.gZc.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.gZc != null && this.gZc.getView() != null) {
            this.gZc.getView().setId(i);
        }
    }
}
