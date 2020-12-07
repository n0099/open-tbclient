package com.baidu.tieba.ext.bdplayer.a;

import android.content.Context;
import com.baidu.live.liveroom.e.e;
/* loaded from: classes4.dex */
public class c implements e {
    private String iES;

    public c(Context context, String str) {
        d.fT(context);
        this.iES = str;
    }

    @Override // com.baidu.live.liveroom.e.e
    public com.baidu.live.liveroom.e.d bb(Context context) {
        return new d(this.iES);
    }
}
