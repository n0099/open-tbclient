package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aDo;
    private String aDp;
    private long aZc;
    private CustomMessageListener fCr;
    private boolean fQK;
    private b fYO;
    private long fjn;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        byh();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.fQK = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fjn = j;
        this.aDo = str;
        if (this.aDo == null) {
            this.aDo = "";
        }
        this.aDp = str2;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.aZc = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void az(String str, int i) {
        this.fYO = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.aZc);
        alaLastLiveroomInfo.setLastAnchorUname(this.aDo);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fjn));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aDp);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        gVar.v(this.mActivity).b(this.fYO).a(this.fYO.Hl().getSchemeCallback()).aB(this.fjn).gb(this.aDo).cD(this.fQK).aC(this.aZc).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] KV = gVar.KV();
        for (com.baidu.live.view.web.a aVar : KV) {
            this.fYO.Hl().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fYO.aA(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.fYO != null && this.fYO.isShowing() && this.fYO.Hl() != null) {
            this.fYO.Hl().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.fYO != null && this.fYO.isShowing() && this.fYO.Hl() != null) {
            this.fYO.Hl().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bN(int i) {
        if (this.fYO != null && this.fYO.isShowing()) {
            this.fYO.bN(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fjn = 0L;
        this.aDo = "";
        MessageManager.getInstance().unRegisterListener(this.fCr);
        if (this.fYO != null) {
            this.fYO.byi();
            if (this.fYO.Hl() != null) {
                this.fYO.Hl().release();
            }
        }
    }

    private void byh() {
        this.fCr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fYO != null && a.this.fYO.isShowing()) {
                    a.this.fYO.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fCr);
    }
}
