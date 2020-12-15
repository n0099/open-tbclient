package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b hiu;
    private boolean hiv;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hiv = false;
        this.mTbPageContext = tbPageContext;
        this.hiu = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.hiu == null || this.hiu.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.hiv = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.hiv = false;
        } else {
            this.hiu.d(alaLastLiveroomInfo);
            this.hiu.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hiu.ccB();
                }
            });
            this.hiu.show();
            this.hiv = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        if (this.hiv) {
            this.hiu.av(viewGroup);
        }
    }

    public void dX(int i) {
        if (this.hiu != null && this.hiv) {
            this.hiu.ccE();
            if (i == 1) {
                this.hiu.show();
            } else if (i == 2) {
                this.hiu.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        if (this.hiu != null) {
            this.hiu.ccD();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hiu != null) {
            this.hiu.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.hiu != null && this.hiu.getView() != null) {
            this.hiu.getView().setId(i);
        }
    }
}
