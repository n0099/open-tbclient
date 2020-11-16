package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRoomWatermarkView hwR;

    public void chO() {
        if (this.hwR != null && this.hwR.getParent() != null) {
            ((ViewGroup) this.hwR.getParent()).removeView(this.hwR);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hwR != null) {
            this.hwR.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hwR != null) {
            this.hwR.setVisibility(i);
        }
    }
}
