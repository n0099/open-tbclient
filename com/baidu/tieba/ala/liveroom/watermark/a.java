package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRoomWatermarkView hrn;

    public void cfT() {
        if (this.hrn != null && this.hrn.getParent() != null) {
            ((ViewGroup) this.hrn.getParent()).removeView(this.hrn);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hrn != null) {
            this.hrn.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hrn != null) {
            this.hrn.setVisibility(i);
        }
    }
}
