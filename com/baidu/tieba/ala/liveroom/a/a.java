package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes3.dex */
public class a implements c {
    private boolean eHk;
    private b eOU;
    private long eOV;
    private String eOW;
    private CustomMessageListener euT;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bdG();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.eHk = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str) {
        this.eOV = j;
        this.eOW = str;
        if (this.eOW == null) {
            this.eOW = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void ap(String str, int i) {
        this.eOU = new b(this.mActivity);
        f fVar = new f();
        fVar.y(this.mActivity).a(this.eOU).a(this.eOU.bdH().getSchemeCallback()).R(this.eOV).ep(this.eOW).bz(this.eHk);
        com.baidu.live.view.web.a[] BC = fVar.BC();
        for (com.baidu.live.view.web.a aVar : BC) {
            this.eOU.bdH().addJavascriptInterface(aVar, aVar.getName());
        }
        this.eOU.aq(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.eOU != null && this.eOU.isShowing() && this.eOU.bdH() != null) {
            this.eOU.bdH().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.eOU != null && this.eOU.isShowing() && this.eOU.bdH() != null) {
            this.eOU.bdH().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bW(int i) {
        if (this.eOU != null && this.eOU.isShowing()) {
            this.eOU.bW(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.eOV = 0L;
        this.eOW = "";
        MessageManager.getInstance().unRegisterListener(this.euT);
        if (this.eOU != null) {
            this.eOU.bdI();
            if (this.eOU.bdH() != null) {
                this.eOU.bdH().release();
            }
        }
    }

    private void bdG() {
        this.euT = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eOU != null && a.this.eOU.isShowing()) {
                    a.this.eOU.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.euT);
    }
}
