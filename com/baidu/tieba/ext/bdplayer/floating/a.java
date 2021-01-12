package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b iMe;
    private f iMf;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iMf = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b Lt() {
        if (this.iMe == null) {
            this.iMe = new b(this.mContext, this.iMf);
        }
        return this.iMe;
    }
}
