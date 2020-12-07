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
    public com.baidu.tieba.ala.liveroom.p.d hpR;
    public AlaLiveView hpS;
    public AlaLiveRecorder hqi;
    public View hqj;
    public FrameLayout hqk;
    public ViewGroup hql;
    public com.baidu.tieba.ala.liveroom.master.a.d hqm;
    public j hqn;
    public AlaLiveRecorderPerfData hqo;
    public com.baidu.live.tieba.e.b hqp;
    public com.baidu.live.liveroom.middleware.a hqq;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int ceF() {
        return this.liveType;
    }

    public void wE(int i) {
        this.liveType = i;
        if (this.hqm != null) {
            this.hqm.xg(i);
        }
    }

    public void g(short s) {
        if (this.hqm != null) {
            this.hqm.g(s);
        }
    }

    public void Yj() {
        if (this.hqm != null) {
            this.hqm.Yj();
        }
    }

    public void bhU() {
        if (this.hqm != null) {
            this.hqm.bhU();
        }
    }

    public void ceG() {
        if (this.hqm != null) {
            this.hqm.ceG();
        }
    }

    public void ceH() {
        if (this.hqm != null) {
            this.hqm.ceH();
        }
    }

    public void ceI() {
        if (this.hqm != null) {
            this.hqm.ceI();
        }
    }
}
