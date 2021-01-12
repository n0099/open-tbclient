package com.baidu.tieba.ext.bdplayer.a;

import android.content.Context;
import com.baidu.live.liveroom.e.e;
/* loaded from: classes10.dex */
public class c implements e {
    private String iMz;

    public c(Context context, String str) {
        d.gk(context);
        this.iMz = str;
    }

    @Override // com.baidu.live.liveroom.e.e
    public com.baidu.live.liveroom.e.d aZ(Context context) {
        return new d(this.iMz);
    }
}
