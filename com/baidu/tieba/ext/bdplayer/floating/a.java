package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b iEx;
    private f iEy;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iEy = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b PA() {
        if (this.iEx == null) {
            this.iEx = new b(this.mContext, this.iEy);
        }
        return this.iEx;
    }
}
