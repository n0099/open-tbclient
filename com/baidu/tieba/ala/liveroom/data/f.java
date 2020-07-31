package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class f {
    public AlaLiveRecorder glA;
    public FrameLayout glB;
    public ViewGroup glC;
    public com.baidu.tieba.ala.liveroom.master.a.d glD;
    public com.baidu.live.ar.h glE;
    public AlaLiveRecorderPerfData glF;
    public com.baidu.live.tieba.e.b glG;
    public com.baidu.live.liveroom.middleware.a glH;
    public com.baidu.tieba.ala.liveroom.o.c gla;
    public AlaLiveView glb;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bHw() {
        return this.liveType;
    }

    public void rK(int i) {
        this.liveType = i;
        if (this.glD != null) {
            this.glD.si(i);
        }
    }

    public void f(short s) {
        if (this.glD != null) {
            this.glD.f(s);
        }
    }

    public void KB() {
        if (this.glD != null) {
            this.glD.KB();
        }
    }

    public void aPt() {
        if (this.glD != null) {
            this.glD.aPt();
        }
    }

    public void bHx() {
        if (this.glD != null) {
            this.glD.bHx();
        }
    }

    public void bHy() {
        if (this.glD != null) {
            this.glD.bHy();
        }
    }

    public void bHz() {
        if (this.glD != null) {
            this.glD.bHz();
        }
    }
}
