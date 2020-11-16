package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b gYJ;
    private boolean gYK;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gYK = false;
        this.mTbPageContext = tbPageContext;
        this.gYJ = new b(this.mTbPageContext);
    }

    public void a(w wVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (wVar == null || wVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.gYJ == null || this.gYJ.getView() == null || wVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gYK = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gYK = false;
        } else {
            this.gYJ.d(alaLastLiveroomInfo);
            this.gYJ.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gYJ.bYF();
                }
            });
            this.gYJ.show();
            this.gYK = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        if (this.gYK) {
            this.gYJ.av(viewGroup);
        }
    }

    public void dE(int i) {
        if (this.gYJ != null && this.gYK) {
            this.gYJ.bYI();
            if (i == 1) {
                this.gYJ.show();
            } else if (i == 2) {
                this.gYJ.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CD() {
        if (this.gYJ != null) {
            this.gYJ.bYH();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gYJ != null) {
            this.gYJ.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.gYJ != null && this.gYJ.getView() != null) {
            this.gYJ.getView().setId(i);
        }
    }
}
