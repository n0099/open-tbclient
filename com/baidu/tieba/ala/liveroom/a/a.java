package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
/* loaded from: classes3.dex */
public class a implements c {
    private long aQg;
    private CustomMessageListener eYX;
    private boolean fmk;
    private b fua;
    private long fub;
    private String fuc;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bmD();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.fmk = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void g(long j, String str) {
        this.fub = j;
        this.fuc = str;
        if (this.fuc == null) {
            this.fuc = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.aQg = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void az(String str, int i) {
        this.fua = new b(this.mActivity);
        g gVar = new g();
        gVar.u(this.mActivity).a(this.fua).a(this.fua.bmE().getSchemeCallback()).aw(this.fub).fi(this.fuc).cj(this.fmk).ax(this.aQg);
        com.baidu.live.view.web.a[] HN = gVar.HN();
        for (com.baidu.live.view.web.a aVar : HN) {
            this.fua.bmE().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fua.aA(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.fua != null && this.fua.isShowing() && this.fua.bmE() != null) {
            this.fua.bmE().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.fua != null && this.fua.isShowing() && this.fua.bmE() != null) {
            this.fua.bmE().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void cl(int i) {
        if (this.fua != null && this.fua.isShowing()) {
            this.fua.cl(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fub = 0L;
        this.fuc = "";
        MessageManager.getInstance().unRegisterListener(this.eYX);
        if (this.fua != null) {
            this.fua.bmF();
            if (this.fua.bmE() != null) {
                this.fua.bmE().release();
            }
        }
    }

    private void bmD() {
        this.eYX = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fua != null && a.this.fua.isShowing()) {
                    a.this.fua.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eYX);
    }
}
