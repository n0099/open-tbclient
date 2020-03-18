package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes3.dex */
public class a implements c {
    private boolean eHT;
    private b ePF;
    private long ePG;
    private String ePH;
    private CustomMessageListener evC;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bdM();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.eHT = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str) {
        this.ePG = j;
        this.ePH = str;
        if (this.ePH == null) {
            this.ePH = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void ap(String str, int i) {
        this.ePF = new b(this.mActivity);
        f fVar = new f();
        fVar.y(this.mActivity).a(this.ePF).a(this.ePF.bdN().getSchemeCallback()).R(this.ePG).eo(this.ePH).bA(this.eHT);
        com.baidu.live.view.web.a[] BJ = fVar.BJ();
        for (com.baidu.live.view.web.a aVar : BJ) {
            this.ePF.bdN().addJavascriptInterface(aVar, aVar.getName());
        }
        this.ePF.aq(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.ePF != null && this.ePF.isShowing() && this.ePF.bdN() != null) {
            this.ePF.bdN().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.ePF != null && this.ePF.isShowing() && this.ePF.bdN() != null) {
            this.ePF.bdN().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bW(int i) {
        if (this.ePF != null && this.ePF.isShowing()) {
            this.ePF.bW(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.ePG = 0L;
        this.ePH = "";
        MessageManager.getInstance().unRegisterListener(this.evC);
        if (this.ePF != null) {
            this.ePF.bdO();
            if (this.ePF.bdN() != null) {
                this.ePF.bdN().release();
            }
        }
    }

    private void bdM() {
        this.evC = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.ePF != null && a.this.ePF.isShowing()) {
                    a.this.ePF.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.evC);
    }
}
