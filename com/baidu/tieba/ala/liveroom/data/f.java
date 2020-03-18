package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public com.baidu.tieba.ala.liveroom.m.c faT;
    public AlaLiveView faU;
    public AlaLiveRecorder fbt;
    public FrameLayout fbu;
    public com.baidu.tieba.ala.liveroom.master.a.d fbv;
    public com.baidu.live.ar.c fbw;
    public AlaLiveRecorderPerfData fbx;
    public com.baidu.live.tieba.e.b fby;
    public com.baidu.live.liveroom.middleware.a fbz;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int blS() {
        return this.liveType;
    }

    public void pZ(int i) {
        this.liveType = i;
        if (this.fbv != null) {
            this.fbv.qx(i);
        }
    }

    public void f(short s) {
        if (this.fbv != null) {
            this.fbv.f(s);
        }
    }

    public void blT() {
        if (this.fbv != null) {
            this.fbv.blT();
        }
    }

    public void awT() {
        if (this.fbv != null) {
            this.fbv.awT();
        }
    }

    public void blU() {
        if (this.fbv != null) {
            this.fbv.blU();
        }
    }

    public void blV() {
        if (this.fbv != null) {
            this.fbv.blV();
        }
    }

    public void blW() {
        if (this.fbv != null) {
            this.fbv.blW();
        }
    }
}
