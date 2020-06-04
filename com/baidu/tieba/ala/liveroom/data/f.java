package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public AlaLiveRecorder fTM;
    public FrameLayout fTN;
    public com.baidu.tieba.ala.liveroom.master.a.d fTO;
    public com.baidu.live.ar.f fTP;
    public AlaLiveRecorderPerfData fTQ;
    public com.baidu.live.tieba.e.b fTR;
    public com.baidu.live.liveroom.middleware.a fTS;
    public com.baidu.tieba.ala.liveroom.m.c fTm;
    public AlaLiveView fTn;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bBi() {
        return this.liveType;
    }

    public void qV(int i) {
        this.liveType = i;
        if (this.fTO != null) {
            this.fTO.rt(i);
        }
    }

    public void f(short s) {
        if (this.fTO != null) {
            this.fTO.f(s);
        }
    }

    public void Jh() {
        if (this.fTO != null) {
            this.fTO.Jh();
        }
    }

    public void aKz() {
        if (this.fTO != null) {
            this.fTO.aKz();
        }
    }

    public void bBj() {
        if (this.fTO != null) {
            this.fTO.bBj();
        }
    }

    public void bBk() {
        if (this.fTO != null) {
            this.fTO.bBk();
        }
    }

    public void bBl() {
        if (this.fTO != null) {
            this.fTO.bBl();
        }
    }
}
