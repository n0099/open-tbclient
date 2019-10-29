package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes6.dex */
public class a implements c {
    private boolean dOZ;
    private b dUW;
    private long dUX;
    private String dUY;
    private CustomMessageListener dUZ;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        aND();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.dOZ = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void c(long j, String str) {
        this.dUX = j;
        this.dUY = str;
        if (this.dUY == null) {
            this.dUY = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void ah(String str, int i) {
        this.dUW = new b(this.mActivity);
        f fVar = new f();
        fVar.az(this.mActivity).a(this.dUW).a(this.dUW.aNE().getSchemeCallback()).J(this.dUX).de(this.dUY).aV(this.dOZ);
        com.baidu.live.view.web.a[] wO = fVar.wO();
        for (com.baidu.live.view.web.a aVar : wO) {
            this.dUW.aNE().addJavascriptInterface(aVar, aVar.getName());
        }
        this.dUW.ai(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.dUW != null && this.dUW.isShowing() && this.dUW.aNE() != null) {
            this.dUW.aNE().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.dUW != null && this.dUW.isShowing() && this.dUW.aNE() != null) {
            this.dUW.aNE().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bw(int i) {
        if (this.dUW != null && this.dUW.isShowing()) {
            this.dUW.bw(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.dUX = 0L;
        this.dUY = "";
        MessageManager.getInstance().unRegisterListener(this.dUZ);
        if (this.dUW != null) {
            this.dUW.aNF();
            if (this.dUW.aNE() != null) {
                this.dUW.aNE().release();
            }
        }
    }

    private void aND() {
        this.dUZ = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.dUW != null && a.this.dUW.isShowing()) {
                    a.this.dUW.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dUZ);
    }
}
