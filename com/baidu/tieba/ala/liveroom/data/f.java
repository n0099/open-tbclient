package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes2.dex */
public class f {
    public AlaLiveRecorder eWS;
    public com.baidu.tieba.ala.liveroom.master.a.d eWT;
    public com.baidu.live.ar.c eWU;
    public AlaLiveRecorderPerfData eWV;
    public com.baidu.live.tieba.e.b eWW;
    public com.baidu.tieba.ala.liveroom.o.c eWr;
    public AlaLiveView eWs;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bjW() {
        return this.liveType;
    }

    public void pP(int i) {
        this.liveType = i;
        if (this.eWT != null) {
            this.eWT.qo(i);
        }
    }

    public void d(short s) {
        if (this.eWT != null) {
            this.eWT.d(s);
        }
    }

    public void bjX() {
        if (this.eWT != null) {
            this.eWT.bjX();
        }
    }

    public void auA() {
        if (this.eWT != null) {
            this.eWT.auA();
        }
    }

    public void bjY() {
        if (this.eWT != null) {
            this.eWT.bjY();
        }
    }

    public void bjZ() {
        if (this.eWT != null) {
            this.eWT.bjZ();
        }
    }

    public void bka() {
        if (this.eWT != null) {
            this.eWT.bka();
        }
    }
}
