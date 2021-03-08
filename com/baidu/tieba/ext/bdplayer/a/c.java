package com.baidu.tieba.ext.bdplayer.a;

import android.content.Context;
import com.baidu.live.liveroom.e.e;
/* loaded from: classes10.dex */
public class c implements e {
    private String iUd;

    public c(Context context, String str) {
        d.gk(context);
        this.iUd = str;
    }

    @Override // com.baidu.live.liveroom.e.e
    public com.baidu.live.liveroom.e.d aY(Context context) {
        return new d(this.iUd);
    }
}
