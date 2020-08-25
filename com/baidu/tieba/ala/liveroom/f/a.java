package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b gpv;
    private boolean gpw;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gpw = false;
        this.mTbPageContext = tbPageContext;
        this.gpv = new b(this.mTbPageContext);
    }

    public void a(r rVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (rVar == null || rVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.gpv == null || this.gpv.getView() == null || rVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gpw = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gpw = false;
        } else {
            this.gpv.d(alaLastLiveroomInfo);
            this.gpv.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gpv.bPf();
                }
            });
            this.gpv.show();
            this.gpw = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void as(ViewGroup viewGroup) {
        if (this.gpw) {
            this.gpv.au(viewGroup);
        }
    }

    public void dz(int i) {
        if (this.gpv != null && this.gpw) {
            this.gpv.bPi();
            if (i == 1) {
                this.gpv.show();
            } else if (i == 2) {
                this.gpv.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        if (this.gpv != null) {
            this.gpv.bPh();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gpv != null) {
            this.gpv.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.gpv != null && this.gpv.getView() != null) {
            this.gpv.getView().setId(i);
        }
    }
}
