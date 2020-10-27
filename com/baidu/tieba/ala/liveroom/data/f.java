package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.ar.i;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class f {
    public com.baidu.tieba.ala.liveroom.q.d haB;
    public AlaLiveView haC;
    public AlaLiveRecorder hba;
    public FrameLayout hbb;
    public ViewGroup hbc;
    public com.baidu.tieba.ala.liveroom.master.a.d hbd;
    public i hbe;
    public AlaLiveRecorderPerfData hbf;
    public com.baidu.live.tieba.e.b hbg;
    public com.baidu.live.liveroom.middleware.a hbh;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bYP() {
        return this.liveType;
    }

    public void vo(int i) {
        this.liveType = i;
        if (this.hbd != null) {
            this.hbd.vQ(i);
        }
    }

    public void g(short s) {
        if (this.hbd != null) {
            this.hbd.g(s);
        }
    }

    public void TS() {
        if (this.hbd != null) {
            this.hbd.TS();
        }
    }

    public void bcW() {
        if (this.hbd != null) {
            this.hbd.bcW();
        }
    }

    public void bYQ() {
        if (this.hbd != null) {
            this.hbd.bYQ();
        }
    }

    public void bYR() {
        if (this.hbd != null) {
            this.hbd.bYR();
        }
    }

    public void bYS() {
        if (this.hbd != null) {
            this.hbd.bYS();
        }
    }
}
