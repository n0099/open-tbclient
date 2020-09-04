package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes7.dex */
public class f {
    public AlaLiveRecorder gxI;
    public FrameLayout gxJ;
    public ViewGroup gxK;
    public com.baidu.tieba.ala.liveroom.master.a.d gxL;
    public com.baidu.live.ar.h gxM;
    public AlaLiveRecorderPerfData gxN;
    public com.baidu.live.tieba.e.b gxO;
    public com.baidu.live.liveroom.middleware.a gxP;
    public com.baidu.tieba.ala.liveroom.p.d gxi;
    public AlaLiveView gxj;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bRb() {
        return this.liveType;
    }

    public void tW(int i) {
        this.liveType = i;
        if (this.gxL != null) {
            this.gxL.uy(i);
        }
    }

    public void f(short s) {
        if (this.gxL != null) {
            this.gxL.f(s);
        }
    }

    public void Qt() {
        if (this.gxL != null) {
            this.gxL.Qt();
        }
    }

    public void aXJ() {
        if (this.gxL != null) {
            this.gxL.aXJ();
        }
    }

    public void bRc() {
        if (this.gxL != null) {
            this.gxL.bRc();
        }
    }

    public void bRd() {
        if (this.gxL != null) {
            this.gxL.bRd();
        }
    }

    public void bRe() {
        if (this.gxL != null) {
            this.gxL.bRe();
        }
    }
}
