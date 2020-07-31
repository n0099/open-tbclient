package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRoomWatermarkView gAA;

    public void bNH() {
        if (this.gAA != null && this.gAA.getParent() != null) {
            ((ViewGroup) this.gAA.getParent()).removeView(this.gAA);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.gAA != null) {
            this.gAA.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.gAA != null) {
            this.gAA.setVisibility(i);
        }
    }
}
