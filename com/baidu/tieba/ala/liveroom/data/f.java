package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public AlaLiveRecorder fTB;
    public FrameLayout fTC;
    public com.baidu.tieba.ala.liveroom.master.a.d fTD;
    public com.baidu.live.ar.f fTE;
    public AlaLiveRecorderPerfData fTF;
    public com.baidu.live.tieba.e.b fTG;
    public com.baidu.live.liveroom.middleware.a fTH;
    public com.baidu.tieba.ala.liveroom.m.c fTb;
    public AlaLiveView fTc;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bBg() {
        return this.liveType;
    }

    public void qT(int i) {
        this.liveType = i;
        if (this.fTD != null) {
            this.fTD.rr(i);
        }
    }

    public void f(short s) {
        if (this.fTD != null) {
            this.fTD.f(s);
        }
    }

    public void Jh() {
        if (this.fTD != null) {
            this.fTD.Jh();
        }
    }

    public void aKz() {
        if (this.fTD != null) {
            this.fTD.aKz();
        }
    }

    public void bBh() {
        if (this.fTD != null) {
            this.fTD.bBh();
        }
    }

    public void bBi() {
        if (this.fTD != null) {
            this.fTD.bBi();
        }
    }

    public void bBj() {
        if (this.fTD != null) {
            this.fTD.bBj();
        }
    }
}
