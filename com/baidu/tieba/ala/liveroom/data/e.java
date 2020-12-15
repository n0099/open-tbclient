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
    public com.baidu.tieba.ala.liveroom.p.d hpT;
    public AlaLiveView hpU;
    public AlaLiveRecorder hqk;
    public View hql;
    public FrameLayout hqm;
    public ViewGroup hqn;
    public com.baidu.tieba.ala.liveroom.master.a.d hqo;
    public j hqp;
    public AlaLiveRecorderPerfData hqq;
    public com.baidu.live.tieba.e.b hqr;
    public com.baidu.live.liveroom.middleware.a hqs;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int ceG() {
        return this.liveType;
    }

    public void wE(int i) {
        this.liveType = i;
        if (this.hqo != null) {
            this.hqo.xg(i);
        }
    }

    public void g(short s) {
        if (this.hqo != null) {
            this.hqo.g(s);
        }
    }

    public void Yj() {
        if (this.hqo != null) {
            this.hqo.Yj();
        }
    }

    public void bhU() {
        if (this.hqo != null) {
            this.hqo.bhU();
        }
    }

    public void ceH() {
        if (this.hqo != null) {
            this.hqo.ceH();
        }
    }

    public void ceI() {
        if (this.hqo != null) {
            this.hqo.ceI();
        }
    }

    public void ceJ() {
        if (this.hqo != null) {
            this.hqo.ceJ();
        }
    }
}
