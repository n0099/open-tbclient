package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b gdn;
    private boolean gdo;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gdo = false;
        this.mTbPageContext = tbPageContext;
        this.gdn = new b(this.mTbPageContext);
    }

    public void a(q qVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (qVar == null || qVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.gdn == null || this.gdn.getView() == null || qVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.gdo = false;
            return;
        }
        this.gdn.d(alaLastLiveroomInfo);
        this.gdn.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gdn.bFA();
            }
        });
        this.gdn.show();
        this.gdo = true;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ar(ViewGroup viewGroup) {
        if (this.gdo) {
            this.gdn.at(viewGroup);
        }
    }

    public void bN(int i) {
        if (this.gdn != null && this.gdo) {
            this.gdn.bFD();
            if (i == 1) {
                this.gdn.show();
            } else if (i == 2) {
                this.gdn.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void wd() {
        if (this.gdn != null) {
            this.gdn.bFC();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gdn != null) {
            this.gdn.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.gdn != null && this.gdn.getView() != null) {
            this.gdn.getView().setId(i);
        }
    }
}
