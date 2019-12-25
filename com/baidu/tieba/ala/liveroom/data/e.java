package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes2.dex */
public class e {
    public com.baidu.tieba.ala.liveroom.m.c eUF;
    public AlaLiveView eUG;
    public AlaLiveRecorder eUY;
    public com.baidu.tieba.ala.liveroom.master.a.d eUZ;
    public AlaLiveRecorderPerfData eVa;
    public com.baidu.live.tieba.e.b eVb;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bjk() {
        return this.liveType;
    }

    public void pN(int i) {
        this.liveType = i;
        if (this.eUZ != null) {
            this.eUZ.qj(i);
        }
    }

    public void d(short s) {
        if (this.eUZ != null) {
            this.eUZ.d(s);
        }
    }

    public void bjl() {
        if (this.eUZ != null) {
            this.eUZ.bjl();
        }
    }

    public void auh() {
        if (this.eUZ != null) {
            this.eUZ.auh();
        }
    }

    public void bjm() {
        if (this.eUZ != null) {
            this.eUZ.bjm();
        }
    }

    public void bjn() {
        if (this.eUZ != null) {
            this.eUZ.bjn();
        }
    }

    public void bjo() {
        if (this.eUZ != null) {
            this.eUZ.bjo();
        }
    }
}
