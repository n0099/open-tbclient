package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes2.dex */
public class a implements c {
    private boolean eDz;
    private b eKU;
    private long eKV;
    private String eKW;
    private CustomMessageListener eqH;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bbp();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.eDz = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void d(long j, String str) {
        this.eKV = j;
        this.eKW = str;
        if (this.eKW == null) {
            this.eKW = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void ar(String str, int i) {
        this.eKU = new b(this.mActivity);
        f fVar = new f();
        fVar.x(this.mActivity).a(this.eKU).a(this.eKU.bbq().getSchemeCallback()).N(this.eKV).ea(this.eKW).br(this.eDz);
        com.baidu.live.view.web.a[] zk = fVar.zk();
        for (com.baidu.live.view.web.a aVar : zk) {
            this.eKU.bbq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.eKU.as(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.eKU != null && this.eKU.isShowing() && this.eKU.bbq() != null) {
            this.eKU.bbq().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.eKU != null && this.eKU.isShowing() && this.eKU.bbq() != null) {
            this.eKU.bbq().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bN(int i) {
        if (this.eKU != null && this.eKU.isShowing()) {
            this.eKU.bN(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.eKV = 0L;
        this.eKW = "";
        MessageManager.getInstance().unRegisterListener(this.eqH);
        if (this.eKU != null) {
            this.eKU.bbr();
            if (this.eKU.bbq() != null) {
                this.eKU.bbq().release();
            }
        }
    }

    private void bbp() {
        this.eqH = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eKU != null && a.this.eKU.isShowing()) {
                    a.this.eKU.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eqH);
    }
}
