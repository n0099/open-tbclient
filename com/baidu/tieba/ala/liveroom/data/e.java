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
    public com.baidu.tieba.ala.liveroom.q.d hgD;
    public AlaLiveView hgE;
    public AlaLiveRecorder hgU;
    public View hgV;
    public FrameLayout hgW;
    public ViewGroup hgX;
    public com.baidu.tieba.ala.liveroom.master.a.d hgY;
    public j hgZ;
    public AlaLiveRecorderPerfData hha;
    public com.baidu.live.tieba.e.b hhb;
    public com.baidu.live.liveroom.middleware.a hhc;
    private int liveType;
    public TbPageContext pageContext;
    public ViewGroup rootView;

    public int cbr() {
        return this.liveType;
    }

    public void vB(int i) {
        this.liveType = i;
        if (this.hgY != null) {
            this.hgY.wd(i);
        }
    }

    public void g(short s) {
        if (this.hgY != null) {
            this.hgY.g(s);
        }
    }

    public void Ws() {
        if (this.hgY != null) {
            this.hgY.Ws();
        }
    }

    public void bfw() {
        if (this.hgY != null) {
            this.hgY.bfw();
        }
    }

    public void cbs() {
        if (this.hgY != null) {
            this.hgY.cbs();
        }
    }

    public void cbt() {
        if (this.hgY != null) {
            this.hgY.cbt();
        }
    }

    public void cbu() {
        if (this.hgY != null) {
            this.hgY.cbu();
        }
    }
}
