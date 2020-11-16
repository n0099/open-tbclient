package com.baidu.tieba.ala.liveroom.data;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.ar.j;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class e {
    public AlaLiveRecorder hgB;
    public View hgC;
    public FrameLayout hgD;
    public ViewGroup hgE;
    public com.baidu.tieba.ala.liveroom.master.a.d hgF;
    public j hgG;
    public AlaLiveRecorderPerfData hgH;
    public com.baidu.live.tieba.e.b hgI;
    public com.baidu.live.liveroom.middleware.a hgJ;
    public com.baidu.tieba.ala.liveroom.q.d hgk;
    public AlaLiveView hgl;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int caK() {
        return this.liveType;
    }

    public void vZ(int i) {
        this.liveType = i;
        if (this.hgF != null) {
            this.hgF.wB(i);
        }
    }

    public void g(short s) {
        if (this.hgF != null) {
            this.hgF.g(s);
        }
    }

    public void VJ() {
        if (this.hgF != null) {
            this.hgF.VJ();
        }
    }

    public void beP() {
        if (this.hgF != null) {
            this.hgF.beP();
        }
    }

    public void caL() {
        if (this.hgF != null) {
            this.hgF.caL();
        }
    }

    public void caM() {
        if (this.hgF != null) {
            this.hgF.caM();
        }
    }

    public void caN() {
        if (this.hgF != null) {
            this.hgF.caN();
        }
    }
}
