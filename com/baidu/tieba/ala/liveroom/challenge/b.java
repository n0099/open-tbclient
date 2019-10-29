package com.baidu.tieba.ala.liveroom.challenge;

import android.content.Context;
import com.baidu.live.challenge.g;
import com.baidu.live.challenge.k;
/* loaded from: classes6.dex */
public class b implements g {
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.challenge.g
    public k nE() {
        return new com.baidu.tieba.ala.liveroom.challenge.panel.d(this.mContext);
    }

    @Override // com.baidu.live.challenge.g
    public com.baidu.live.challenge.e nF() {
        return new com.baidu.tieba.ala.liveroom.challenge.view.a(this.mContext);
    }
}
