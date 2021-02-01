package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b iRM;
    private f iRN;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iRN = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b MR() {
        if (this.iRM == null) {
            this.iRM = new b(this.mContext, this.iRN);
        }
        return this.iRM;
    }
}
