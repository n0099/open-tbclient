package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes6.dex */
public class a {
    private AlaLiveRoomWatermarkView erz;

    public void aWW() {
        if (this.erz != null && this.erz.getParent() != null) {
            ((ViewGroup) this.erz.getParent()).removeView(this.erz);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.erz != null) {
            this.erz.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.erz != null) {
            this.erz.setVisibility(i);
        }
    }
}
