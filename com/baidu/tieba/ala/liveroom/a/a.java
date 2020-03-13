package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes3.dex */
public class a implements c {
    private boolean eHx;
    private b ePh;
    private long ePi;
    private String ePj;
    private CustomMessageListener evg;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bdH();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.eHx = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str) {
        this.ePi = j;
        this.ePj = str;
        if (this.ePj == null) {
            this.ePj = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void ap(String str, int i) {
        this.ePh = new b(this.mActivity);
        f fVar = new f();
        fVar.y(this.mActivity).a(this.ePh).a(this.ePh.bdI().getSchemeCallback()).R(this.ePi).ep(this.ePj).bz(this.eHx);
        com.baidu.live.view.web.a[] BC = fVar.BC();
        for (com.baidu.live.view.web.a aVar : BC) {
            this.ePh.bdI().addJavascriptInterface(aVar, aVar.getName());
        }
        this.ePh.aq(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.ePh != null && this.ePh.isShowing() && this.ePh.bdI() != null) {
            this.ePh.bdI().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.ePh != null && this.ePh.isShowing() && this.ePh.bdI() != null) {
            this.ePh.bdI().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bW(int i) {
        if (this.ePh != null && this.ePh.isShowing()) {
            this.ePh.bW(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.ePi = 0L;
        this.ePj = "";
        MessageManager.getInstance().unRegisterListener(this.evg);
        if (this.ePh != null) {
            this.ePh.bdJ();
            if (this.ePh.bdI() != null) {
                this.ePh.bdI().release();
            }
        }
    }

    private void bdH() {
        this.evg = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.ePh != null && a.this.ePh.isShowing()) {
                    a.this.ePh.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.evg);
    }
}
