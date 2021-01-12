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
    public AlaLiveRecorder hxA;
    public View hxB;
    public FrameLayout hxC;
    public ViewGroup hxD;
    public com.baidu.tieba.ala.liveroom.master.a.d hxE;
    public k hxF;
    public AlaLiveRecorderPerfData hxG;
    public com.baidu.live.tieba.e.b hxH;
    public com.baidu.live.liveroom.middleware.a hxI;
    public com.baidu.tieba.ala.liveroom.p.d hxj;
    public AlaLiveView hxk;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bQu() {
        return this.liveType;
    }

    public void vj(int i) {
        this.liveType = i;
        if (this.hxE != null) {
            this.hxE.vL(i);
        }
    }

    public void g(short s) {
        if (this.hxE != null) {
            this.hxE.g(s);
        }
    }

    public void Vz() {
        if (this.hxE != null) {
            this.hxE.Vz();
        }
    }

    public void cdF() {
        if (this.hxE != null) {
            this.hxE.cdF();
        }
    }

    public void cdG() {
        if (this.hxE != null) {
            this.hxE.cdG();
        }
    }

    public void cdH() {
        if (this.hxE != null) {
            this.hxE.cdH();
        }
    }

    public void cdI() {
        if (this.hxE != null) {
            this.hxE.cdI();
        }
    }
}
