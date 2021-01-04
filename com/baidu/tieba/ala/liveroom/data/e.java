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
    public com.baidu.tieba.ala.liveroom.p.d hBP;
    public AlaLiveView hBQ;
    public AlaLiveRecorder hCg;
    public View hCh;
    public FrameLayout hCi;
    public ViewGroup hCj;
    public com.baidu.tieba.ala.liveroom.master.a.d hCk;
    public k hCl;
    public AlaLiveRecorderPerfData hCm;
    public com.baidu.live.tieba.e.b hCn;
    public com.baidu.live.liveroom.middleware.a hCo;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bUl() {
        return this.liveType;
    }

    public void wP(int i) {
        this.liveType = i;
        if (this.hCk != null) {
            this.hCk.xr(i);
        }
    }

    public void g(short s) {
        if (this.hCk != null) {
            this.hCk.g(s);
        }
    }

    public void Zr() {
        if (this.hCk != null) {
            this.hCk.Zr();
        }
    }

    public void chw() {
        if (this.hCk != null) {
            this.hCk.chw();
        }
    }

    public void chx() {
        if (this.hCk != null) {
            this.hCk.chx();
        }
    }

    public void chy() {
        if (this.hCk != null) {
            this.hCk.chy();
        }
    }

    public void chz() {
        if (this.hCk != null) {
            this.hCk.chz();
        }
    }
}
