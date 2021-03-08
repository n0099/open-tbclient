package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b iTJ;
    private f iTK;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iTK = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b MU() {
        if (this.iTJ == null) {
            this.iTJ = new b(this.mContext, this.iTK);
        }
        return this.iTJ;
    }
}
