package com.baidu.tieba.f;

import android.content.Context;
import android.content.Intent;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class a {
    private Context a;
    private Intent b;

    public a(Context context) {
        this.a = null;
        this.b = null;
        if (context == null) {
            throw new InvalidParameterException("ActivitySwitch context null");
        }
        this.a = context;
        this.b = new Intent();
    }

    public final Context c() {
        return this.a;
    }

    public final Intent d() {
        return this.b;
    }

    public final void e() {
        this.a.startActivity(this.b);
    }
}
