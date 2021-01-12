package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes10.dex */
public class a {
    private AlaLiveRoomWatermarkView hNS;

    public void ckK() {
        if (this.hNS != null && this.hNS.getParent() != null) {
            ((ViewGroup) this.hNS.getParent()).removeView(this.hNS);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hNS != null) {
            this.hNS.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hNS != null) {
            this.hNS.setVisibility(i);
        }
    }
}
