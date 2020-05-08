package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
/* loaded from: classes3.dex */
public class a implements c {
    private long aQm;
    private CustomMessageListener eZc;
    private boolean fmp;
    private b fuf;
    private long fug;
    private String fuh;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bmB();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.fmp = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void g(long j, String str) {
        this.fug = j;
        this.fuh = str;
        if (this.fuh == null) {
            this.fuh = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.aQm = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void az(String str, int i) {
        this.fuf = new b(this.mActivity);
        g gVar = new g();
        gVar.u(this.mActivity).a(this.fuf).a(this.fuf.bmC().getSchemeCallback()).aw(this.fug).fi(this.fuh).cj(this.fmp).ax(this.aQm);
        com.baidu.live.view.web.a[] HM = gVar.HM();
        for (com.baidu.live.view.web.a aVar : HM) {
            this.fuf.bmC().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fuf.aA(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.fuf != null && this.fuf.isShowing() && this.fuf.bmC() != null) {
            this.fuf.bmC().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.fuf != null && this.fuf.isShowing() && this.fuf.bmC() != null) {
            this.fuf.bmC().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void cl(int i) {
        if (this.fuf != null && this.fuf.isShowing()) {
            this.fuf.cl(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fug = 0L;
        this.fuh = "";
        MessageManager.getInstance().unRegisterListener(this.eZc);
        if (this.fuf != null) {
            this.fuf.bmD();
            if (this.fuf.bmC() != null) {
                this.fuf.bmC().release();
            }
        }
    }

    private void bmB() {
        this.eZc = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fuf != null && a.this.fuf.isShowing()) {
                    a.this.fuf.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eZc);
    }
}
