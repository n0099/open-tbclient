package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
/* loaded from: classes3.dex */
public class a implements c {
    private long aWv;
    private b fIb;
    private long fIc;
    private String fId;
    private CustomMessageListener flM;
    private boolean fzW;
    private Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
        brZ();
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setHost(boolean z) {
        this.fzW = z;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void g(long j, String str) {
        this.fIc = j;
        this.fId = str;
        if (this.fId == null) {
            this.fId = "";
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void setLiveId(long j) {
        this.aWv = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void aA(String str, int i) {
        this.fIb = new b(this.mActivity);
        g gVar = new g();
        gVar.u(this.mActivity).a(this.fIb).a(this.fIb.bsa().getSchemeCallback()).aB(this.fIc).fU(this.fId).cv(this.fzW).aC(this.aWv);
        com.baidu.live.view.web.a[] JF = gVar.JF();
        for (com.baidu.live.view.web.a aVar : JF) {
            this.fIb.bsa().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fIb.aB(str, i);
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void resume() {
        if (this.fIb != null && this.fIb.isShowing() && this.fIb.bsa() != null) {
            this.fIb.bsa().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void pause() {
        if (this.fIb != null && this.fIb.isShowing() && this.fIb.bsa() != null) {
            this.fIb.bsa().onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void cs(int i) {
        if (this.fIb != null && this.fIb.isShowing()) {
            this.fIb.cs(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a.c
    public void release() {
        this.fIc = 0L;
        this.fId = "";
        MessageManager.getInstance().unRegisterListener(this.flM);
        if (this.fIb != null) {
            this.fIb.bsb();
            if (this.fIb.bsa() != null) {
                this.fIb.bsa().release();
            }
        }
    }

    private void brZ() {
        this.flM = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fIb != null && a.this.fIb.isShowing()) {
                    a.this.fIb.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.flM);
    }
}
