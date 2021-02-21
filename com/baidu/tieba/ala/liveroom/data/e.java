package com.baidu.tieba.ala.liveroom.data;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.ar.k;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes11.dex */
public class e {
    public com.baidu.tieba.ala.liveroom.n.d hBH;
    public AlaLiveView hBI;
    public AlaLiveRecorder hBY;
    public View hBZ;
    public FrameLayout hCa;
    public ViewGroup hCb;
    public com.baidu.tieba.ala.liveroom.master.a.d hCc;
    public k hCd;
    public AlaLiveRecorderPerfData hCe;
    public com.baidu.live.tieba.e.b hCf;
    public com.baidu.live.liveroom.middleware.a hCg;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bRf() {
        return this.liveType;
    }

    public void vu(int i) {
        this.liveType = i;
        if (this.hCc != null) {
            this.hCc.vW(i);
        }
    }

    public void g(short s) {
        if (this.hCc != null) {
            this.hCc.g(s);
        }
    }

    public void Xi() {
        if (this.hCc != null) {
            this.hCc.Xi();
        }
    }

    public void ceH() {
        if (this.hCc != null) {
            this.hCc.ceH();
        }
    }

    public void ceI() {
        if (this.hCc != null) {
            this.hCc.ceI();
        }
    }

    public void ceJ() {
        if (this.hCc != null) {
            this.hCc.ceJ();
        }
    }

    public void ceK() {
        if (this.hCc != null) {
            this.hCc.ceK();
        }
    }
}
