package com.baidu.tieba.ext.bdplayer.a;

import android.content.Context;
import com.baidu.live.liveroom.e.e;
/* loaded from: classes4.dex */
public class c implements e {
    private String itm;

    public c(Context context, String str) {
        d.fn(context);
        this.itm = str;
    }

    @Override // com.baidu.live.liveroom.e.e
    public com.baidu.live.liveroom.e.d ax(Context context) {
        return new d(this.itm);
    }
}
