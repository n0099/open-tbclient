package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b imT;
    private f imU;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.imU = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b Nr() {
        if (this.imT == null) {
            this.imT = new b(this.mContext, this.imU);
        }
        return this.imT;
    }
}
