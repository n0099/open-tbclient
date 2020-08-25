package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b hEp;
    private f hEq;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.hEq = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b Lq() {
        if (this.hEp == null) {
            this.hEp = new b(this.mContext, this.hEq);
        }
        return this.hEp;
    }
}
