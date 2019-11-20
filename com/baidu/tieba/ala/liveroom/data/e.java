package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes6.dex */
public class e {
    public ViewGroup AE;
    public com.baidu.tieba.ala.liveroom.m.c eeL;
    public AlaLiveView eeM;
    public AlaLiveRecorder efe;
    public com.baidu.tieba.ala.liveroom.master.a.d eff;
    public AlaLiveRecorderPerfData efg;
    public com.baidu.live.tieba.e.b efh;
    private int liveType;
    public TbPageContext pageContext;

    public int aRJ() {
        return this.liveType;
    }

    public void nw(int i) {
        this.liveType = i;
        if (this.eff != null) {
            this.eff.nS(i);
        }
    }

    public void c(short s) {
        if (this.eff != null) {
            this.eff.c(s);
        }
    }

    public void aRK() {
        if (this.eff != null) {
            this.eff.aRK();
        }
    }

    public void aRL() {
        if (this.eff != null) {
            this.eff.aRL();
        }
    }

    public void aRM() {
        if (this.eff != null) {
            this.eff.aRM();
        }
    }

    public void aRN() {
        if (this.eff != null) {
            this.eff.aRN();
        }
    }

    public void aRO() {
        if (this.eff != null) {
            this.eff.aRO();
        }
    }
}
