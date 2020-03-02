package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public AlaLiveRecorder faI;
    public FrameLayout faJ;
    public com.baidu.tieba.ala.liveroom.master.a.d faK;
    public com.baidu.live.ar.c faL;
    public AlaLiveRecorderPerfData faM;
    public com.baidu.live.tieba.e.b faN;
    public com.baidu.live.liveroom.middleware.a faO;
    public com.baidu.tieba.ala.liveroom.m.c fai;
    public AlaLiveView faj;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int blM() {
        return this.liveType;
    }

    public void pX(int i) {
        this.liveType = i;
        if (this.faK != null) {
            this.faK.qv(i);
        }
    }

    public void f(short s) {
        if (this.faK != null) {
            this.faK.f(s);
        }
    }

    public void blN() {
        if (this.faK != null) {
            this.faK.blN();
        }
    }

    public void awQ() {
        if (this.faK != null) {
            this.faK.awQ();
        }
    }

    public void blO() {
        if (this.faK != null) {
            this.faK.blO();
        }
    }

    public void blP() {
        if (this.faK != null) {
            this.faK.blP();
        }
    }

    public void blQ() {
        if (this.faK != null) {
            this.faK.blQ();
        }
    }
}
