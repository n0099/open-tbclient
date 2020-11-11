package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b isR;
    private f isS;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.isS = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b NR() {
        if (this.isR == null) {
            this.isR = new b(this.mContext, this.isS);
        }
        return this.isR;
    }
}
