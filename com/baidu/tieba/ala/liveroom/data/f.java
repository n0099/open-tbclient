package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public AlaLiveRecorder faH;
    public FrameLayout faI;
    public com.baidu.tieba.ala.liveroom.master.a.d faJ;
    public com.baidu.live.ar.c faK;
    public AlaLiveRecorderPerfData faL;
    public com.baidu.live.tieba.e.b faM;
    public com.baidu.live.liveroom.middleware.a faN;
    public com.baidu.tieba.ala.liveroom.m.c fah;
    public AlaLiveView fai;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int blK() {
        return this.liveType;
    }

    public void pX(int i) {
        this.liveType = i;
        if (this.faJ != null) {
            this.faJ.qv(i);
        }
    }

    public void f(short s) {
        if (this.faJ != null) {
            this.faJ.f(s);
        }
    }

    public void blL() {
        if (this.faJ != null) {
            this.faJ.blL();
        }
    }

    public void awO() {
        if (this.faJ != null) {
            this.faJ.awO();
        }
    }

    public void blM() {
        if (this.faJ != null) {
            this.faJ.blM();
        }
    }

    public void blN() {
        if (this.faJ != null) {
            this.faJ.blN();
        }
    }

    public void blO() {
        if (this.faJ != null) {
            this.faJ.blO();
        }
    }
}
