package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b huj;
    private boolean huk;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.huk = false;
        this.mTbPageContext = tbPageContext;
        this.huj = new b(this.mTbPageContext);
    }

    public void a(ab abVar, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (abVar == null || abVar.mLiveInfo == null || alaLastLiveroomInfo == null || this.huj == null || this.huj.getView() == null || abVar.mLiveInfo.live_id == alaLastLiveroomInfo.getLastLiveId()) {
            this.huk = false;
        } else if (alaLastLiveroomInfo.getLastLiveId() <= 0 && alaLastLiveroomInfo.getLastRoomId() <= 0) {
            this.huk = false;
        } else {
            this.huj.d(alaLastLiveroomInfo);
            this.huj.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.huj.ccC();
                }
            });
            this.huj.show();
            this.huk = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        if (this.huk) {
            this.huj.aH(viewGroup);
        }
    }

    public void cr(int i) {
        if (this.huj != null && this.huk) {
            this.huj.ccF();
            if (i == 1) {
                this.huj.show();
            } else if (i == 2) {
                this.huj.hide();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Ar() {
        if (this.huj != null) {
            this.huj.ccE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.huj != null) {
            this.huj.onDestroy();
        }
    }

    public void setId(int i) {
        if (this.huj != null && this.huj.getView() != null) {
            this.huj.getView().setId(i);
        }
    }
}
