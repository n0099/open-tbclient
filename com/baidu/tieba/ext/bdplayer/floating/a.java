package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.liveroom.e.c {
    private com.baidu.live.liveroom.e.b iQL;
    private f iQM;
    private Context mContext;

    public a(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iQM = fVar;
    }

    @Override // com.baidu.live.liveroom.e.c
    public com.baidu.live.liveroom.e.b Po() {
        if (this.iQL == null) {
            this.iQL = new b(this.mContext, this.iQM);
        }
        return this.iQL;
    }
}
