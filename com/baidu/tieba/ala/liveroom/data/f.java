package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class f {
    public com.baidu.tieba.ala.liveroom.n.c gfS;
    public AlaLiveView gfT;
    public AlaLiveRecorder ggs;
    public FrameLayout ggt;
    public ViewGroup ggu;
    public com.baidu.tieba.ala.liveroom.master.a.d ggv;
    public com.baidu.live.ar.h ggw;
    public AlaLiveRecorderPerfData ggx;
    public com.baidu.live.tieba.e.b ggy;
    public com.baidu.live.liveroom.middleware.a ggz;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bEl() {
        return this.liveType;
    }

    public void ru(int i) {
        this.liveType = i;
        if (this.ggv != null) {
            this.ggv.rR(i);
        }
    }

    public void f(short s) {
        if (this.ggv != null) {
            this.ggv.f(s);
        }
    }

    public void Ku() {
        if (this.ggv != null) {
            this.ggv.Ku();
        }
    }

    public void aLF() {
        if (this.ggv != null) {
            this.ggv.aLF();
        }
    }

    public void bEm() {
        if (this.ggv != null) {
            this.ggv.bEm();
        }
    }

    public void bEn() {
        if (this.ggv != null) {
            this.ggv.bEn();
        }
    }

    public void bEo() {
        if (this.ggv != null) {
            this.ggv.bEo();
        }
    }
}
