package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes3.dex */
public class a implements c {
    private boolean eHj;
    private b eOT;
    private long eOU;
    private String eOV;
    private CustomMessageListener euS;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bdE();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.eHj = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void e(long j, String str) {
        this.eOU = j;
        this.eOV = str;
        if (this.eOV == null) {
            this.eOV = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void ap(String str, int i) {
        this.eOT = new b(this.mActivity);
        f fVar = new f();
        fVar.y(this.mActivity).a(this.eOT).a(this.eOT.bdF().getSchemeCallback()).R(this.eOU).ep(this.eOV).bz(this.eHj);
        com.baidu.live.view.web.a[] BA = fVar.BA();
        for (com.baidu.live.view.web.a aVar : BA) {
            this.eOT.bdF().addJavascriptInterface(aVar, aVar.getName());
        }
        this.eOT.aq(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.eOT != null && this.eOT.isShowing() && this.eOT.bdF() != null) {
            this.eOT.bdF().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.eOT != null && this.eOT.isShowing() && this.eOT.bdF() != null) {
            this.eOT.bdF().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bW(int i) {
        if (this.eOT != null && this.eOT.isShowing()) {
            this.eOT.bW(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.eOU = 0L;
        this.eOV = "";
        MessageManager.getInstance().unRegisterListener(this.euS);
        if (this.eOT != null) {
            this.eOT.bdG();
            if (this.eOT.bdF() != null) {
                this.eOT.bdF().release();
            }
        }
    }

    private void bdE() {
        this.euS = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eOT != null && a.this.eOT.isShowing()) {
                    a.this.eOT.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.euS);
    }
}
