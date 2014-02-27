package com.baidu.tieba.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
public final class c extends com.baidu.tieba.f.a {
    private UserData a;

    public c(Context context, long j, String str, String str2, int i) {
        super(context);
        this.a = null;
        UserData userData = new UserData(j, str, str2, i);
        this.a = userData;
        Intent d = d();
        d.putExtra("is_accept_notify", true);
        d.putExtra("chat_mode", 1);
        d.putExtra("user", userData);
        d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    public final UserData a() {
        return this.a;
    }
}
