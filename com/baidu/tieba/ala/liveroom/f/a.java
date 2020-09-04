package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private boolean gpA;
    private b gpz;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gpA = false;
        this.mTbPageContext = tbPageContext;
        this.gpz = new b(this.mTbPageContext);
    }

    public void a(r rVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (rVar == null || rVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.gpz == null || this.gpz.getView() == null || rVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gpA = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.gpA = false;
        } else {
            this.gpz.d(alaLastLiveroomInfo);
            this.gpz.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gpz.bPg();
                }
            });
            this.gpz.show();
            this.gpA = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void as(ViewGroup viewGroup) {
        if (this.gpA) {
            this.gpz.au(viewGroup);
        }
    }

    public void dz(int i) {
        if (this.gpz != null && this.gpA) {
            this.gpz.bPj();
            if (i == 1) {
                this.gpz.show();
            } else if (i == 2) {
                this.gpz.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        if (this.gpz != null) {
            this.gpz.bPi();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gpz != null) {
            this.gpz.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.gpz != null && this.gpz.getView() != null) {
            this.gpz.getView().setId(i);
        }
    }
}
