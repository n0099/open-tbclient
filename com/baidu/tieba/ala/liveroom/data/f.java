package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public AlaLiveRecorder faV;
    public FrameLayout faW;
    public com.baidu.tieba.ala.liveroom.master.a.d faX;
    public com.baidu.live.ar.c faY;
    public AlaLiveRecorderPerfData faZ;
    public com.baidu.tieba.ala.liveroom.m.c fav;
    public AlaLiveView faw;
    public com.baidu.live.tieba.e.b fba;
    public com.baidu.live.liveroom.middleware.a fbb;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int blN() {
        return this.liveType;
    }

    public void pX(int i) {
        this.liveType = i;
        if (this.faX != null) {
            this.faX.qv(i);
        }
    }

    public void f(short s) {
        if (this.faX != null) {
            this.faX.f(s);
        }
    }

    public void blO() {
        if (this.faX != null) {
            this.faX.blO();
        }
    }

    public void awQ() {
        if (this.faX != null) {
            this.faX.awQ();
        }
    }

    public void blP() {
        if (this.faX != null) {
            this.faX.blP();
        }
    }

    public void blQ() {
        if (this.faX != null) {
            this.faX.blQ();
        }
    }

    public void blR() {
        if (this.faX != null) {
            this.faX.blR();
        }
    }
}
