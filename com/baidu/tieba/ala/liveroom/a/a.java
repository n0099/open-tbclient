package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes6.dex */
public class a implements c {
    private boolean dOi;
    private b dUf;
    private long dUg;
    private String dUh;
    private CustomMessageListener dUi;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        aNB();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.dOi = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void c(long j, String str) {
        this.dUg = j;
        this.dUh = str;
        if (this.dUh == null) {
            this.dUh = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void ah(String str, int i) {
        this.dUf = new b(this.mActivity);
        f fVar = new f();
        fVar.az(this.mActivity).a(this.dUf).a(this.dUf.aNC().getSchemeCallback()).I(this.dUg).de(this.dUh).aV(this.dOi);
        com.baidu.live.view.web.a[] wP = fVar.wP();
        for (com.baidu.live.view.web.a aVar : wP) {
            this.dUf.aNC().addJavascriptInterface(aVar, aVar.getName());
        }
        this.dUf.ai(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.dUf != null && this.dUf.isShowing() && this.dUf.aNC() != null) {
            this.dUf.aNC().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.dUf != null && this.dUf.isShowing() && this.dUf.aNC() != null) {
            this.dUf.aNC().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bw(int i) {
        if (this.dUf != null && this.dUf.isShowing()) {
            this.dUf.bw(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.dUg = 0L;
        this.dUh = "";
        MessageManager.getInstance().unRegisterListener(this.dUi);
        if (this.dUf != null) {
            this.dUf.aND();
            if (this.dUf.aNC() != null) {
                this.dUf.aNC().release();
            }
        }
    }

    private void aNB() {
        this.dUi = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.dUf != null && a.this.dUf.isShowing()) {
                    a.this.dUf.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dUi);
    }
}
