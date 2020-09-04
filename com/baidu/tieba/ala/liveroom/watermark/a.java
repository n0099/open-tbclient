package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes7.dex */
public class a {
    private AlaLiveRoomWatermarkView gNb;

    public void bXI() {
        if (this.gNb != null && this.gNb.getParent() != null) {
            ((ViewGroup) this.gNb.getParent()).removeView(this.gNb);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.gNb != null) {
            this.gNb.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.gNb != null) {
            this.gNb.setVisibility(i);
        }
    }
}
