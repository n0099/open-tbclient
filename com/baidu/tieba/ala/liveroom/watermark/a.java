package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRoomWatermarkView hGy;

    public void clK() {
        if (this.hGy != null && this.hGy.getParent() != null) {
            ((ViewGroup) this.hGy.getParent()).removeView(this.hGy);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hGy != null) {
            this.hGy.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hGy != null) {
            this.hGy.setVisibility(i);
        }
    }
}
