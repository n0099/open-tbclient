package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b hEv;
    private f hEw;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.hEw = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b Lq() {
        if (this.hEv == null) {
            this.hEv = new b(this.mContext, this.hEw);
        }
        return this.hEv;
    }
}
