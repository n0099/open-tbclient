package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class f {
    public AlaLiveRecorder gAT;
    public FrameLayout gAU;
    public ViewGroup gAV;
    public com.baidu.tieba.ala.liveroom.master.a.d gAW;
    public com.baidu.live.ar.h gAX;
    public AlaLiveRecorderPerfData gAY;
    public com.baidu.live.tieba.e.b gAZ;
    public com.baidu.tieba.ala.liveroom.q.d gAu;
    public AlaLiveView gAv;
    public com.baidu.live.liveroom.middleware.a gBa;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bSx() {
        return this.liveType;
    }

    public void up(int i) {
        this.liveType = i;
        if (this.gAW != null) {
            this.gAW.uR(i);
        }
    }

    public void f(short s) {
        if (this.gAW != null) {
            this.gAW.f(s);
        }
    }

    public void Rb() {
        if (this.gAW != null) {
            this.gAW.Rb();
        }
    }

    public void aYv() {
        if (this.gAW != null) {
            this.gAW.aYv();
        }
    }

    public void bSy() {
        if (this.gAW != null) {
            this.gAW.bSy();
        }
    }

    public void bSz() {
        if (this.gAW != null) {
            this.gAW.bSz();
        }
    }

    public void bSA() {
        if (this.gAW != null) {
            this.gAW.bSA();
        }
    }
}
