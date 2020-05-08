package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public AlaLiveRecorder fFH;
    public FrameLayout fFI;
    public com.baidu.tieba.ala.liveroom.master.a.d fFJ;
    public com.baidu.live.ar.f fFK;
    public AlaLiveRecorderPerfData fFL;
    public com.baidu.live.tieba.e.b fFM;
    public com.baidu.live.liveroom.middleware.a fFN;
    public com.baidu.tieba.ala.liveroom.m.c fFh;
    public AlaLiveView fFi;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bvh() {
        return this.liveType;
    }

    public void qs(int i) {
        this.liveType = i;
        if (this.fFJ != null) {
            this.fFJ.qQ(i);
        }
    }

    public void f(short s) {
        if (this.fFJ != null) {
            this.fFJ.f(s);
        }
    }

    public void Ho() {
        if (this.fFJ != null) {
            this.fFJ.Ho();
        }
    }

    public void aFe() {
        if (this.fFJ != null) {
            this.fFJ.aFe();
        }
    }

    public void bvi() {
        if (this.fFJ != null) {
            this.fFJ.bvi();
        }
    }

    public void bvj() {
        if (this.fFJ != null) {
            this.fFJ.bvj();
        }
    }

    public void bvk() {
        if (this.fFJ != null) {
            this.fFJ.bvk();
        }
    }
}
