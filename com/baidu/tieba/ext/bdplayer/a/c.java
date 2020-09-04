package com.baidu.tieba.ext.bdplayer.a;

import android.content.Context;
import com.baidu.live.liveroom.e.e;
/* loaded from: classes7.dex */
public class c implements e {
    private String hEQ;

    public c(Context context, String str) {
        d.eZ(context);
        this.hEQ = str;
    }

    @Override // com.baidu.live.liveroom.e.e
    public com.baidu.live.liveroom.e.d au(Context context) {
        return new d(this.hEQ);
    }
}
