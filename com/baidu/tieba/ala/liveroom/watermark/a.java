package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes11.dex */
public class a {
    private AlaLiveRoomWatermarkView hSo;

    public void clI() {
        if (this.hSo != null && this.hSo.getParent() != null) {
            ((ViewGroup) this.hSo.getParent()).removeView(this.hSo);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hSo != null) {
            this.hSo.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hSo != null) {
            this.hSo.setVisibility(i);
        }
    }
}
