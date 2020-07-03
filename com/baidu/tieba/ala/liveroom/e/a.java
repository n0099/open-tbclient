package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b fYg;
    private boolean fYh;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fYh = false;
        this.mTbPageContext = tbPageContext;
        this.fYg = new b(this.mTbPageContext);
    }

    public void a(q qVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (qVar == null || qVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.fYg == null || this.fYg.getView() == null || qVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.fYh = false;
            return;
        }
        this.fYg.d(alaLastLiveroomInfo);
        this.fYg.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fYg.bCo();
            }
        });
        this.fYg.show();
        this.fYh = true;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aq(ViewGroup viewGroup) {
        if (this.fYh) {
            this.fYg.as(viewGroup);
        }
    }

    public void cA(int i) {
        if (this.fYg != null && this.fYh) {
            this.fYg.bCr();
            if (i == 1) {
                this.fYg.show();
            } else if (i == 2) {
                this.fYg.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vH() {
        if (this.fYg != null) {
            this.fYg.bCq();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fYg != null) {
            this.fYg.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.fYg != null && this.fYg.getView() != null) {
            this.fYg.getView().setId(i);
        }
    }
}
