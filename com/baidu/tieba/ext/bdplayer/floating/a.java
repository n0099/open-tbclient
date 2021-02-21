package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b iSa;
    private f iSb;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iSb = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b MR() {
        if (this.iSa == null) {
            this.iSa = new b(this.mContext, this.iSb);
        }
        return this.iSa;
    }
}
