package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes3.dex */
public class a implements c {
    private String aBT;
    private String aBU;
    private long aZe;
    private boolean fLq;
    private b fTv;
    private long fTw;
    private CustomMessageListener fxk;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        buX();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.fLq = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fTw = j;
        this.aBT = str;
        if (this.aBT == null) {
            this.aBT = "";
        }
        this.aBU = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.aZe = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aA(String str, int i) {
        this.fTv = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.aZe);
        alaLastLiveroomInfo.setLastAnchorUname(this.aBT);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fTw));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aBU);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        gVar.u(this.mActivity).b(this.fTv).a(this.fTv.Hf().getSchemeCallback()).aB(this.fTw).gc(this.aBT).cB(this.fLq).aC(this.aZe).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] KO = gVar.KO();
        for (com.baidu.live.view.web.a aVar : KO) {
            this.fTv.Hf().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fTv.aB(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.fTv != null && this.fTv.isShowing() && this.fTv.Hf() != null) {
            this.fTv.Hf().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.fTv != null && this.fTv.isShowing() && this.fTv.Hf() != null) {
            this.fTv.Hf().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void cA(int i) {
        if (this.fTv != null && this.fTv.isShowing()) {
            this.fTv.cA(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fTw = 0L;
        this.aBT = "";
        MessageManager.getInstance().unRegisterListener(this.fxk);
        if (this.fTv != null) {
            this.fTv.buY();
            if (this.fTv.Hf() != null) {
                this.fTv.Hf().release();
            }
        }
    }

    private void buX() {
        this.fxk = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fTv != null && a.this.fTv.isShowing()) {
                    a.this.fTv.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fxk);
    }
}
