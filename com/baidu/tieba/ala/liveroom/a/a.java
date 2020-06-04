package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
/* loaded from: classes3.dex */
public class a implements c {
    private long aWv;
    private boolean fAh;
    private b fIm;
    private long fIn;
    private String fIo;
    private CustomMessageListener flX;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        bsb();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.fAh = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void g(long j, String str) {
        this.fIn = j;
        this.fIo = str;
        if (this.fIo == null) {
            this.fIo = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.aWv = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aA(String str, int i) {
        this.fIm = new b(this.mActivity);
        g gVar = new g();
        gVar.u(this.mActivity).a(this.fIm).a(this.fIm.bsc().getSchemeCallback()).aB(this.fIn).fU(this.fIo).cv(this.fAh).aC(this.aWv);
        com.baidu.live.view.web.a[] JF = gVar.JF();
        for (com.baidu.live.view.web.a aVar : JF) {
            this.fIm.bsc().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fIm.aB(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.fIm != null && this.fIm.isShowing() && this.fIm.bsc() != null) {
            this.fIm.bsc().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.fIm != null && this.fIm.isShowing() && this.fIm.bsc() != null) {
            this.fIm.bsc().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void cu(int i) {
        if (this.fIm != null && this.fIm.isShowing()) {
            this.fIm.cu(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fIn = 0L;
        this.fIo = "";
        MessageManager.getInstance().unRegisterListener(this.flX);
        if (this.fIm != null) {
            this.fIm.bsd();
            if (this.fIm.bsc() != null) {
                this.fIm.bsc().release();
            }
        }
    }

    private void bsb() {
        this.flX = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fIm != null && a.this.fIm.isShowing()) {
                    a.this.fIm.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.flX);
    }
}
