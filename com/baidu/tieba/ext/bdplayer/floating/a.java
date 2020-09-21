package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b hLx;
    private f hLy;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.hLy = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b LS() {
        if (this.hLx == null) {
            this.hLx = new b(this.mContext, this.hLy);
        }
        return this.hLx;
    }
}
