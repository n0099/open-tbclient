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
    public AlaLiveRecorder hBK;
    public View hBL;
    public FrameLayout hBM;
    public ViewGroup hBN;
    public com.baidu.tieba.ala.liveroom.master.a.d hBO;
    public k hBP;
    public AlaLiveRecorderPerfData hBQ;
    public com.baidu.live.tieba.e.b hBR;
    public com.baidu.live.liveroom.middleware.a hBS;
    public com.baidu.tieba.ala.liveroom.n.d hBt;
    public AlaLiveView hBu;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int bQY() {
        return this.liveType;
    }

    public void vu(int i) {
        this.liveType = i;
        if (this.hBO != null) {
            this.hBO.vW(i);
        }
    }

    public void g(short s) {
        if (this.hBO != null) {
            this.hBO.g(s);
        }
    }

    public void Xi() {
        if (this.hBO != null) {
            this.hBO.Xi();
        }
    }

    public void ceA() {
        if (this.hBO != null) {
            this.hBO.ceA();
        }
    }

    public void ceB() {
        if (this.hBO != null) {
            this.hBO.ceB();
        }
    }

    public void ceC() {
        if (this.hBO != null) {
            this.hBO.ceC();
        }
    }

    public void ceD() {
        if (this.hBO != null) {
            this.hBO.ceD();
        }
    }
}
