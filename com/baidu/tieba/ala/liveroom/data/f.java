package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public AlaLiveRecorder fFC;
    public FrameLayout fFD;
    public com.baidu.tieba.ala.liveroom.master.a.d fFE;
    public com.baidu.live.ar.f fFF;
    public AlaLiveRecorderPerfData fFG;
    public com.baidu.live.tieba.e.b fFH;
    public com.baidu.live.liveroom.middleware.a fFI;
    public com.baidu.tieba.ala.liveroom.m.c fFc;
    public AlaLiveView fFd;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bvj() {
        return this.liveType;
    }

    public void qs(int i) {
        this.liveType = i;
        if (this.fFE != null) {
            this.fFE.qQ(i);
        }
    }

    public void f(short s) {
        if (this.fFE != null) {
            this.fFE.f(s);
        }
    }

    public void Hp() {
        if (this.fFE != null) {
            this.fFE.Hp();
        }
    }

    public void aFe() {
        if (this.fFE != null) {
            this.fFE.aFe();
        }
    }

    public void bvk() {
        if (this.fFE != null) {
            this.fFE.bvk();
        }
    }

    public void bvl() {
        if (this.fFE != null) {
            this.fFE.bvl();
        }
    }

    public void bvm() {
        if (this.fFE != null) {
            this.fFE.bvm();
        }
    }
}
