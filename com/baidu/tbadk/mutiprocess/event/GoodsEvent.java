package com.baidu.tbadk.mutiprocess.event;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes3.dex */
public class GoodsEvent extends SerializableEvent {
    public boolean dispose;
    public String goodsList;

    public GoodsEvent(String str) {
        this.goodsList = str;
    }

    public boolean getDispose() {
        return this.dispose;
    }

    public String getGoodsList() {
        return this.goodsList;
    }

    public void setDispost(boolean z) {
        this.dispose = z;
    }
}
