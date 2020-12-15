package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private f iEA;
    private com.baidu.live.liveroom.e.b iEz;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iEA = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b PA() {
        if (this.iEz == null) {
            this.iEz = new b(this.mContext, this.iEA);
        }
        return this.iEz;
    }
}
