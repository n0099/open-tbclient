package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes11.dex */
public class a {
    private AlaLiveRoomWatermarkView hSC;

    public void clP() {
        if (this.hSC != null && this.hSC.getParent() != null) {
            ((ViewGroup) this.hSC.getParent()).removeView(this.hSC);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hSC != null) {
            this.hSC.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hSC != null) {
            this.hSC.setVisibility(i);
        }
    }
}
