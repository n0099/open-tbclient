package com.baidu.tieba.ext.bdplayer.a;

import android.content.Context;
import com.baidu.live.liveroom.e.e;
/* loaded from: classes11.dex */
public class c implements e {
    private String iRg;

    public c(Context context, String str) {
        d.gm(context);
        this.iRg = str;
    }

    @Override // com.baidu.live.liveroom.e.e
    public com.baidu.live.liveroom.e.d ba(Context context) {
        return new d(this.iRg);
    }
}
