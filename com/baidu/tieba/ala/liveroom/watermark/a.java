package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes7.dex */
public class a {
    private AlaLiveRoomWatermarkView gMX;

    public void bXH() {
        if (this.gMX != null && this.gMX.getParent() != null) {
            ((ViewGroup) this.gMX.getParent()).removeView(this.gMX);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.gMX != null) {
            this.gMX.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.gMX != null) {
            this.gMX.setVisibility(i);
        }
    }
}
