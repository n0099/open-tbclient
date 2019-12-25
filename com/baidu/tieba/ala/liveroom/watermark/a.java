package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class a {
    private AlaLiveRoomWatermarkView fhR;

    public void boK() {
        if (this.fhR != null && this.fhR.getParent() != null) {
            ((ViewGroup) this.fhR.getParent()).removeView(this.fhR);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.fhR != null) {
            this.fhR.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.fhR != null) {
            this.fhR.setVisibility(i);
        }
    }
}
