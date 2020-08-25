package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes7.dex */
public class f {
    public AlaLiveRecorder gxE;
    public FrameLayout gxF;
    public ViewGroup gxG;
    public com.baidu.tieba.ala.liveroom.master.a.d gxH;
    public com.baidu.live.ar.h gxI;
    public AlaLiveRecorderPerfData gxJ;
    public com.baidu.live.tieba.e.b gxK;
    public com.baidu.live.liveroom.middleware.a gxL;
    public com.baidu.tieba.ala.liveroom.p.d gxe;
    public AlaLiveView gxf;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bRa() {
        return this.liveType;
    }

    public void tW(int i) {
        this.liveType = i;
        if (this.gxH != null) {
            this.gxH.uy(i);
        }
    }

    public void f(short s) {
        if (this.gxH != null) {
            this.gxH.f(s);
        }
    }

    public void Qt() {
        if (this.gxH != null) {
            this.gxH.Qt();
        }
    }

    public void aXJ() {
        if (this.gxH != null) {
            this.gxH.aXJ();
        }
    }

    public void bRb() {
        if (this.gxH != null) {
            this.gxH.bRb();
        }
    }

    public void bRc() {
        if (this.gxH != null) {
            this.gxH.bRc();
        }
    }

    public void bRd() {
        if (this.gxH != null) {
            this.gxH.bRd();
        }
    }
}
