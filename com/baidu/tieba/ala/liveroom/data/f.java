package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class f {
    public com.baidu.tieba.ala.liveroom.q.d gON;
    public AlaLiveView gOO;
    public AlaLiveRecorder gPm;
    public FrameLayout gPn;
    public ViewGroup gPo;
    public com.baidu.tieba.ala.liveroom.master.a.d gPp;
    public com.baidu.live.ar.h gPq;
    public AlaLiveRecorderPerfData gPr;
    public com.baidu.live.tieba.e.b gPs;
    public com.baidu.live.liveroom.middleware.a gPt;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bVQ() {
        return this.liveType;
    }

    public void uU(int i) {
        this.liveType = i;
        if (this.gPp != null) {
            this.gPp.vw(i);
        }
    }

    public void f(short s) {
        if (this.gPp != null) {
            this.gPp.f(s);
        }
    }

    public void ST() {
        if (this.gPp != null) {
            this.gPp.ST();
        }
    }

    public void bbd() {
        if (this.gPp != null) {
            this.gPp.bbd();
        }
    }

    public void bVR() {
        if (this.gPp != null) {
            this.gPp.bVR();
        }
    }

    public void bVS() {
        if (this.gPp != null) {
            this.gPp.bVS();
        }
    }

    public void bVT() {
        if (this.gPp != null) {
            this.gPp.bVT();
        }
    }
}
