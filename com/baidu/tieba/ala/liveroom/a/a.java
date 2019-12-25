package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes2.dex */
public class a implements c {
    private boolean eCo;
    private b eJJ;
    private long eJK;
    private String eJL;
    private CustomMessageListener epv;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        baU();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.eCo = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void d(long j, String str) {
        this.eJK = j;
        this.eJL = str;
        if (this.eJL == null) {
            this.eJL = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aq(String str, int i) {
        this.eJJ = new b(this.mActivity);
        f fVar = new f();
        fVar.x(this.mActivity).a(this.eJJ).a(this.eJJ.baV().getSchemeCallback()).K(this.eJK).dY(this.eJL).bm(this.eCo);
        com.baidu.live.view.web.a[] yO = fVar.yO();
        for (com.baidu.live.view.web.a aVar : yO) {
            this.eJJ.baV().addJavascriptInterface(aVar, aVar.getName());
        }
        this.eJJ.ar(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.eJJ != null && this.eJJ.isShowing() && this.eJJ.baV() != null) {
            this.eJJ.baV().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.eJJ != null && this.eJJ.isShowing() && this.eJJ.baV() != null) {
            this.eJJ.baV().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void bN(int i) {
        if (this.eJJ != null && this.eJJ.isShowing()) {
            this.eJJ.bN(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.eJK = 0L;
        this.eJL = "";
        MessageManager.getInstance().unRegisterListener(this.epv);
        if (this.eJJ != null) {
            this.eJJ.baW();
            if (this.eJJ.baV() != null) {
                this.eJJ.baV().release();
            }
        }
    }

    private void baU() {
        this.epv = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eJJ != null && a.this.eJJ.isShowing()) {
                    a.this.eJJ.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.epv);
    }
}
