package com.baidu.tieba.ala.liveroom.data;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.ar.k;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes10.dex */
public class e {
    public AlaLiveRecorder hDH;
    public View hDI;
    public FrameLayout hDJ;
    public ViewGroup hDK;
    public com.baidu.tieba.ala.liveroom.master.a.d hDL;
    public k hDM;
    public AlaLiveRecorderPerfData hDN;
    public com.baidu.live.tieba.e.b hDO;
    public com.baidu.live.liveroom.middleware.a hDP;
    public com.baidu.tieba.ala.liveroom.n.d hDq;
    public AlaLiveView hDr;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bRl() {
        return this.liveType;
    }

    public void vw(int i) {
        this.liveType = i;
        if (this.hDL != null) {
            this.hDL.vY(i);
        }
    }

    public void g(short s) {
        if (this.hDL != null) {
            this.hDL.g(s);
        }
    }

    public void Xl() {
        if (this.hDL != null) {
            this.hDL.Xl();
        }
    }

    public void ceN() {
        if (this.hDL != null) {
            this.hDL.ceN();
        }
    }

    public void ceO() {
        if (this.hDL != null) {
            this.hDL.ceO();
        }
    }

    public void ceP() {
        if (this.hDL != null) {
            this.hDL.ceP();
        }
    }

    public void ceQ() {
        if (this.hDL != null) {
            this.hDL.ceQ();
        }
    }
}
