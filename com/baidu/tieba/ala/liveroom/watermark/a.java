package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRoomWatermarkView hfo;

    public void ccN() {
        if (this.hfo != null && this.hfo.getParent() != null) {
            ((ViewGroup) this.hfo.getParent()).removeView(this.hfo);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hfo != null) {
            this.hfo.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hfo != null) {
            this.hfo.setVisibility(i);
        }
    }
}
