package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b itF;
    private f itG;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.itG = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b Ni() {
        if (this.itF == null) {
            this.itF = new b(this.mContext, this.itG);
        }
        return this.itF;
    }
}
