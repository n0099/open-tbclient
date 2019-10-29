package com.baidu.tieba.ala.liveroom.data;

import android.view.ViewGroup;
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes6.dex */
public class e {
    public ViewGroup Bg;
    public com.baidu.tieba.ala.liveroom.m.c efC;
    public AlaLiveView efD;
    public AlaLiveRecorder efV;
    public com.baidu.tieba.ala.liveroom.master.a.d efW;
    public AlaLiveRecorderPerfData efX;
    public com.baidu.live.tieba.e.b efY;
    private int liveType;
    public TbPageContext pageContext;

    public int aRL() {
        return this.liveType;
    }

    public void nx(int i) {
        this.liveType = i;
        if (this.efW != null) {
            this.efW.nT(i);
        }
    }

    public void d(short s) {
        if (this.efW != null) {
            this.efW.d(s);
        }
    }

    public void aRM() {
        if (this.efW != null) {
            this.efW.aRM();
        }
    }

    public void aRN() {
        if (this.efW != null) {
            this.efW.aRN();
        }
    }

    public void aRO() {
        if (this.efW != null) {
            this.efW.aRO();
        }
    }

    public void aRP() {
        if (this.efW != null) {
            this.efW.aRP();
        }
    }

    public void aRQ() {
        if (this.efW != null) {
            this.efW.aRQ();
        }
    }
}
