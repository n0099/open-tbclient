package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRoomWatermarkView gQr;

    public void bZp() {
        if (this.gQr != null && this.gQr.getParent() != null) {
            ((ViewGroup) this.gQr.getParent()).removeView(this.gQr);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.gQr != null) {
            this.gQr.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.gQr != null) {
            this.gQr.setVisibility(i);
        }
    }
}
